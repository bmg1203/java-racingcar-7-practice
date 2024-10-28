package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String INPUT_NATE_DELIMITER = ",";

    public List<String> readCarNames() {
        System.out.println("자동차 이름을 입력하세요");
        String input = Console.readLine();
        String[] split = input.split(INPUT_NATE_DELIMITER);

        if (isDuplicated(split)) {
            throw new IllegalArgumentException("동명이인 입력");
        }

        return Arrays.stream(split)
                .map(String::trim)
                .toList();
    }

    private boolean isDuplicated(String[] split) {
        return Arrays.stream(split).distinct().count() != split.length;
    }

    public int readRound() {
        System.out.println("라운드 수를 입력하세요");
        return Integer.parseInt(Console.readLine());
    }
}
