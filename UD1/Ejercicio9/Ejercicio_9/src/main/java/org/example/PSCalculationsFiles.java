package org.example;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;


public class PSCalculationsFiles {
    public static void main(String[] args) throws IOException, InterruptedException, IOException {

        //Create a program to sum the numbers of a files
        String [] files = {"department101.txt", "department102.txt", "department103.txt", "department105.txt", "department106.txt", "department107.txt", "department108.txt"};

        for (String archivo : files){
            //read files
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String line;
                long cont = 0;
                BigDecimal total = new BigDecimal(0);
                while ((line = br.readLine()) != null) {
                    //System.out.println("cont:"+cont);
                    BigDecimal bd = new BigDecimal(line);
                    total = total.add(bd);
                    //System.out.println("total:"+total);
                    cont++;

                }
                System.out.println(total);
            }


        }
    }
}
