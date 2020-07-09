package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class PowerOperator extends Operator {
    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        int op1,op2;
        op1=op2=operandOne.getValue();
        for(int i=1;i<operandTwo.getValue();i++)
            op1=op1*op2;
        Operand sum=new Operand(op1);
        return sum;
    }
    @Override
    public int priority() {
        return 3;
    }
}
