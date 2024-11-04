package com.example.xlang;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("program.txt");
        Executor executor = new Executor();
        executor.execute(file);
    }
}
