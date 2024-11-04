package com.example.xlang;

import com.example.xlang.data.Variable;

import java.util.HashMap;
import java.util.Map;

public class Memory {

    private final Map<String, Variable> variables;

    public Memory() {
        variables = new HashMap<>();
    }

    /**
     * Save a new variable or update an existing variable
     * @param variable variable
     */
    public void saveVariable(Variable variable) {
        variables.put(variable.getName(), variable);
    }

    public Variable getVariable(String name) {
        return variables.get(name);
    }

    public boolean hasVariable(String name) {
        return variables.containsKey(name);
    }

}
