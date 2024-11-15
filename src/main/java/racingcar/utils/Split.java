package racingcar.utils;

import java.util.List;

public class Split {

    private static final String COMMA = ",";

    //쉼표기준 자르기
    public static List<String> commaSplit(String input) {
        input = input.replaceAll(" ", "");
        return List.of(input.split(COMMA));
    }
}
