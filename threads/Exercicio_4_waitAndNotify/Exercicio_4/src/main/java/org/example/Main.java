package org.example;

public class Main {
    public static void main(String[] args) {

        GreetingSaudo greeting = new GreetingSaudo();
        Persona persona = new Persona();



        //Thread para profesor
        Thread teacher = new Thread(persona);
        teacher.setName("Teacher");
        teacher.start();

        //Creamos a todos os alumnos


        for (int i = 0; i <20; i++){
            Thread alumnos = new Thread(persona);
            alumnos.setName("Alumnos" + i);
            alumnos.start();

           // System.out.println("Os alumnos son " + alumnos.getName());

        }

    }
}