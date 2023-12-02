import java.io.*;
import java.net.*;

public class ClienteComunicacao {

    private String hostname;
    private int port;

    public ClienteComunicacao(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String enviarRequisicao(String mensagem) {
        try (Socket socket = new Socket(hostname, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(mensagem); // Envia a mensagem para o servidor
            return in.readLine(); // Lê a resposta do servidor

        } catch (IOException e) {
            e.printStackTrace();
            return "Erro: " + e.getMessage();
        }
    }
}
