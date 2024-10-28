package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            List<Car> cars = inputName();
            System.out.println("시도할 횟수는 몇 회인가요?");
            int trial = Integer.parseInt(Console.readLine());
            if (trial <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }
            System.out.println("실행 결과");
            //게임 실행
            for (int i = 0; i < trial; i++) {
                playOneRound(cars);
                playResult(cars);
            }
            winner(cars);

    }

    //입력문 기능으로 빼기
    private static List<Car> inputName() {
        String[] carNames = Console.readLine().split(",");
        validateName(carNames);
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
    //검증문도 빼기
    private static void validateName(String[] carNames) {
        List<String> errors = new ArrayList<>();
        for (String name : carNames) {
            name = name.trim();
            if(name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다. ");
            }
            if (isNumeric(name)) {
                throw new IllegalArgumentException("자동차 이름은 숫자만 입력할 수 없습니다.");
            }

        }
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join("\n", errors));
        }
    }

    private static boolean isNumeric(String name) {
        return name.matches("\\d+");
    }

    //매판 결과값
    private static void playResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.exchangeDistance());
        }
        System.out.println();
    }

    //전진 멈추는 방법(4이상일때만)
    private static void playOneRound(List<Car> cars) {

        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.go();
            }
        }
    }

    //우승자를 뽑는 방식
    private static void winner(List<Car> cars) {
        int maxDistatnce = 0;
        for (Car car : cars) {
            if (car.getDistance() >= maxDistatnce) {
                maxDistatnce = car.getDistance();
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistatnce) {
                winners.add(car.getName());
            }
        }
        //우승자 출력
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
