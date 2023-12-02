import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Servidor {
    private static final int PORTA = 12345;

    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        try (ServerSocket serverSocket = new ServerSocket(PORTA)) {
            System.out.println("Servidor iniciado na porta " + PORTA);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                pool.execute(new ClientHandler(clientSocket));
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                 ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

                // Implemente a lógica de CRUD aqui, processando as solicitações dos clientes

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
