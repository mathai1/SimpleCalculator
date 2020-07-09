package edu.csc413.calculator.evaluator;

/**
 * Operand class used to represent an operand
 * in a valid mathematical expression.
 */
public class Operand {
    int test;
    /**
     * construct operand from string token.
     */
    public Operand(String token) {
        this.test= Integer.parseInt(token);
    }

    /**
     * construct operand from integer
     */
    public Operand(int value) {
        this.test=value;
    }

    /**
     * return value of operand
     */
    public int getValue() {
        return test;
    }

    /**
     * Check to see if given token is a valid
     * operand.
     */
    public static boolean check(String token) {
        try{
            Integer.parseInt(token);
        }
        catch(Exception exp){
            return false;
        }
        return true;
    }
}
