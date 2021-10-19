public class SleepCommand implements Command {
    public Thread t;
    public int tempo;

    public SleepCommand(int tempo, Thread t) {
        this.tempo = tempo;
        this.t = t;
    }

    @Override
    public synchronized void execute() throws InterruptedException {
        t.sleep(tempo);
    }
}
