package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class SubtractOperator extends Operator {
    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        Operand sum= new Operand(operandOne.getValue() - operandTwo.getValue());
        return sum;
    }
    @Override
    public int priority() {
        return 1;
    }
}
