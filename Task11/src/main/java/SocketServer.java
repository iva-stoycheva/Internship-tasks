import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketServer {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    public SocketServer(int port) throws IOException {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client");

            socket = server.accept();
            System.out.println("Client accepted");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            try {
                int length = in.readInt();
                byte[] content = new byte[length];
                in.read(content, 0, length);
                String received = new String(content, StandardCharsets.UTF_8);
                Expression expression = new ExpressionBuilder(received).build();
                System.out.println((received + " = " + expression.evaluate()));
            } catch (Exception e){
                e.printStackTrace();
            }

            socket.close();
            in.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{
        SocketServer socketServer = new SocketServer(3307);
    }
}
