/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.exercicio4;

import java.io.IOException;
import java.util.Map;

/**
 *
 * @author A23DavidCG
 */
public class Exercicio4 {

    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder();
        Map<String, String> mapa = pb.environment();

        mapa.forEach((s, s2) -> {
            System.out.printf("%s %s %n", s, s2);
        });

        ProcessBuilder pb1 = new ProcessBuilder();
        String hola = "Hello World";
        pb1.command("cmd.exe", "/c", "echo", hola);
        pb1.inheritIO();
        
        try {
            pb1.start();
        } catch (IOException e) {
        }

    }
}
