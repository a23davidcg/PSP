package org.example;

import javax.swing.*;

public class ConversorDeTemperatura {
    public static void main(String[] args) {


        String opcion = JOptionPane.showInputDialog("Seleccione la conversion que quiera realizar \n1. Celsious a fahrenheit. \n2 Farenheit a Celsious.");


        if (opcion.equals("1")) {
            double celsious = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la temperatura"));
            double farenheit = (celsious * 9 / 5) + 32;

            JOptionPane.showMessageDialog(null, "Temperatura en fahrenheit es: " + farenheit);

        } else if (opcion.equals("2")) {
            double farenheitIntroducidos = Double.parseDouble( JOptionPane.showInputDialog("ingrese la temperatura en fahrenheit"));
            double celsiousResultado = ((farenheitIntroducidos - 32)) * 5 / 9;

            JOptionPane.showMessageDialog(null, "La temperatura en celsious es: " + celsiousResultado);
        }else {
            JOptionPane.showMessageDialog(null, "A opcion que se seleccionou non e valida. ");
        }

    }
}
