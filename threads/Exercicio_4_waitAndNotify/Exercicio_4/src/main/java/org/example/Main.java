package org.example;


/*
We want to create a multithreaded application.

In the application we want to consider two types of people: students and teachers. We will use a Person class for both students and teachers.

The task to be performed by both students and teachers is to greet each other.  To perform this task, both students and teachers will share an object of the Greeting class.

When a teacher arrives in a classroom he/she greets.

When a student arrives in a classroom, if the teacher has not arrived, waits for the teacher to arrive. In case the teacher has arrived before the student, the student should greet the teacher and apologise for the delay.

We want to perform a simulation with 20 students and one teacher.
 */


public class Main {

        public static final int NUM_STUDENTS=20;
        public static void main (String[] args){

            Greeting greeting = new Greeting();

            Thread[] student = new Thread[NUM_STUDENTS];

            for (int i=0; i<NUM_STUDENTS; i++){
                student[i]= new Thread(new Person("student"+i,  greeting, false));
            }

            Thread t1= new Thread(new Person("Noemi", greeting,true));
            t1.start();

            for (int i=0; i<NUM_STUDENTS; i++){
                student[i].start();
            }
        }

}