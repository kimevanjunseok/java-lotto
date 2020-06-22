package lotto.controller;

import lotto.domain.Count;
import lotto.domain.Money;
import lotto.view.InputView;

public class Controller {

    private static Controller controller = new Controller();

    private Controller() {
    }

    public static Controller getInstance() {
        return controller;
    }

    public void execute() {
        Money money = Money.from(InputView.inputMoney());
        Count count = Count.from(InputView.inputCount());
    }
}
