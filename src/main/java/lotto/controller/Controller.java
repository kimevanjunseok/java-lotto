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

        LottoTickets lottoTickets = createLottoTickets(manualCount, autoCount);
    }

    private LottoTickets createLottoTickets(Count manualCount, Count autoCount) {
        List<LottoTicket> manualLottoTickets = createManualTickets(manualCount);
        List<LottoTicket> autoLottoTickets = createAutoTickets(autoCount);
        return LottoTickets.of(manualLottoTickets, autoLottoTickets);
    }

    private List<LottoTicket> createManualTickets(Count manualCount) {
        List<String> manualTickets = InputView.inputManualLotto(manualCount);
        LottoTicketFactory manualFactory = ManualLottoTicketFactory.from(manualTickets);
        return manualFactory.create();
    }

    private List<LottoTicket> createAutoTickets(Count autoCount) {
        LottoTicketFactory autoFactory = AutoLottoTicketFactory.from(autoCount);
        return autoFactory.create();
    }
}
