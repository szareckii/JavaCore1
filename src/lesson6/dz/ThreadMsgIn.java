package lesson6.dz;

import java.io.DataInputStream;
import java.io.IOException;

public class ThreadMsgIn implements Runnable {

    private final String type;
    DataInputStream in;

        public ThreadMsgIn( DataInputStream in, String type) {
            this.in = in;
            this.type = type;
        }

        @Override
        public void run() {

            while (true) {
                String strIn = null;

                try {
                    strIn = in.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                assert strIn != null;
                if (strIn.equals("/end")) {
                    System.out.println("Произошло отключение");
                    break;
                }

                System.out.println(type + strIn);
            }
        }
}
