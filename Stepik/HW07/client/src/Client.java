import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Socket socket = new Socket("localhost", 5050);
        for (int i = 0; i < 10; i++){
            new Thread(new ClientThread()).start();
        }




    }
}
