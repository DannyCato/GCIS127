package unit12.activities;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class NetworkTime {
    public static void main(String[] args) throws IOException {
        Socket time = new Socket("time.nist.gov",13);
        Scanner sc = new Scanner(time.getInputStream());

        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }

        time.close();
    }
    
}
