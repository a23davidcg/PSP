package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Encriptado {


    public class Encryption {
        public static void main(String[] args) {
            // Read the file name from the command line argument
            String file_name = args[0];

            // Read the messages to encrypt from the file
            try (BufferedReader br = new BufferedReader(new FileReader(file_name))) {
                String line;
                while ((line = br.readLine())!= null) {
                    // Encrypt the message
                    String encrypted_message = encrypt(line);

                    // Print the encrypted message
                    System.out.println(encrypted_message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Define the function to shift the letters
        public static String shift_letters(String word) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isLetter(c)) {
                    if (Character.isUpperCase(c)) {
                        c = (char) ((c - 'A' + 3) % 26 + 'A');
                    } else {
                        c = (char) ((c - 'a' + 3) % 26 + 'a');
                    }
                }
                result.append(c);
            }
            return result.toString();
        }

        // Define the function to reverse the line
        public static String reverse_line(String line) {
            StringBuilder result = new StringBuilder();
            for (int i = line.length() - 1; i >= 0; i--) {
                result.append(line.charAt(i));
            }
            return result.toString();
        }

        // Define the function to move the characters
        public static String move_characters(String line) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (Character.isLetter(c)) {
                    if (Character.isUpperCase(c)) {
                        c = (char) ((c - 'A' - 1) % 26 + 'A');
                    } else {
                        c = (char) ((c - 'a' - 1) % 26 + 'a');
                    }
                }
                result.append(c);
            }
            return result.toString();
        }

        // Define the function to encrypt the message
        public static String encrypt(String message) {
            String shifted_message = shift_letters(message);
            String reversed_message = reverse_line(shifted_message);
            String moved_message = move_characters(reversed_message);
            return moved_message;
        }
    }

}
