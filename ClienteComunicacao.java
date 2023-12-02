import java.io.*;
import java.net.*;

public class ClienteComunicacao {
    private static final String ENDERECO_SERVIDOR = "localhost";
    private static final int PORTA_SERVIDOR = 12345;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(ENDERECO_SERVIDOR, PORTA_SERVIDOR);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            // Enviar solicitações e receber respostas do servidor

        }
    }
}
