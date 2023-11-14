package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
        String edad = JOptionPane.showInputDialog("Ingrese su edad");
        String correo = JOptionPane.showInputDialog("ingrese su correo");

        String mensaje = "Benvido" + nombre + "\n" +
                "tes " + edad + "anos \n" +"o teu mail e: " + correo;


        JOptionPane.showMessageDialog(null, mensaje);
    }
}