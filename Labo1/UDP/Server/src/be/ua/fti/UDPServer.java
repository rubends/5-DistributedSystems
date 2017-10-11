package be.ua.fti;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    private static int FILESIZE = 243413; // size of the expected file in bytes
    private static String OKMESSAGE = "File received OK";

    public static void main(String[] args) throws Exception {
        FileController file = new FileController();

        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[60 * 1024];

        int receivedSize = 0;
        InetAddress IPAddress = InetAddress.getLocalHost(); // initial value
        int port = 0;

        // Receive packets until size is reached
        while (receivedSize < FILESIZE) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            InetAddress IPAdress = receivePacket.getAddress();
            System.out.println("UDP packet ontvangen van: " + IPAdress.toString());

            file.write(receivePacket.getData(), receivePacket.getLength());

            IPAddress = receivePacket.getAddress();
            port = receivePacket.getPort();

            receivedSize += receivePacket.getLength();
        }

        DatagramPacket response = new DatagramPacket(OKMESSAGE.getBytes(), OKMESSAGE.getBytes().length, IPAddress, port);
        serverSocket.send(response);

        serverSocket.close();
        file.close();
    }
}
