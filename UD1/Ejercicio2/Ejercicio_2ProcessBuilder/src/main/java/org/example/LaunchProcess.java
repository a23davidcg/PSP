package org.example;

import java.io.OutputStream;

public class LaunchProcess {
    //execute a process without errors where ping www.iessanclemente.net
    public static void main(String[] args) {
      //Test the class in the file LaunchProcess.java in Windows in the following situations:
        //
        //Execute a process without errors. Example: ping www.iessanclemente.net

        try {
            ProcessBuilder pb = new ProcessBuilder("ping", "www.iessanclemente.net");
            Process process = pb.start();
            try(OutputStream os = process.getOutputStream()){

            }

            process.waitFor();



        } catch (Exception e) {
            System.out.println("Error executing the process");
        }
    }
}
