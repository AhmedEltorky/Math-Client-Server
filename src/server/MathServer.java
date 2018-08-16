package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Ahmed El-Torky
 */
public class MathServer {

    private MathServiceImplementation msi;
    private Socket socket;

    public MathServer() {
        this.socket = null;
        this.msi = null;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setMathService(MathServiceImplementation msi) {
        this.msi = msi;
    }

    public double parseExecution(String line) {
        String test[] = line.split(":");
        switch (test[1]) {
            case "+":
                return msi.add(Double.parseDouble(test[0]), Double.parseDouble(test[2]));
            case "-":
                return msi.sub(Double.parseDouble(test[0]), Double.parseDouble(test[2]));
            case "*":
                return msi.mult(Double.parseDouble(test[0]), Double.parseDouble(test[2]));
            case "/":
                return msi.divid(Double.parseDouble(test[0]), Double.parseDouble(test[2]));
            default:
                return -1;
        }
    }

    public void execute() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            double result = parseExecution(line);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("result = " + result);
            writer.newLine();
            writer.flush();
            writer.close();
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
