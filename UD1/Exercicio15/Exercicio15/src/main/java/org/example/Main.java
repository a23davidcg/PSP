package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.example.Encrypt.encryptMessage;

public class Main {
    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.out.println("Encriptar mensaje");
//            System.exit(1);
//        }
//
//        String inputFileName = args[0];

        try (BufferedReader br = new BufferedReader(
                new FileReader("ArchivoACifrar.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                //Facer o launch par aencriptar cada linea d codigo
                String encryptedMessage = encryptMessage(line);
                System.out.println("Original: " + line);
                System.out.println("Encrypted: " + encryptedMessage);
                System.out.println("============================");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            System.exit(1);
        }
    }
}