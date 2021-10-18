public class NewCommand extends Thread implements Command  {
    public NewCommand(String nome) {
        setName(nome);
    }

    @Override
    public synchronized void execute() {
        System.out.println("Saindo meu patrão");
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
