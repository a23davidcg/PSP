package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] vowels = {"A", "E", "I", "O", "U"};

        try {
            // Create processes for each vowel
            for (String vowel : vowels) {
                String classPAth = System.getProperty("java.class.path");
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPAth, "org.example.VowelCount", vowel);
                pb.inheritIO();
                Process process = pb.start();

                // Wait for the process to complete
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    System.out.println("Vowel count for " + vowel + " successfully written to " + vowel + "_count.txt");
                } else {
                    System.err.println("Error executing the vowel count command for " + vowel + ". Exit code: " + exitCode);
                }
            }

            System.out.println("All vowel count processes completed.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
