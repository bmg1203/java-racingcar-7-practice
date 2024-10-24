package racingcar;

//- 사용자
//    - 게임에 참가할 자동차 결정하기
//    - 시도할 횟수 결정하기

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class User {

    final static private String USER_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final static private String USER_INPUT_GAME_REPEAT = "시도할 횟수는 몇 회인가요?";

    public static List<String> inputCarName() {
        System.out.println(USER_INPUT_CAR_NAME);

        String userCarNameInput = Console.readLine();

        // 분리된 문자열 (,) 앞 뒤 공백만 제거하는 정규표현식 사용
        List<String> carNamesList  = List.of(userCarNameInput.split("\\s*,\\s*"));
        return carNamesList;
    }

    public static int inputGameRepeat() {
        System.out.println(USER_INPUT_GAME_REPEAT);

        String userGameRepeatInput = Console.readLine();

        int gameRepeatInteger = Integer.parseInt(userGameRepeatInput);
        return gameRepeatInteger;
    }

}
