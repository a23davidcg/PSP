package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Create a program to show the execution enviroment of a process with process builder method Map<String, String> enviroment in the comand line
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "set");
            Map<String, String> env = pb.environment();
            env.put("VAR1", "myValue");
            env.remove("OTHERVAR");
            env.put("VAR2", env.get("VAR1") + "suffix");
            pb.directory(new File("C:\\Users\\Usuario\\Desktop\\DAM\\2DAM\\Acceso a datos\\Tema 1\\Ejercicios\\Ejercicio 1"));
            Process p = pb.start();
            assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
            assert pb.redirectOutput().file() == new File("D:\\DAM 2\\PSP\\PSP\\UD1\\Ejercicio_4\\Ejercicio_4");
            assert p.getInputStream().read() == -1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}