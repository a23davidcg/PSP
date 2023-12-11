package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        //create the origin and destination files
        try{
            File origin = new File("hola.txt");
            File destination = new File("adios.txt");
            //create a process builder to execute the command find /c "hola" hola.txt
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "find", "/c", "hola", "C:\\Users\\Usuario\\Desktop\\DAM\\2DAM\\Acceso a datos\\Tema 1\\Ejercicios\\Ejercicio 1\\hola.txt");
            //redirect the input and output of the process to the origin and destination files
            pb.redirectInput(ProcessBuilder.Redirect.from(new File(origin.getAbsolutePath())));
            pb.redirectOutput(ProcessBuilder.Redirect.to(new File(destination.getAbsolutePath())));
            //start the process and wait 500 miliseconds
            Process p = pb.start();
            Thread.sleep(500);
            //destroy the process
            p.destroy();
            //verify the process has finished correctly
            if (p.exitValue() == 0) {
                System.out.println("The process has finished correctly");
            } else {
                System.out.println("The process has finished with errors");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}