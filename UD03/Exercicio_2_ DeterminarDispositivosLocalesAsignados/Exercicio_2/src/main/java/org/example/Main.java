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
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws UnknownHostException, SocketException {


        String subnet = "192.168.1"; // Ingresa la parte común de la dirección IP de tu LAN
        int timeout = 1000; // Tiempo de espera en milisegundos

        System.out.println("Escaneando IPs en la LAN...");

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 1; i <= 255; i++) {
            String host = subnet + "." + i;

            executorService.execute(() -> {
                try {
                    if (InetAddress.getByName(host).isReachable(timeout)) {
                        System.out.println(host + " está conectado");
                    }else {
                        System.out.println(host + " non esta conectado");
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


//import java.io.IOException;
//import java.net.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        final byte[] destIP;
//        final byte[] maskIP;
//        final byte[] ip= InetAddress.getLocalHost().getAddress();
//        System.out.println(InetAddress.getLocalHost().getHostAddress());
//        InetAddress localHost = Inet4Address.getLocalHost();
//        NetworkInterface ni=NetworkInterface.getByInetAddress(localHost);
//        short prefix=ni.getInterfaceAddresses().get(1).getNetworkPrefixLength();
//        System.out.println("IPv4 localhost prefix:"+prefix);
//        String IPstr = localHost.toString().substring(1);
//        System.out.println("Localhost IP:"+IPstr);
//        maskIP = getMask(prefix);
//        byte[] networkIP =getNetworkIP(maskIP, ip);
//        int last=(int)Math.pow(2,32-prefix)-1;
//        destIP=networkIP;
//        for (int j=1;j<last;j++){
//            destIP[3]++;
//            if (destIP[3]==0){
//                destIP[2]++;
//                if (destIP[2]==0){
//                    destIP[1]++;
//                    if (destIP[1]==0){
//                        destIP[0]++;
//                    }
//                }
//            }
//            InetAddress address = InetAddress.getByAddress(destIP);
//            String output = address.toString().substring(1);
//            if (address.isReachable(1000)) {
//                System.out.println(output + " is on the network");
//            }
//        }
//
//        System.out.println("Scan LAN IP program finished");
//    }
//
//    private static byte[] getNetworkIP(byte[] maskIP, byte[] ip) {
//        System.out.print("Network IP: ");
//        byte[] networkIP=new byte[4];
//        for (int i=0;i<4;i++){
//            networkIP[i]= (byte) (ip[i]& maskIP[i]);
//            System.out.print(networkIP[i]&0xFF);
//            if (i<3){
//                System.out.print(".");
//            }
//        }
//        System.out.println();
//        return networkIP;
//    }
//
//    private static byte[] getMask(short prefix) {
//        final byte[] maskIP;
//        System.out.print("Newtwork mask:");
//        final byte[] mask=new byte[4];
//        StringBuilder prefixStr=new StringBuilder();
//        int cont= prefix;
//        for (int i=0;i<32;i++){
//            if(cont>0){
//                prefixStr.append("1");
//            }else{
//                prefixStr.append("0");
//            }
//            cont--;
//        }
//        maskIP=new byte[4];
//        String[] maskIPstr = prefixStr.toString().split("(?<=\\G.{" + 8 + "})");
//        for (int k=0;k<maskIPstr.length;k++){
//            maskIP[k]=(byte)Integer.parseInt(maskIPstr[k],2);
//            System.out.print(maskIP[k]&0xFF);
//            if(k<maskIPstr.length-1){
//                System.out.print(".");
//            }
//        }
//        System.out.println();
//        return maskIP;
//    }
//}
