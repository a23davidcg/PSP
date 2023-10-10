package org.example;

import java.io.*;

public class PSCountVowel {

    public static void countVowel(String VW, File df, File dr) throws IOException {
        int counter = 0;
        String line;
        FileReader fr = new FileReader(df);
        BufferedReader br = new BufferedReader(fr);

        while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) { //Empezamos en el caracter cero de la linea y vamos caracter a caracter
                if (Character.toUpperCase(line.charAt(i)) == Character.toUpperCase(VW.charAt(0))) {
                    counter++;
                }

            }
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(dr));
        bw.write(String.valueOf(counter)); //Para que sobreescriba el contador
        bw.close();


    }

    public static void main(String[] args) throws IOException {
        System.out.println("hello");

        File dataFile = new File(args[0]);
        String vowel = args[1];

        File dataRes = new File(args[2]);
        countVowel(vowel, dataFile, dataRes );

    }
}