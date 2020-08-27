import java.io.*;
import java.net.Socket;

public class Runner implements Runnable {

    private Socket socket;
    public Runner(Socket socket){
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (!Thread.currentThread().isInterrupted()){

               // if (socket.getInputStream().available() > 0) {
                    String message = in.readLine();

                    if (message.equals("Bye")){
                      socket.close();
                        Thread.currentThread().interrupt();
                    }
                    else {
                        out.write(message + "\n");
                        out.flush();
                    }
               // }
                //Thread.sleep(1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
