package org.example;

import java.io.File;
import java.io.IOException;



public class Launcher {
    public static void main(String[] args) {
        //create a program to launch Main using process builder to redirect the errors to a file

        String classPath = System.getProperty("java.class.path");
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath,  "org.example.Main");
        pb.inheritIO();//PAra mostrar a salida por consola

        pb.redirectError(ProcessBuilder.Redirect.to(new File("error.log")));
        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //redirect the output to aniother file
        pb.redirectOutput(ProcessBuilder.Redirect.to(new File("output.log")));
        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
