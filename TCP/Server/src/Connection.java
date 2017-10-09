import java.io.*;
import java.net.Socket;

class Connection extends Thread

{
    InputStream in;
    DataOutputStream out;
    Socket clientSocket;

    public Connection(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = clientSocket.getInputStream();
            out = new DataOutputStream(clientSocket.getOutputStream());
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public void run() {
        FileWriter writer = new FileWriter();
        try { // an echo server
            int bufferLength = 16*1024;

            while(clientSocket.isConnected()) {
                byte[] buffer = new byte[bufferLength];
                int length = in.read(buffer);
                writer.write(buffer,length);
                System.out.println("Chunk received");
            }

            out.writeUTF("File OK");
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());

        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            try {
                clientSocket.close();
                writer.close();
            } catch (IOException e) {
                System.out.println("Close failed");
            }
        }
    }
}
