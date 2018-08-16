package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Ahmed El-Torky
 */
public class MathClient {

    public static void main(String args[]) {
        try {
            Socket cs = new Socket("localhost", 1991);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(cs.getOutputStream()));
            System.out.println("please enter your input");
            System.out.println("ex: 50:*:6");
            String input = new Scanner(System.in).nextLine();
            writer.write(input);
            writer.newLine();
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            System.out.println(reader.readLine());

            writer.close();
            reader.close();

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
