/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        human Ivan = new human("Иван");
        cat Barsik = new cat("Барсик");
        Barsik.setCommand(command.giveFood, Ivan);
        while (true) {
            Barsik.setCommand(command.pat, Ivan); // пример,как запретить выполнение команды по таймеру
            if (Barsik.validStatus) {
                break;
            }
        }
        Barsik.setCommand(command.call, Ivan);
        Barsik.setCommand(command.command_voice, Ivan);

    }
}