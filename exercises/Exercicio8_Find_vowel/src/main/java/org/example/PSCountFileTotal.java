package org.example;

import java.io.File;
import java.io.IOException;

public class PSCountFileTotal {
    public static void main(String[] args) throws IOException, InterruptedException {
        File FileOrigin = new File(args[0]);
        String[] vowels = {"A", "E", "I", "O", "U"};
        String[] outFile = new String[vowels.length];
        Process[] processes = new Process[vowels.length];


        for (int i = 0; i < vowels.length; i++) {
            String FilesErrors = "errorrs" + vowels[i]+ ".txt";
            ProcessBuilder pb = new ProcessBuilder();
            //Argumentos que se lle pasan a clase, para crear un archivo para cada vocal
            pb.command().add("java");
            pb.command().add("-cp");//indicamos en que clase está
            String classpath = System.getProperty("java.class.path");
            pb.command().add(classpath);
            pb.command().add(args[1]);//Porque se va a pasar por la linea de comandos los argumentos qie se le van a pasar
            pb.command().add(args[0]);
            pb.command().add(vowels[i]);
            //poñer os archivos de destino
            outFile[i] = vowels[i] + ".txt";
            pb.command().add(outFile[i]);
            pb.redirectError(new File(FilesErrors));//Para ter un ficheiro que nos garde os erros de cada nova vocal e poder correxir o run
            processes[i] = pb.start();


        }
        for (int j = 0; j < vowels.length; j++) {
            if (processes[j].isAlive()) {
                processes[j].waitFor();
            }
        }


    }
}
