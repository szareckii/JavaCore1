package lesson6.dz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;


        final String IP_ADDRESS = "localhost";
        final int PORT = 8189;

        System.out.println("Чат с сервером.");
        System.out.println("Введите сообщение. Для отправки используйте Enter. Для выхода введите /end!");

        try {
            socket = new Socket(IP_ADDRESS, PORT);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread myThreadyIn = new Thread(new ThreadMsgIn(in, "                  "));     //не решил как симпатичнее
//            Thread myThreadyIn = new Thread(new ThreadMsgIn(in, "Сервер: "));                  //или так
            Thread myThreadyOut = new Thread(new ThreadMsgOut(out));

            myThreadyIn.start();
            myThreadyOut.start();

            try {
                myThreadyOut.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (
                IOException e) {
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
    }
}