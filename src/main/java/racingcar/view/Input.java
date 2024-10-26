package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public List<String> getCarNames() {
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");

        Arrays.stream(carNames).forEach(carName -> {
            if (carName.equals("null") || carName == null) {
                throw new IllegalArgumentException("자동차 이름에 null이 포함되어 있습니다.");
            }
        });

        return Arrays.stream(carNames)
            .map(String::trim)
            .collect(Collectors.toList());
    }

    public int getTryNum() {
        int tryNum = Integer.parseInt(Console.readLine());
        return tryNum;
    }

}
