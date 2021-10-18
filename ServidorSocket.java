import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

                Thread t = new Thread() {
                    public void run() {
                        while (true) {
                            BufferedReader entrada = null;
                            String texto = "";
                            Command comando = null;

                            try {
                                entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
                                texto = entrada.readLine();
            
                                if (texto == null) {
                                    break;
                                }
            
                                String[] separado = texto.split(" ");
            
                                comando = strat.validate(separado);

                                comando.execute();

                                System.out.println(comando);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                };

                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algo errado aconteceu");
        }
    }
}