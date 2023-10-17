package org.example;

public class LaunchThreadChild {
    public static void main(String[] args) {

        //Creamos dous threads child diferentes

        ThreadChild th1 = new ThreadChild("Perico");
        ThreadChild th2 = new ThreadChild("Margaret");

        th1.start();
        th2.start();
        System.out.println("testing threads"); //


    }
}
