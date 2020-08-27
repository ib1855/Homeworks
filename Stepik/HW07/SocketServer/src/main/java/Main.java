import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5050);
        Socket socket;
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        System.out.println("Server started");
        while (true){
            socket = serverSocket.accept();
            executorService.submit(new Runner(socket));
            socket = null;
        }

    }
}
