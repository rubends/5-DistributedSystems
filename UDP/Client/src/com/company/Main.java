package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws Exception {
        //D:\Ruben\Documents\EI\3-Distributed systems\Practica\Labo2-10\DistributedSystems-prac1\success.jpg
        int serverPort = 9876;
        InetAddress IPAddress = InetAddress.getLocalHost();
        byte[] receiveData = new byte[16 * 1024];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file: ");
        System.out.flush();
        String filename = scanner.nextLine();
        File file = new File(filename);

        DatagramSocket clientSocket = new DatagramSocket();
        InputStream f = new FileInputStream(file);
        byte[] bufferArray =  new byte[60 * 1024];
        int readAnsw = 2;
        while(readAnsw > -1){
            readAnsw = f.read(bufferArray);
            if(readAnsw > -1){
                DatagramPacket sendToServer = new DatagramPacket(bufferArray, readAnsw, IPAddress, serverPort);
                clientSocket.send(sendToServer);
            }
        }
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        System.out.println("FROM SERVER: " + new String(receivePacket.getData()));
        clientSocket.close();
    }
}
