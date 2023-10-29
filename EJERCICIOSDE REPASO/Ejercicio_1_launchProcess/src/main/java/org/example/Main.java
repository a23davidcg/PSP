package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        //Obtain the number of available processors for the JVM

//        Runtime runtime = Runtime.getRuntime();
//        var processors = runtime.availableProcessors();
//
//        System.out.println(processors);

        //Launch the google Chrome Browser
        Process process =  null;
        try {
            Runtime runtime = Runtime.getRuntime();
            process = runtime.exec("notepad.exe");

            process.waitFor(); //Esperar a que la aplicacion se cirerre



        }catch (Exception e) {

        }

    }
}