package org.example;

public class Person implements Runnable{
    private String name;
    private boolean isTeacher;
    private Greeting greeting;


    public Person(String name, Greeting greeting, boolean isTeacher) {
        this.name = name;
        this.isTeacher = isTeacher;
        this.greeting = greeting;
    }

    @Override
    public void run() {
        System.out.println(this.name + " has arrived");
        if(this.isTeacher){
            greeting.teacherGreeting(this.name);
        }else{
            greeting.studentGreeting(this.name);
        }
    }
}
