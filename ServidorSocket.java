import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
    public static void main(String[] args) throws IOException{
        ServerSocket servidor = null;
        CommandStrategy strat = new CommandStrategy();
        
        try {
            servidor = new ServerSocket(7000);

            while (true) {
                Socket conexao = servidor.accept();

                ThreadConexao tconn = new ThreadConexao(conexao, strat);

                tconn.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algo errado aconteceu");
        }
    }
}