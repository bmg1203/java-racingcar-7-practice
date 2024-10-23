package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RacingCar {

    public void run() {
        String[] carNames = inputCarName();
        int numberOfAttempts = inputNumberOfAttempts();

        Map<String, Integer> cars = createCar(carNames);

        for (int i = 0; i < numberOfAttempts; i++) {
            playRound(cars);
            showRaceProgress(cars);
        }

        List<String> winners = findWinner(cars);
    }

    public Map<String, Integer> createCar(String[] carNames) {
        Map<String, Integer> cars = new HashMap<>();
        for (String name : carNames) {
            cars.put(name, 0);
        }
        return cars;
    }

    public List<String> findWinner(Map<String, Integer> cars) {
        List<Entry<String, Integer>> carList = new ArrayList<>(cars.entrySet());
        carList.sort(((o1, o2) -> cars.get(o2.getKey()) - cars.get(o1.getKey())));

        List<String> winners = new ArrayList<>();
        Integer maxValue = carList.getFirst().getValue();

        for (Entry<String, Integer> car : carList) {
            if (car.getValue() != maxValue) {
                break;
            }
            winners.add(car.getKey());
        }
        return winners;
    }

    private String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameInput = Console.readLine();
        return nameInput.split(",");
    }

    private int inputNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    private boolean canMove() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number >= 4;
    }

    private void playRound(Map<String, Integer> cars) {
        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            if (canMove()) {
                cars.put(car.getKey(), car.getValue() + 1);
            }
        }
    }

    private void showRaceProgress(Map<String, Integer> cars) {
        System.out.println();
        System.out.println("실행 결과");
        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            System.out.print(car.getKey() + " : ");
            for (int j = 0; j < car.getValue(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
