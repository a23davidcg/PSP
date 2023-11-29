package org.example;

public class Encrypt {

    public static String encryptMessage(String message) {

        StringBuilder encryptedMessage = new StringBuilder();

        //Part 1: Shift letters three positions to the right

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                int ascii = c;
                encryptedMessage.append(((char) ((ascii + 3))));
            } else {
                encryptedMessage.append(c);
            }
        }

        String reversedMessage = encryptedMessage.reverse().toString();
        int halfLen = reversedMessage.length() / 2;
        encryptedMessage = new StringBuilder(reversedMessage.substring(0, halfLen));
        for (int i = halfLen; i < reversedMessage.length(); i++) {
            encryptedMessage.append((char) (((reversedMessage.charAt(i) - 1) % 256)));
        }
        return encryptedMessage.toString();
    }

}
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class MessageEncryptor {
//
//    public static String encryptMessage(String message) {
//        StringBuilder encryptedMessage = new StringBuilder();
//
//        // Part 1: Shift letters three positions to the right
//        for (char c : message.toCharArray()) {
//            if (Character.isLetter(c)) {
//                char base = Character.isLowerCase(c) ? 'a' : 'A';
//                encryptedMessage.append((char) (((c - base + 3) % 26) + base));
//            } else {
//                encryptedMessage.append(c);
//            }
//        }
//
//        // Part 2: Reverse the message and shift characters from the half on one position to the left
//        String reversedMessage = encryptedMessage.reverse().toString();
//        int halfLen = reversedMessage.length() / 2;
//        encryptedMessage = new StringBuilder(reversedMessage.substring(0, halfLen));
//        for (int i = halfLen; i < reversedMessage.length(); i++) {
//            encryptedMessage.append((char) (((reversedMessage.charAt(i) - 1) % 256)));
//        }
//
//        return encryptedMessage.toString();
//    }
//
//    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.out.println("Usage: java MessageEncryptor <input_file>");
//            System.exit(1);
//        }
//
//        String inputFileName = args[0];
//
//        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                // Launch the encryption process for each line
//                String encryptedMessage = encryptMessage(line);
//                System.out.println("Original: " + line);
//                System.out.println("Encrypted: " + encryptedMessage);
//                System.out.println("============================");
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading the file: " + e.getMessage());
//            System.exit(1);
//        }
//    }
//}
