package lotto.controller;

public class Controller {

    private static Controller controller = new Controller();

    private Controller() {
    }

    public static Controller getInstance() {
        return controller;
    }

    public void execute() {

    }
}
