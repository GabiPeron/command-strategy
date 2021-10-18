import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket {
    public static void main(String[] args) throws IOException{
        Scanner entrada = new Scanner(System.in);
        String texto = "";
        Socket cliente = null;
        PrintStream saida = null;

        try {
            cliente = new Socket("172.16.1.251", 7000);

            saida = new PrintStream(cliente.getOutputStream());

            do {
                texto = entrada.nextLine();

                saida.println(texto);
            } while (!"sair".equals(texto));
        } catch (Exception e) {
            System.out.println("Algo errado aconteceu");
        } finally {
            cliente.close();
        }
    }
}
