package com.example.xlang;

import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Executor {

    private final Memory memory = new Memory();
    private final Processor processor = new Processor();
    private final CommandInterpreter interpreter = new CommandInterpreter(memory, processor);

    public void execute(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        boolean firstStage = true;
        while (scanner.hasNext()) {
            if (firstStage) {
                String line = scanner.nextLine();
                if (line.equals("%%"))
                    firstStage = false;
                else
                    interpreter.declareVariable(line);
            } else {
                StringBuilder builder = new StringBuilder();

                while(scanner.hasNext())
                    builder.append(scanner.nextLine()).append("\n");

                execute(builder.toString(), 1);
            }
        }

        scanner.close();
    }

    public void execute(String statements, int count) {
        for(int i = 0; i < count; i++) {
            Scanner scanner = new Scanner(statements);

            while(scanner.hasNext()) {
                String line = scanner.nextLine();

                if(line.matches(PatternMatcher.PRINT)) {
                    interpreter.print(line);
                } else if(line.matches(PatternMatcher.ASSIGNMENT)) {
                    interpreter.updateVariable(line);
                } else if(line.matches(PatternMatcher.START_FOR)) {
                    int loopCount = 0;

                    int repeatCount = interpreter.getRepeatCount(line);
                    StringBuilder loopStatements = new StringBuilder();

                    String statement = scanner.nextLine();
                    while(!statement.matches(PatternMatcher.END_FOR) || loopCount != 0) {
                        if(statement.matches(PatternMatcher.START_FOR)) {
                            loopCount++;
                        } else if(statement.matches(PatternMatcher.END_FOR)) {
                            loopCount--;
                        }

                        loopStatements.append(statement).append("\n");

                        statement = scanner.nextLine();
                    }

                    execute(loopStatements.toString(), repeatCount);
                } else {
                    throw new SyntaxException("error");
                }
            }
        }
    }

}
