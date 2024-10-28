package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<String> winners = new ArrayList<>();
    int maxTurn = 0;
    Validation validation = new Validation();

    public void runGame() {

        setGame();
        playGame();
        afterGame();
    }

    /// 레이싱게임 입력부분
    private void setGame() {

        String[] carNameArray = inputCarName(); // 자동차 이름 입력받아서 배열에 저장
        validation.validateCarName(carNameArray); // 자동차 입력부분 예외처리

        // 자동차 정보 저장
        for (String carName : carNameArray) {

            validation.checkDuplicateCar(cars, carName); // 자동차 이름 중복 예외처리
            cars.add(new Car(carName));
        }

        String maxTurnString = inputMaxTurn(); // 이동횟수 입력받아서 문자열에 저장
        validation.validateMaxTurn(maxTurnString); // 이동횟수 입력부분 예외처리
        maxTurn = Integer.parseInt(maxTurnString);

    }

    private void playGame() {

        System.out.println("실행결과");

        for (int i = 0; i < maxTurn; i++) {
            moveCar(); // 배열에 저장된 자동차 중 무작위 수가 4이상인 자동차를 움직임
            printGamePlay(); // 배열에 저장된 자동차의 이름과 이동거리 표시
        }
    }

    private void afterGame() {

        int winScore = getWinScore();
        selectWinner(winScore);
        printWinners();
    }


    /// 자동차 이름을 입력받아 문자열 배열을 리턴
    private String[] inputCarName() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNameString = Console.readLine(); // 사용자로부터 자동차 이름 입력받기
        carNameString = carNameString.trim();

        // 입력한 자동차 이름으로 생성한 배열 리턴
        return carNameString.split(",");
    }


    private String inputMaxTurn() {

        System.out.println("시도할 횟수는 몇 회인가요?");

        String maxTrunString = Console.readLine();
        maxTrunString = maxTrunString.trim();

        return maxTrunString;
    }


    /// 자동차 이동
    private void moveCar() {
        for (Car car : cars) {
            car.takeTurn();
        }
    }

    /// 자동차 이동거리 표시
    private void printGamePlay() {
        for (Car car : cars) {
            printMoveCar(car);
        }
        System.out.println();
    }

    /// 자동차 이름과 이동거리를 출력
    private void printMoveCar(Car car) {
        System.out.print(car.getCarName() + " : ");

        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    /// 우승점수 계산
    private int getWinScore() {
        int winScore = 0;

        for (Car car : cars) {
            if (winScore < car.getDistance()) {
                winScore = car.getDistance();
            }
        }

        return winScore;
    }

    ///점수가 가장 많은 자동차를 Winners 배열에 저장
    private void selectWinner(int winScore) {

        for (Car car : cars) {
            if (car.getDistance() == winScore) {
                winners.add(car.getCarName());
            }
        }
    }

    /// 우승자 목록 출력
    private void printWinners() {
        String result = String.join(",", winners);
        System.out.println("최종 우승자 : "+result);
    }
}
