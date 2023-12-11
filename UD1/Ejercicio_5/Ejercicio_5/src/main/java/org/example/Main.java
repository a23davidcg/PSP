package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //create a program to launch in the command line a tracert to iessanclemente.net
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "tracert", "iessanclemente.net");

            //redirect the process to a file outputTracer.txt using redirect output
            pb.redirectOutput(ProcessBuilder.Redirect.to(new File("outputTracer.txt")));
            System.out.println("Redirecting the output to outputTracer.txt");
            //wait 500 miliseconds after start the process and destroy the process after that time throwing an InterruptedException
            Process p = pb.start();
            Thread.sleep(500);
            p.destroy();
            //verify the content of outpuTracer.txt
            System.out.println("Verifying the content of outputTracer.txt");
            if (p.exitValue() == 0) {
                System.out.println("The process has finished correctly");
            } else {
                System.out.println("The process has finished with errors");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}