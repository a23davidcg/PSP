package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VowelCount {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java org.example.VowelCount <vowel>");
            System.exit(1);
        }

        String vowel = args[0].toUpperCase(); // Convert to uppercase for case-insensitivity

        try (BufferedReader reader = new BufferedReader(new FileReader("texto.txt"));
             FileWriter writer = new FileWriter(vowel + "output.txt")) {

            int count = 0;
            int charValue;
            while ((charValue = reader.read()) != -1) {
                char character = (char) charValue;
                if (Character.toUpperCase(character) == vowel.charAt(0)) {
                    count++;
                    System.out.println(count);
                }
            }

            // Write the count to the output file
            writer.write(String.format("Number of %s: %d%n", vowel, count));

            System.out.println("Count for " + vowel + " successfully written to " + vowel + "_count.txt");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1); // Exit with an error code
        }
    }
}
