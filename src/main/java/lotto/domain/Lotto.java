package lotto.domain;

import static lotto.exception.LottoErrorMsg.DUPLICATED;
import static lotto.exception.LottoErrorMsg.OUT_OF_RANGE;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    private static final int MAX_LOTTE_NUM = 45;
    private static final int MIN_LOTTO_NUM = 1;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if(!isValidRange(numbers)){
            throw LottoException.triggeredBy(OUT_OF_RANGE);
        }
        if (isDuplicatedNum(numbers)){
            throw LottoException.triggeredBy(DUPLICATED);
        }

    }
    private boolean isDuplicatedNum(List<Integer> numbers){
        boolean[] isNumInNums = new boolean[MAX_LOTTE_NUM+1];
        Arrays.fill(isNumInNums,false);
        for (int num:numbers){
            if (isNumInNums[num]){
                return true;
            }
            isNumInNums[num] = true;
        }
        return false;
    }

    private boolean isValidRange(List<Integer> numbers){
        for (int num : numbers){
            if (num < MIN_LOTTO_NUM || num > MAX_LOTTE_NUM){
                return false;
            }
        }
        return true;
    }
}
