package lotto.controller;

import lotto.domain.Count;
import lotto.domain.LottoTicketFactory;
import lotto.domain.ManualLottoTicketFactory;
import lotto.domain.Money;
import lotto.view.InputView;

import java.util.List;

public class Controller {

    private static Controller controller = new Controller();

    private Controller() {
    }

    public static Controller getInstance() {
        return controller;
    }

    public void execute() {
        Money money = Money.from(InputView.inputMoney());
        Count manualCount = Count.from(InputView.inputManualCount());
        Count autoCount = Count.from(manualCount.calculateAutoCount(money));

        List<String> manualTickets = InputView.inputManualLotto(manualCount);
        LottoTicketFactory manualFactory = ManualLottoTicketFactory.from(manualTickets);
        manualFactory.create();
    }
}
