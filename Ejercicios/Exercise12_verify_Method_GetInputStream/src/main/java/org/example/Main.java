package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //Crear un prgrama que ejecute una comprobacion md5

        ProcessBuilder pb = new ProcessBuilder();

        //CANDO SE FAI EN VARIAS LIÑAS HAI QUE POÑERLLE O . ADD DESPOIS DO COMMAND
        pb.command().add("cmd.exe");
        pb.command().add("/C");
        pb.command().add("certutil");
        pb.command().add("-hashfile");
        pb.command().add("C:\\Users\\A23DavidCG\\Desktop\\testing.txt");
        pb.command().add("MD5");


//        pb.command("cmd.exe", "/C", "certutil", "-hashfile", "C:\\Users\\A23DavidCG\\Desktop\\testing.txt", "MD5");
        Process MD5 = pb.start();


        BufferedReader reader = new BufferedReader(
                new InputStreamReader(MD5.getInputStream()));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(">" + line);
        }
        reader.close();


    }
}