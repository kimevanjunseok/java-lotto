package lotto.view;

import lotto.domain.Count;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class OutputView {

    public static void printLottoTickets(Count manual, Count auto, LottoTickets lottoTickets) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manual.getCount(), auto.getCount());
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            printLottoTicket(lottoTicket);

        }
    }

    private static void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.toString());
    }
}
