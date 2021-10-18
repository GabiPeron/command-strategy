public class NotifyCommand implements Command {
    public Thread t;

    public NotifyCommand(Thread t) {
        this.t = t;
    }

    @Override
    public synchronized void execute() throws InterruptedException {
        System.out.println("Wii Wii Wii");

        synchronized(t) {
            t.notify();
        }
    }
}
