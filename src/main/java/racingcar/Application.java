package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = getInputCarNames();
        int moveCount = getInputMoveCount();
        printMoveResult(moveCount, cars);
        String winner = findWinner(cars);
        System.out.println("최종 우승자 : " + winner);

    }

    private static List<Car> getInputCarNames() {
        System.out.println("자동차의 이름을 쉼표(,)로 구분해 입력해주세요 (5자 이하)");
        String[] carNames = (Console.readLine()).split(",");

        int countCars = carNames.length;

        List<Car> cars = new ArrayList<>();
        HashSet<String> carNamesSet = new HashSet<>();

        for (int i = 0; i < countCars; i++) {
            String trimName = carNames[i].trim();

            if (!carNamesSet.add(trimName)) {
                throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다: " + trimName);

            }

            if (trimName.length() > 5) {
                throw new IllegalArgumentException("5자 이하여야 합니다: " + trimName);
            }

            cars.add(new Car(trimName));
        }
        return cars;
    }


    private static int getInputMoveCount() {
        System.out.println("이동횟수를 정수로 입력해주세요");
        int moveCount;

        try {
            moveCount = Integer.parseInt(Console.readLine());

            if (moveCount < 0) {
                throw new IllegalArgumentException("0이상의 값을 입력해주세요");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수값을 입력해주세요");

        }
        return moveCount;
    }


    private static void printMoveResult(int moveCount, List<Car> cars) {
        System.out.println("실행 결과");

        for (int i = 0; i < moveCount; i++) {
            System.out.println((i + 1) + "회차 결과");

            for (int c = 0; c < cars.size(); c++) {
                cars.get(c).move(pickNumberInRange(0, 9));
                System.out.println(cars.get(c).getPosition());
            }
            System.out.println();
        }
    }


    private static String findWinner(List<Car> cars) {
        String winner = "";
        int maxPosition = 0;

        for (int i = 0; i < cars.size(); i++) {

            if (cars.get(i).getPosition().length() > maxPosition) {
                maxPosition = cars.get(i).getPosition().length();
                winner = cars.get(i).getName();

            } else if (cars.get(i).getPosition().length() == maxPosition) {
                winner += ", " + cars.get(i).getName();

            }
        }
        return winner;
    }
    public static List<Car> testGetInputCarNames() {
        return getInputCarNames();
    }


}

