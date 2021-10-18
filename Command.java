public interface Command {
    abstract void execute() throws InterruptedException;
}
