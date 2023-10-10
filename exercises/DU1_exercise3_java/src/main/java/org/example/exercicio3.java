package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class exercicio3 {

    public static void main(String[] args) throws IOException {

        //parte 1
        ProcessBuilder pb1 = new ProcessBuilder();
        System.out.println(pb1.directory());

        //parte 2
        ProcessBuilder pb2 = new ProcessBuilder();
        pb2.command("cmd.exe", "/c", "dir");

        pb2.directory(new File("c:/"));
        pb2.inheritIO();
        pb2.start();

        //parte 3
        ProcessBuilder pb3 = new ProcessBuilder(args);
        pb3.command("cmd.exe", "/c", "dir");
        Scanner sc = new Scanner(System.in);
        System.out.println("Path?");
        String ruta=sc.nextLine();
        pb3.directory(new File(ruta));
        pb3.inheritIO();
        
        System.out.println("hola");
        

        try {
            Process p = pb3.start();
            int codRet = p.waitFor();
            System.out.println("The execution of " + args
                    + " returns " + codRet
                    + " " + (codRet == 0 ? "(OK)" : "(ERROR)")
            );
        } catch (IOException e) {
            System.err.println("Error during the execution of the process");
            System.err.println("Detailed information");
            System.err.println("---------------------");
            e.printStackTrace();
            System.err.println("---------------------");
            System.exit(2);
        } catch (InterruptedException e) {
            System.err.println("Interrupted process");
            System.exit(3);
        }
    }
}
