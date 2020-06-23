package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {

    private static Controller controller = new Controller();

    private Controller() {}

    public static Controller getInstance() {
        return controller;
    }

    public void execute() {
        Money money = Money.from(InputView.inputMoney());
        Count manual = Count.from(InputView.inputManualCount());
        Count auto = Count.from(manual.calculateAutoCount(money));

        LottoTickets lottoTickets = createLottoTickets(manual, auto);
        OutputView.printLottoTickets(manual, auto, lottoTickets);

        WinningLotto winningLotto = createWinningLotto();

    }

    private LottoTickets createLottoTickets(Count manual, Count auto) {
        List<LottoTicket> manualLottoTickets = createManualTickets(manual);
        List<LottoTicket> autoLottoTickets = createAutoTickets(auto);
        return LottoTickets.of(manualLottoTickets, autoLottoTickets);
    }

    private List<LottoTicket> createManualTickets(Count manual) {
        List<String> manualTickets = InputView.inputManualLotto(manual);
        LottoTicketFactory manualFactory = ManualLottoTicketFactory.from(manualTickets);
        return manualFactory.create();
    }

    private List<LottoTicket> createAutoTickets(Count auto) {
        LottoTicketFactory autoFactory = AutoLottoTicketFactory.from(auto);
        return autoFactory.create();
    }

    private WinningLotto createWinningLotto() {
        String winningNumbers = InputView.inputWinningNumber();
        int bonusBall = InputView.inputBonusBall();
        return WinningLotto.from(winningNumbers, bonusBall);
    }
}
