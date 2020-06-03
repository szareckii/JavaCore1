package lesson6;

//import java.io.DataInputStream;
//import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8189);) {
           System.out.println("Сервер запущен, ожидаем подключения...");
            try (Socket socket = server.accept()) {
                System.out.println("Клиент подключился");
//                DataInputStream in = new DataInputStream(socket.getInputStream());
//                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Scanner in = new Scanner(socket.getInputStream());
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    String str = in.nextLine();

                    if (str.equals("/end")) {
                        System.out.println("Клиент отключился");
                        break;
                    }
                    System.out.println("Клиент: " + str);
                    out.println("echo: " + str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}