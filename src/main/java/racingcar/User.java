package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class User {

    final static private String USER_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final static private String USER_INPUT_GAME_REPEAT = "시도할 횟수는 몇 회인가요?";
    final static private String USER_INPUT_GAME_REPEAT_ERROR_MESSAGE = "1 이상의 정수만 입력이 가능합니다";

    public static List<String> inputCarNames() {
        System.out.println(USER_INPUT_CAR_NAME);

        String userCarNamesInput = Console.readLine();

        // 분리된 문자열 (,) 앞 뒤 공백만 제거하는 정규표현식 사용
        List<String> carNamesList  = List.of(userCarNamesInput.split("\\s*,\\s*"));
        return carNamesList;
    }

    public static int inputGameRepeats() {
        System.out.println(USER_INPUT_GAME_REPEAT);

        String userGameRepeatInput = Console.readLine().strip();
        validateInputGameRepeats(userGameRepeatInput);
        int gameRepeatInteger = Integer.parseInt(userGameRepeatInput);
        return gameRepeatInteger;
    }

    private static void validateInputGameRepeats(String userGameRepeatInput) {
        if (userGameRepeatInput.isBlank()) throw new IllegalArgumentException(USER_INPUT_GAME_REPEAT_ERROR_MESSAGE);
        if (userGameRepeatInput.equals("0")) throw new IllegalArgumentException(USER_INPUT_GAME_REPEAT_ERROR_MESSAGE);
        for (int i = 0; i < userGameRepeatInput.length(); i ++) {
            if (!Character.isDigit(userGameRepeatInput.charAt(i))) throw new IllegalArgumentException(USER_INPUT_GAME_REPEAT_ERROR_MESSAGE);
        }

    }

}
