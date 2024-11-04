package com.example.xlang;

import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

public class PatternMatcher {
    private static final String WS = "\\ +";
    private static final String IDENTIFIER = "[a-zA-Z$_][a-zA-Z0-9$_]*";
    private static final String INTEGER = "[0-9]+";
    private static final String FLOAT = INTEGER + "\\." + INTEGER;
    private static final String OPERAND = INTEGER + "|" + FLOAT + "|" + IDENTIFIER;
    private static final String MATH_OPERATION = "(" + OPERAND + ")" + WS + "[+-/*]" + WS + "(" + OPERAND + ")";
    private static final String RVALUE = "(" + IDENTIFIER + "|" + INTEGER + "|" + FLOAT + "|" + MATH_OPERATION + ")";

    public static final String VARIABLE_DECLARATION = "(int|float)" + WS + IDENTIFIER + "(" + WS + "=" + WS + RVALUE + ")?";
    public static final String ASSIGNMENT = IDENTIFIER + WS + "=" + WS + RVALUE;
    public static final String START_FOR = "for" + WS + INTEGER;
    public static final String END_FOR = "end" + WS + "for";
    public static final String PRINT = "print" + WS + RVALUE;
    public static final String NUMBER = "(" + INTEGER + "|" + FLOAT + ")";

    public static void mustMatchIdentifier(String input) {
        if(!input.matches(IDENTIFIER))
            throw new SyntaxException("error");
    }

    public static boolean isNumber(String input) {
        return input.matches(INTEGER) || input.matches(FLOAT);
    }

    public static boolean isInteger(String input) {
        return input.matches(INTEGER);
    }

}
