package com.example.xlang.operator;

import com.example.xlang.data.Value;

public interface Operator {
    Value operate(Value firstValue, Value secondValue);
}
