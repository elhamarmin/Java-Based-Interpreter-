package com.example.xlang.data;

public class Value {

    protected double value;
    private final boolean isInteger;

    public Value(boolean isInteger) {
        this(0, isInteger);
    }

    public Value(double value) {
        this(value, true);
    }

    public Value(double value, boolean isInteger) {
        this.value = value;
        this.isInteger = isInteger;
    }

    public double getValue() {
        if(isInteger)
            return Math.round(value);
        return value;
    }

    public boolean isInteger() {
        return isInteger;
    }

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
