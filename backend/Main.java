import java.net.*;
import java.util.Scanner;

class Main {
    public static int PORT = 4446;
    public static String ADDRESS = "230.0.0.0";
    public static int BUFFER_LENGTH = 256;
    
    public static void main(String[] args) {
        
        // Listen for connections
        new Thread() {
            public void run() {
                try {
                    MulticastSocket recSocket = new MulticastSocket(PORT);
                    InetAddress group = InetAddress.getByName(ADDRESS);
                    recSocket.joinGroup(group);
                    
                    byte[] buffer = new byte[BUFFER_LENGTH];
                    while (true) {
                        DatagramPacket recPacket = new DatagramPacket(buffer, buffer.length);
                        recSocket.receive(recPacket);
                        
                        if (!InetAddress.getLocalHost().equals(recPacket.getAddress())) {
                            String rec = new String(recPacket.getData(), 0, recPacket.getLength());
                            System.out.println(rec);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        
        // Send messages
        try {
            MulticastSocket sendSocket = new MulticastSocket(PORT);
            InetAddress group = InetAddress.getByName(ADDRESS);
            sendSocket.joinGroup(group);
            
            Scanner in = new Scanner(System.in);
            
            while (true) {
                String msg = in.nextLine();
                
                if (msg == "q") {
                    break;
                }
                
                byte[] msgBytes = msg.getBytes();
                
                DatagramPacket sendPacket = new DatagramPacket(msgBytes, msgBytes.length, group, PORT);
                sendSocket.send(sendPacket);
            }
            sendSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}