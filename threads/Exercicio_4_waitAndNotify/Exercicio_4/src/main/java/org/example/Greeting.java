package org.example;

import java.awt.*;
import java.nio.Buffer;
import java.sql.SQLOutput;

public class Greeting {

private String greeting;
private boolean teacherArrived;

public Greeting(){

    teacherArrived= false;
}

public synchronized void teacherGreeting(String name){
    System.out.println("Hi"+ name + "nice to see you student");
    this.teacherArrived=true;
    this.notifyAll();
}

public synchronized  void studentGreeting(String name){
    try {
        if(!this.teacherArrived){
            this.wait();
            System.out.println("hi teacher"+ name + "nice to see you");
        }else{
            System.out.println("hi teacher"+ name + "sorry for the delay");
        }
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}


}
