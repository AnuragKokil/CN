import java.net.*;
import java.io.*;

public class Client {
    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 3333);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("exit")) {
            str2 = br.readLine();
            dout.writeUTF(str2);
            dout.flush();
            str = din.readUTF();
            System.out.println("SERVER : " + str);
        }
        dout.close();
        s.close();
    }
}
