/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.exercise6;

import java.util.Scanner;

/**
 *
 * @author A23DavidCG
 */
public class Exercise6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe a palabra que queiras buscar");
        String word = sc.nextLine();
        System.out.println("Escribe a ruta do archivo completa donde queiras contabilizar as palabaras");
        String archivo = sc.nextLine();
        var pb = new ProcessBuilder();
        pb.redirectInput(new File("textoExercicio6.txt"));
        pb.redirectOutput(new File("lixo.txt"));        
        pb.command("cmd.exe", "find /c " + word + archivo);

        //Escribir el numero que recuperamos ejecutando el comando en cmd en otro archivo
    }
}
