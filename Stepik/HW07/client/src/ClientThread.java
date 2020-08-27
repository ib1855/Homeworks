import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Random;

public class ClientThread implements Runnable {
    private Socket clientSocket;

    //    Random random = new Random(50);
//    private int counter = 0;
//    private Date startDate = new Date();
//    private Date endDate;
//    public ClientThread(Socket clientSocket){
//        this.clientSocket = clientSocket;
//    }
    @Override
    public void run() {
        try {
            clientSocket = new Socket("localhost", 5050);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            for (int i = 0; i < 1000; i++) {
                if (clientSocket.getInputStream().available() > 0) {
                    System.out.println(bufferedReader.readLine());
                }

                bufferedWriter.write(i + "\n");
                bufferedWriter.flush();
                Thread.sleep(1);

                if (clientSocket.getInputStream().available() > 0) {
                    System.out.println(bufferedReader.readLine());
                }
            }

            bufferedWriter.write("Bye" + "\n");
            bufferedWriter.flush();
            Thread.currentThread().join();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
