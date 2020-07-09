package edu.csc413.calculator.evaluator;

import edu.csc413.calculator.exceptions.InvalidTokenException;
import sun.tools.jstat.Operator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField expressionTextField = new TextField();
    private Panel buttonPanel = new Panel();
    Evaluator calculator=new Evaluator();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] buttonText = {
        "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[buttonText.length];

    public static void main(String argv[]) {
        new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.expressionTextField.setPreferredSize(new Dimension(600, 50));
        this.expressionTextField.setFont(new Font("Courier", Font.BOLD, 28));

        add(expressionTextField, BorderLayout.NORTH);
        expressionTextField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        Button tempButtonReference;
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            tempButtonReference = new Button(buttonText[i]);
            tempButtonReference.setFont(new Font("Courier", Font.BOLD, 28));
            buttons[i] = tempButtonReference;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This function is triggered anytime a button is pressed
     * on our Calculator GUI.
     * @param actionEventObject Event object generated when a
     *                    button is pressed.
     */
    public void actionPerformed(ActionEvent actionEventObject) {
        if(actionEventObject.getSource() != buttons[14] && actionEventObject.getSource() != buttons[18]
                &&actionEventObject.getSource() != buttons[19]){
            String keyPressed=actionEventObject.getActionCommand();
            this.expressionTextField.setText(this.expressionTextField.getText() + keyPressed);
        }
        //clear up to last known operator
        else if(actionEventObject.getSource()==buttons[19]){
            String text=expressionTextField.getText();
            int i;
            for(i=text.length();i>=0;i--){
                if(text.charAt(i-1) == '+' || text.charAt(i-1) == '-' || text.charAt(i-1) == '*' || text.charAt(i-1) == '/' || text.charAt(i-1) == '^'){
                    break;
                }
            }
            this.expressionTextField.setText(text.substring(0,i));
        }
        //clear all
        else if(actionEventObject.getSource()==buttons[18]) {
            this.expressionTextField.setText("");
        }
        //evaluate the expression by user
        else if(actionEventObject.getSource()==buttons[14]){
            String eval=expressionTextField.getText();
            int retVal= 0;
            try {
                retVal = calculator.evaluateExpression(eval);
            } catch (InvalidTokenException e) {
                e.printStackTrace();
            }
            this.expressionTextField.setText(String.valueOf(retVal));
        }
    }
}
