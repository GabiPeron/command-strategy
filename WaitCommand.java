public class WaitCommand implements Command {
    public Thread t;

    public WaitCommand(Thread t) {
        this.t = t;
    }

    @Override
    public synchronized void execute() throws InterruptedException  {
        synchronized(t) {
            t.wait();
        }
    }
}
