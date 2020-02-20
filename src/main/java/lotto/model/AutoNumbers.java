package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AutoNumbers {
    private List<Integer> autoNumbers = new ArrayList<>();

    public AutoNumbers() {
        Collections.shuffle(LottoNumbers.getLottoNumbers());
        for (int i = 0; i <= 5; i++) {
            autoNumbers.add(LottoNumbers.getLottoNumbers().get(i));
        }
        autoNumbers.sort(Comparator.naturalOrder());
    }

    public AutoNumbers(List<Integer> input) {
        this.autoNumbers = input;
    }

    public List<Integer> getAutoNumbers() {
        return autoNumbers;
    }
}
