public class ThreadSocket implements Runnable {
    private String texto = "";
    private int ciclos = 0;
    private int prioridade = 5;
    private final Thread thread;

    public ThreadSocket(int ciclos, String texto, int prioridade) {
        this.thread = new Thread(this);
        this.texto = texto;
        this.ciclos = ciclos;
        this.prioridade = prioridade;
    }

    @Override
    public void run() {
        this.thread.setPriority(prioridade);

        for (int i = 0; i < this.ciclos; i++) {
            System.out.println(this.texto + "|" + (i + 1) + "|" + this.ciclos + "|");

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}
