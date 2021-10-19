import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ThreadConexao extends Thread {
    Socket conn;
    CommandStrategy strategy;

    public ThreadConexao(Socket conn, CommandStrategy strategy) {
        this.conn = conn;
        this.strategy = strategy;
    }

    @Override
    public void run() {
        while (true) {
            BufferedReader entrada = null;
            String texto = "";
            Command comando = null;

            try {
                entrada = new BufferedReader(new InputStreamReader(this.conn.getInputStream()));
                texto = entrada.readLine();

                if (texto == null) {
                    break;
                }

                String[] separado = texto.split(" ");

                comando = this.strategy.validate(separado);

                comando.execute();

                System.out.println(comando);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
