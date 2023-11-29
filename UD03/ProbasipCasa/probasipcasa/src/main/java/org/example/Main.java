package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

//        try {
//
//            //Obtenr etodas las interfaces de red
//
//            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
//
//            while (interfaces.hasMoreElements()) {
//                NetworkInterface iface = interfaces.nextElement();
//                System.out.println("Interfaz: " + iface.getName());
//
//                //Obtener las direcciones IP de la interfaz actual
//
//                Enumeration<InetAddress> addresses = iface.getInetAddresses();
//
//                while (addresses.hasMoreElements()){
//
//                    InetAddress addr = addresses.nextElement();
//                    System.out.println("Direccion IP: " + addr);
//
//
//                }
//                System.out.println();
//            }
//
//        }catch (SocketException e){
//            System.err.println("Error: " + e.getMessage());
//        }


        try {
            // Ejecutar el comando arp en la línea de comandos
            Process process = Runtime.getRuntime().exec("arp -a");

            // Leer la salida del comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Filtrar las líneas que contienen direcciones IP
                if (line.contains("Internet Address")) {
                    String[] parts = line.split("\\s+");
                    String ipAddress = parts[1];
                    System.out.println("Dirección IP: " + ipAddress);
                }
            }

            // Cerrar el lector
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}