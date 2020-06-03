package lesson6.dz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        DataInputStream in;
        DataOutputStream out;

        Socket socket = null;
        ServerSocket server;
                
        final int PORT = 8189;

        System.out.println("Чат с одним клиентом");

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен, ожидаем подключения...");

            try {
                socket = server.accept();

                System.out.println("Клиент подключился");

                System.out.println("Введите сообщение. Для отправки используйте Enter. Для выхода введите /end!");

                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                Thread myThreadyIn = new Thread(new ThreadMsgIn(in, "                   ")); //не решил как симпатичнее
//                Thread myThreadyIn = new Thread(new ThreadMsgIn(in, "Клиент: "));               // или так
                Thread myThreadyOut = new Thread(new ThreadMsgOut(out));

                myThreadyIn.start();
                myThreadyOut.start();

                try {
                    myThreadyOut.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            catch (IOException  e) {
                e.printStackTrace();
            }
            finally {
                try {
                    assert socket != null;
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}