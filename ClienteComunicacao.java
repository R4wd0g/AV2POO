import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

// ... [importações anteriores]

public class ClienteComunicacao {
    // ... [código anterior]

    public static void main(String[] args) {
        // ... [código anterior para estabelecer conexão]

        try {
            Entidade novaEntidade = new Entidade("Teste", "Descrição da Entidade");
            out.writeObject(novaEntidade);

            Object resposta = in.readObject();
            System.out.println("Resposta do servidor: " + resposta);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class ClienteComunicacao {
    private static final String HOST = "localhost"; // Endereço do servidor
    private static final int PORTA = 12345; // Porta para conectar ao servidor

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORTA);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            // Exemplo de envio de uma mensagem para o servidor
            out.writeObject("Olá, servidor!");

            // Exemplo de recebimento de uma resposta do servidor
            Object resposta = in.readObject();
            System.out.println("Resposta do servidor: " + resposta);

        } catch (UnknownHostException e) {
            System.err.println("Host desconhecido: " + HOST);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Não foi possível estabelecer conexão com " + HOST + " na porta " + PORTA);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Problema com a classe do objeto recebido");
            e.printStackTrace();
        }
    }
}
