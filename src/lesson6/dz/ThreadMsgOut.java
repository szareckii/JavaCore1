package lesson6.dz;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ThreadMsgOut implements Runnable {

    DataOutputStream out;

    public ThreadMsgOut( DataOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {

        while (true) {
            Scanner scan = new Scanner(System.in);
            String strOut = null;

            if (scan.hasNextLine()) {
                strOut = scan.nextLine();
            }

            try {
                assert strOut != null;
                out.writeUTF(strOut);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (strOut.equals("/end")) {
                System.out.println("Произошло отключение");
                break;
            }
        }
    }
}
