package com.example.xlang;

import com.example.xlang.data.Value;
import com.example.xlang.operator.*;

public class Processor {

    private final Operator multiplierUnit = new MultiplyOperator();
    private final Operator divisionUnit = new DivisionOperator();
    private final Operator subtractionUnit = new SubtractOperator();
    private final Operator sumUnit = new SumOperator();

    public Value calculate(char operator, Value firstValue, Value secondValue) {
        return detectOperation(operator).operate(firstValue, secondValue);
    }

    private Operator detectOperation(char operator) {
        switch (operator) {
            case '+':
                return sumUnit;
            case '-':
                return subtractionUnit;
            case '*':
                return multiplierUnit;
            case '/':
                return divisionUnit;
            default:
                throw new IllegalArgumentException("Unknown operator.");
        }
    }

}
