package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;


public class AddData {
    public static void main(String[] args) throws IOException {
        //create a program to add the numbers to a file

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), "org.example.PSCalculationsFiles");
        pb.inheritIO();
        pb.redirectOutput(ProcessBuilder.Redirect.to(new File("output.txt")));
        pb.redirectError(ProcessBuilder.Redirect.to(new File("error.txt")));

        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

