package racingcar;

import racingcar.io.ConsoleInputHandler;
import racingcar.io.ConsoleOutputHandler;
import racingcar.validator.CarNameListValidator;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CarRacingSimulation {
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();
    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
    private final int RANDOM_RANGE_MIN_NUMBER = 0;
    private final int RANDOM_RANGE_MAX_NUMBER = 9;
    private final int MOVE_FORWARD_MIN_NUMBER = 4; // 해당 숫자 이상일때 전진
    public void run() {
        consoleOutputHandler.racingCarNamingMessage(); // "자동차 이름 입력 안내" 메세지 출력
        String userInputCarNameString = consoleInputHandler.getUserInputCarNameString(); // 유저 입력 받기 (자동차 이름 문자열)
        List<String> carNameList = UserInputStringConverter.toList(userInputCarNameString); // 입력 문자열 자동치 이름 리스트로 변환
        CarNameListValidator.integratedValidation(carNameList); // 자동차 이름들 유효성 검사
        List<Car> carList = createCarList(carNameList); // 자동차 객체 리스트 생성
        consoleOutputHandler.attemptCountMessage(); // "시도 횟수 입력 안내" 메세지 출력
        int attemptCount = consoleInputHandler.getUserInputAttemptCount(); // 유저 입력 받기 (시도 횟수)
        racingStart(carList,attemptCount);

        //TODO 우승자(가장 많이 전진한 자동차) 찾아서 List<String> 으로 이름 받기
        List<String> winnerList = new ArrayList<>(Arrays.asList("John","Mike")); // winnerList 목업 데이터로 선언

        consoleOutputHandler.finalWinnerMessage(winnerList); // 최종 우승자 출력
    }

    private List<Car> createCarList(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNameList) {
            cars.add(new Car(carName)); // 자동차 객체 생성하여 리스트에 추가
        }
        return cars;
    }

    private void racingStart(List<Car> carList, int attemptCount) {
        for(int attempt = 0; attempt < attemptCount; attempt++){
            for(Car car : carList){
                car.moveForwardAttempt(RANDOM_RANGE_MIN_NUMBER,RANDOM_RANGE_MAX_NUMBER,MOVE_FORWARD_MIN_NUMBER);
                car.showDistance();
            }
            System.out.println();
        }
    }
}
