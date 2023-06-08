import java.net.*;
import java.io.*;

public class Sender {
    
    public static void main(String args[])throws Exception{
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr[] = {1,2,3,4,5,6,7,8,9};

        dout.write(arr.length);

        System.out.println("LENGTH : "+arr.length);

        int temp = 0;

        for(int i=0; i<arr.length; i++){
            System.out.println("Sending Frame "+(i+1));
            dout.write(arr[i]);
            dout.flush();
        }

        temp = din.read();

        for(int i=temp; i<arr.length;i++){
            System.out.println("Retransmitting Frame "+(i+1));
            dout.write(arr[i]);
        }





        din.close();
        s.close();
        ss.close();
    }


    
    
    
}
