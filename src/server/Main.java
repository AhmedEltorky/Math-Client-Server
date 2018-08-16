package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ahmed El-Torky
 */
public class Main {

    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(1991);
            System.out.println("Math Server.......");
            System.out.println("waiting.......");
            while (true) {
                Socket s1 = ss.accept();
                MathServer mathServer = new MathServer();
                mathServer.setMathService(new MathServiceImplementation());
                mathServer.setSocket(s1);
                mathServer.execute();
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
