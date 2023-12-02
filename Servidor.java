import java.io.*;
import java.net.*;
import java.util.concurrent.*;

// ... [importações anteriores]

public class Servidor {
    // ... [código anterior]

    private static class ClientHandler implements Runnable {
        // ... [código anterior]

        public void run() {
            try (ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                 ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

                Object objetoRecebido = in.readObject();

                if (objetoRecebido instanceof Entidade) {
                    Entidade entidadeRecebida = (Entidade) objetoRecebido;
                    // Aqui você pode adicionar a lógica para processar a entidade
                    System.out.println("Entidade recebida: " + entidadeRecebida);

                    // Enviar uma resposta de volta ao cliente
                    out.writeObject("Entidade recebida com sucesso!");
                }

            } catch (IOException | ClassNotFoundException e) {
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


public class Servidor {
    private static final int PORTA = 12345; // Porta na qual o servidor escuta
    private static ExecutorService pool = Executors.newFixedThreadPool(10); // Pool de threads

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORTA);
        System.out.println("Servidor iniciado na porta " + PORTA);

        try {
            while (true) {
                Socket clientSocket = serverSocket.accept(); // Aceita conexão do cliente
                System.out.println("Conexão aceita de " + clientSocket);
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                pool.execute(clientHandler); // Executa a thread do cliente
            }
        } finally {
            serverSocket.close();
        }
    }

    // Classe interna para lidar com cada cliente em uma thread separada
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try (ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                 ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

                // Aqui você pode processar as mensagens recebidas do cliente
                // Por exemplo, ler objetos, processar solicitações CRUD, etc.

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
