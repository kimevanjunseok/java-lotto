package lotto.controller;

import lotto.domain.*;
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

        List<LottoTicket> lottoTickets = createLottoTickets(manualCount, autoCount);
    }

    private List<LottoTicket> createLottoTickets(Count manualCount, Count autoCount) {
        List<String> manualTickets = InputView.inputManualLotto(manualCount);
        LottoTicketFactory manualFactory = ManualLottoTicketFactory.from(manualTickets);
        LottoTicketFactory autoFactory = AutoLottoTicketFactory.from(autoCount);
        List<LottoTicket> manualLottoTickets = manualFactory.create();
        List<LottoTicket> autoLottoTickets = autoFactory.create();
        return null;
    }
}
