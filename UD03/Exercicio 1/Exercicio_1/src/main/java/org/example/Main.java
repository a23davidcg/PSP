package org.example;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress in = InetAddress.getLocalHost(); //obtemos o nome do equipo
//
//        InetAddress[] ipadresses = InetAddress.getAllByName(in.getHostName());
//
//        for (int i = 0; i < ipadresses.length; i++) {
//            System.out.println(ipadresses[i]);
//        }
//
//
//        System.out.println("FORMA CON INNETADRESS:    ");
//
//        System.out.println("\n" +
//                "\n" +
//                "--------------------------------");

        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();

                System.out.println("Interface: " + networkInterface.getName());
                System.out.println("Nombre " + networkInterface.getDisplayName());

                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {

                    InetAddress address = inetAddresses.nextElement();
                    System.out.println(" ---- IP:     " + address.getHostAddress());
                }

                System.out.println("\n" + "\n");
                System.out.println("------------------------------");
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
