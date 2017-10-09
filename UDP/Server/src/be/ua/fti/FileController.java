package be.ua.fti;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileController {

    FileOutputStream stream;

    public FileController() {
        try {
           stream = new FileOutputStream("output.jpg");
        } catch (FileNotFoundException e) {
            System.out.println("Kan bestand niet schrijven.");
        }
    }

    public void write(byte[] data,int length) {
        try {
            stream.write(data,0,length);
        } catch (IOException e) {
            System.out.println("Fout bij het wegschrijven van de bytes");
        }
    }

    public void close() {
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
