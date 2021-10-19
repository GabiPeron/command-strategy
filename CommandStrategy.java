public class CommandStrategy {
    BuscaThread busca;

    public CommandStrategy() {
        this.busca = new BuscaThread();
    }

    public Command validate(String[] args) throws Exception {
        switch (args[0]) {
            case "new":
                return new NewCommand(args[1]);
            case "sleep":
                Thread tsleep = this.busca.getThreadByName(args[1]);
                int tratado = Integer.parseInt(args[2]);

                return new SleepCommand(tratado, tsleep);
            case "wait":
                Thread twait = this.busca.getThreadByName(args[1]);

                return new WaitCommand(twait);
            case "notify":
                Thread tnotify = this.busca.getThreadByName(args[1]);

                return new NotifyCommand(tnotify);
            default:
                throw new Exception("Comando inválido");
        }
    }
}
