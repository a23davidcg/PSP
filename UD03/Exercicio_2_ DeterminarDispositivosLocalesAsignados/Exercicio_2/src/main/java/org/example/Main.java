package org.example;//package org.example;
//
//import java.net.NetworkInterface;
//import java.util.Enumeration;
//
//public class Main {
//    public static void main(String[] args) {
//
//        try {
//            Enumeration<NetworkInterface> in =  NetworkInterface.getNetworkInterfaces();
//
//
//        }
//
//
//    }
//}

//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//
//
//
//    public static void main(String[] args) {
//
//        List<String> reachableAddresses = getLocalReachableAddresses();
//
//        if (!reachableAddresses.isEmpty()) {
//            System.out.println("Reachable ips:");
//            for (String address : reachableAddresses) {
//                System.out.println(address);
//            }
//        } else {
//            System.out.println("No reachable IP addresses found on the local network.");
//        }
//    }
//
//    public static List<String> getLocalReachableAddresses() {
//        List<String> reachableAddresses = new ArrayList<>();
//
//        try {
//            // Get all available network interfaces
//            InetAddress[] allAddresses = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
//
//
//            // Check if each address is reachable
//            for (InetAddress address : allAddresses) {
//                if (address.isReachable(1000)) {
//                    reachableAddresses.add(address.getHostAddress());
//
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return reachableAddresses;
//    }
//}

//import java.net.InetAddress;
//import java.net.NetworkInterface;
//import java.net.SocketException;
//import java.util.Enumeration;
//
//public class Main {
//
//    public static void main(String[] args) {
//        try {
//            System.out.println("Local IP Addresses:");
//            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
//
//            while (networkInterfaces.hasMoreElements()) {
//                NetworkInterface networkInterface = networkInterfaces.nextElement();
//
//                // Check if the interface is up and not a loopback interface
//                if (networkInterface.isUp() && !networkInterface.isLoopback()) {
//                    Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
//
//                    while (addresses.hasMoreElements()) {
//                        InetAddress address = addresses.nextElement();
//                        System.out.println("- " + address.getHostAddress() + " is reachable: " + isReachable(address));
//                    }
//                }
//            }
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
////    }
//
//    private static boolean isReachable(InetAddress address) {
//        try {
//            // Try to reach the address with a timeout of 1000 milliseconds (1 second)
//            return address.isReachable(1000);
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}

//import java.net.InetAddress;
//import java.net.NetworkInterface;
//import java.net.SocketException;
//import java.net.UnknownHostException;
//import java.util.Enumeration;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        try {
//            System.out.println("Local IP Addresses:");
//
//            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
//
//            while (networkInterfaces.hasMoreElements()) {
//                NetworkInterface networkInterface = networkInterfaces.nextElement();
//
//                // Filtrar interfaces de red activas y no de loopback
//                if (networkInterface.isUp() && !networkInterface.isLoopback()) {
//                    Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
//
//                    while (addresses.hasMoreElements()) {
//                        InetAddress address = addresses.nextElement();
//                        System.out.println("- " + address.getHostAddress());
//                    }
//                }
//            }
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        String subnet = "10.21.0"; // Ingresa la parte común de la dirección IP de tu LAN
        int timeout = 1000; // Tiempo de espera en milisegundos

        System.out.println("Escaneando IPs en la LAN...");

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 1; i <= 255; i++) {
            String host = subnet + "." + i;

            executorService.execute(() -> {
                try {
                    if (InetAddress.getByName(host).isReachable(timeout)) {
                        System.out.println(host + " está conectado");
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    // Ignora las excepciones de tiempo de espera o host no alcanzable
                }
            });
        }

        executorService.shutdown();
    }
}

