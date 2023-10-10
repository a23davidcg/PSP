/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.pb1;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author A21GonzaloCM
 */
public class Pb1 {

    public static void main(String[] args) throws IOException, InterruptedException {

//        ProcessBuilder pb= new ProcessBuilder("dir", "C:\\");
//        
//        System.out.println(pb.directory());
//DU1 - Exercise 3 - Java ProcessBuilder
//
//Create a program to show what the default directory of execution of a process is. Use the directory() method of ProcessBuilder.
//
//Execute a process that shows the result of the dir command in the C directory.
//
//Request a path to the user and execute a process that shows the result of the dir command in that path.
//        
//        Scanner sc = new Scanner(System.in);
//        
//        System.out.println("Introduce un path: ");
//        String path1= sc.nextLine();
//        File f1= new File(path1);
//        ProcessBuilder pb2= new ProcessBuilder();
//        pb2.directory(f1).command("cmd.exe","/c","dir");
//        pb2.inheritIO();
//        pb2.start();
//        
//        System.out.println("Directorio: " + pb2.directory());
//DU1 - Exercise 4 - Java ProcessBuilder
//
//Create a program to show the execution environment of a process with the ProcessBuilder method Map<String,String> environment().
//
//Execute the process created to echo "Hello World" in the command line.
//        ProcessBuilder pb3 = new ProcessBuilder();
//        pb3.command("cmd.exe", "/c", "echo HelloWorld");
//        pb3.inheritIO();
//        pb3.start();
//        Map<String, String> envir = pb3.environment();
//
//        for (String clave : envir.keySet()) {
//            String valor = envir.get(clave);
//            System.out.println("CLAVE: " + clave + " " + "<=====> VALOR: " + valor);
//        }
//DU1 - Exercise 5 - Java ProcessBuilder
//
//Create a process to launch in the command line a tracert to iessanclemente.net.
//Redirect the process output to a file called outputTracert.txt using the redirectOutput method of ProcessBuilder
//Wait for 500 miliseconds after the start of the process and destroy the process after that time throwing an InterruptedException.
//Verify the content of the outputTracert.txt file.
        ProcessBuilder pb4 = new ProcessBuilder();
        try{
        pb4.command("cmd.exe", "/c", "tracert www.iessanclemente.net");
        pb4.redirectOutput(new File("outputTracert.txt"));
        Process proceso4= pb4.start();
        proceso4.waitFor(500, TimeUnit.MILLISECONDS);
        }catch(InputMismatchException ex) {
         System.out.println("ERROR");
        }
        

    }
}
