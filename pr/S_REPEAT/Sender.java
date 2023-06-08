import java.net.*;
import java.io.*;

public class Sender {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int l = arr.length;

        System.out.println("LENGTH : " + l);

        dout.write(l);
        dout.flush();

        for (int i = 0; i < l; i++) {
            System.out.println("SENT : " + arr[i]);
            dout.write(arr[i]);
            dout.flush();
        }

        int n = din.read();

        dout.write(arr[n]);
        dout.flush();

        din.close();
        s.close();
        ss.close();
    }
}
