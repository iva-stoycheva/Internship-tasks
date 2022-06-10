import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class SocketClient {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    public SocketClient(String address, int port) {
        try{
            socket = new Socket(address, port);
            System.out.println("Connected");

            input = new DataInputStream(System.in);
            output = new DataOutputStream(socket.getOutputStream());

            String line = "";
            line = input.readLine();
            byte[] content = line.getBytes(StandardCharsets.UTF_8);
            output.writeInt(content.length);
            output.write(content);

            input.close();
            output.close();
            socket.close();
        } catch (UnknownHostException u) {
            u.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void main (String[] args) {
        SocketClient client = new SocketClient("127.0.0.1", 3307);
    }
}
