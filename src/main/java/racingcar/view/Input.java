package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.CustomErrorMessage;

public class Input {
    private static final String DELIMITER = ",";
    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> getCarName() {
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();
        List<String> carName = splitCarName(input);
        isValidCarName(carName);
        return carName;
    }

    public int getRound() {
        System.out.println(ROUND_MESSAGE);
        int input;
        try {
            input = Integer.parseInt(Console.readLine());
            isValidRound(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CustomErrorMessage.INVALID_ROUND_NUM);
        }
        return input;
    }

    private List<String> splitCarName(String carInput) {
        return Arrays.asList(carInput.split(DELIMITER));
    }

    // 자동차 이름의 유효성 검사 (각 이름이 5자 이하인지 확인)
    private void isValidCarName(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(CustomErrorMessage.INVALID_CAR_NAME);
            }
        }
    }

    private void isValidRound(int round) {
        if (round < 1) {
            throw new IllegalArgumentException(CustomErrorMessage.INVALID_ROUND);
        }
    }
}
