package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.global.error.validation.InputValidation;
import java.util.List;


public class RacingView {

    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표로 구분)";
    private static final String INPUT_NUMBER = "시도할 횟수는 몇 회인가요?";

    // 자동차 이름 입력 받기
    public String[] getCarNames() {
        System.out.println(INPUT_MESSAGE);
        String[] carName = Console.readLine().trim().split(",");
        String[] trimmedCarNames = validateCarNames(carName);  // 공백 제거 및 배열 반환
        validateCar(trimmedCarNames);  // 검증 수행
        return trimmedCarNames;
    }


    // 시도 횟수 입력 받기
    public int getRoundCount() {
        System.out.println(INPUT_NUMBER);
        int parseInt = Integer.parseInt(Console.readLine());
        InputValidation.checkParseInt(parseInt);
        return parseInt;
    }

    // 각 차수별로 자동차 상태 출력
    public static void printCarStates(List<Car> carStates) {
        for (Car car : carStates) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
    }

    // 최종 우승자 출력
    public static void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }


    // 자동차 이름에 공백 제거
    private String[] validateCarNames(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;

    }

    // 개별 자동차 이름에 대한 검증
    private void validateCar(String[] car) {
        InputValidation.checkOnce(car);
        for (String carName : car) {
            InputValidation.checkWhite(carName);
            InputValidation.checkDuplicate(carName);
            InputValidation.checkSpecialCharacters(carName);
            InputValidation.checkLength(carName);
        }
    }
}


