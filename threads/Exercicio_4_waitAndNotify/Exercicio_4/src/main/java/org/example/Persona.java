package org.example;

import java.nio.Buffer;

public class Persona extends Thread {
    private boolean estudiante;

    private String name;

    public Persona(boolean estudiante, String name) {
        this.estudiante = estudiante;
        this.name = name;
    }

    public Persona() {
    }

    public void run() {


    }

}
