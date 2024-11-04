package com.example.xlang.data;

public class Variable extends Value {

    private final String name;

    public Variable(String name) {
        super(0);
        this.name = name;
    }

    public Variable(String name, boolean isInteger) {
        super(isInteger);
        this.name = name;
    }

    public Variable(String name, double value) {
        super(value);
        this.name = name;
    }

    public Variable(String name, double value, boolean isInteger) {
        super(value, isInteger);
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setValue(Value value) {
        setValue(value.getValue());
    }

    public String getName() {
        return name;
    }

}
