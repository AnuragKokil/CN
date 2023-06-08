import java.net.*;
import java.io.*;

public class Reciever {

    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 3000);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = din.read();

        System.out.println("LENGTH : " + l);

        int arr[] = new int[l];

        int temp = 0;
        for (int i = 0; i < l; i++) {
            if (i < 4) {
                arr[i] = din.read();
                System.out.println("Recieved Frame : " + arr[i]);
            } else if (i == 4) {
                arr[i] = -1;
                temp = i;
                System.out.println((i + 1) + " Frame Not Recieved.");
            } else {
                arr[i] = -1;
                System.out.println((i + 1) + " Frame Discarded.");
            }
        }

        dout.write(temp);

        for (int i = temp; i < l; i++) {
            System.out.println("Retransmit Frame " + (i + 1));
            arr[i] = din.read();
            System.out.println("Recieved Frame : " + (i + 1));
        }

        dout.close();
        s.close();
    }

}
