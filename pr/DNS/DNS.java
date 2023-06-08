import java.net.*;
import java.util.*;

public class DNS {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try {

            Boolean op = true;

            while (op) {
                System.out.println("1) URL to IP");
                System.out.println("2) IP to URL");
                System.out.println("3) Exit");
                System.out.print("Enter Your Choice : ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter URL : ");
                        String url = sc.next();
                        InetAddress addr = InetAddress.getByName(url);
                        String ip = addr.getHostAddress();
                        System.out.println("IP : " + ip);
                        break;

                    case 2:
                        System.out.print("Enter IP : ");
                        String ip1 = sc.next();
                        InetAddress addr1 = InetAddress.getByName(ip1);
                        String url1 = addr1.getHostName();

                        System.out.println("URl : " + url1);
                        break;

                    case 3:
                        System.out.println("Exited.");
                        op = false;
                        break;

                    default:
                        System.out.println("Invalid Input!");
                }
            }

        } catch (UnknownHostException e) {
            System.out.println("DNS Lookup Failed : " + e.getMessage());
        }

    }

}
