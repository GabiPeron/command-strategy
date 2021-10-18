public class CommandStrategy {
    public Command validate(String[] args) throws Exception {
        switch (args[0]) {
            case "new":
                return new NewCommand(args[1]);
            case "sleep":
                Thread tsleep = this.getThreadByName(args[1]);
                int tratado = Integer.parseInt(args[2]);

                return new SleepCommand(tratado, tsleep);
            case "wait":
                Thread twait = this.getThreadByName(args[1]);

                return new WaitCommand(twait);
            case "notify":
                Thread tnotify = this.getThreadByName(args[1]);

                return new NotifyCommand(tnotify);
            default:
                throw new Exception("Comando inválido");
        }
    }

    public Thread getThreadByName(String threadName) {
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.getName().equals(threadName)) return t;
        }
        return null;
    }
}
