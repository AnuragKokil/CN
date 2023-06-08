import java.net.*;
import java.io.*;

public class Reciever {
    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 3333);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        int l = din.read();

        System.out.println("LENGTH : " + l);

        int v[] = new int[9];

        for (int i = 0; i < l; i++) {
            v[i] = din.read();
        }

        v[5] = -1;

        for (int i = 0; i < l; i++) {
            System.out.println("RECIEVED : " + v[i]);
        }

        int n = 0;

        for (int i = 0; i < l; i++) {
            if (v[i] == -1) {
                n = i;
                System.out.println("RETRANSMIT PACKET : " + (i + 1));
                dout.write(n);
                dout.flush();
                break;
            }
        }

        v[n] = din.read();

        System.out.println("RECIEVED FRAME : " + v[n]);

        dout.close();
        s.close();
    }

}
