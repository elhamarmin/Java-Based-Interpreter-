package com.example.xlang.operator;

import com.example.xlang.data.Value;

public class SumOperator implements Operator {
    @Override
    public Value operate(Value firstValue, Value secondValue) {
        boolean isInteger = firstValue.isInteger() && secondValue.isInteger();
        double result = firstValue.getValue() + secondValue.getValue();
        return new Value(result, isInteger);
    }
}
