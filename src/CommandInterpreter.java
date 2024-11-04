package com.example.xlang;

import com.example.xlang.data.Value;
import com.example.xlang.data.Variable;
import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

import java.util.Scanner;

public class CommandInterpreter {

    private Memory memory;
    private Processor processor;

    public CommandInterpreter(Memory memory, Processor processor){
        this.memory = memory;
        this.processor = processor;
    }

    public void declareVariable(String line) {
        Scanner scanner = new Scanner(line);

        String keyword = scanner.next();
        if(!keyword.equals("int") && !keyword.equals("float"))
            throw new SyntaxException("error");

        boolean isInteger = keyword.equals("int");

        String identifier = scanner.next();
        PatternMatcher.mustMatchIdentifier(identifier);

        Variable variable;

        if(scanner.hasNext()) {
            String assignment = scanner.next();
            if(!assignment.equals("="))
                throw new SyntaxException("error");

            String rightValue = scanner.nextLine();
            Value value = extractValue(rightValue);

            // Try to save a float value to integer variable
            if(isInteger && !value.isInteger())
                throw new SyntaxException("error.");

            variable = new Variable(identifier, value.getValue(), isInteger);
        } else variable = new Variable(identifier, isInteger);

        memory.saveVariable(variable);
    }

    public void updateVariable(String input) {
        Scanner scanner = new Scanner(input);

        String identifier = scanner.next();
        Variable variable = memory.getVariable(identifier);

        // skip '='
        scanner.next();

        String rightValue = scanner.nextLine();
        Value value = extractValue(rightValue);

        variable.setValue(value);
        memory.saveVariable(variable);
    }

    // print x , print 1 , print 1.1
    public void print(String command){
        Scanner printScanner = new Scanner(command);

        // Skip print command
        printScanner.next();

        String parameter = printScanner.nextLine();
        Value value = extractValue(parameter);

        System.out.println(value);
    }

    public int getRepeatCount(String forStatement) {
        Scanner scanner = new Scanner(forStatement);

        scanner.next();

        String countStr = scanner.next();

        return Integer.parseInt(countStr);
    }

    private Value extractValue(String input) {
        input = input.trim();
        if(PatternMatcher.isNumber(input)) {
            double value = Double.parseDouble(input);
            boolean isInteger = PatternMatcher.isInteger(input);
            return new Value(value, isInteger);
        } else if(memory.hasVariable(input)) {
            return memory.getVariable(input);
        } else {
            Scanner scanner = new Scanner(input);

            Value firstOperand = extractValue(scanner.next());
            char operator = scanner.next().charAt(0);
            Value secondOperand = extractValue(scanner.next());

            return processor.calculate(operator, firstOperand, secondOperand);
        }
    }
}
