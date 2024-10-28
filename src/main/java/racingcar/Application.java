package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Car {
    private String name;
    private int now = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getNow() {
        return this.now;
    }

    public void move(int value) {
        if (value >= 4) {
            now++;
        }
    }

    public String printNow() {
        return name + " : " + "-".repeat(now);
    }
}

public class Application {
    private static List<Car> cars = new ArrayList<>();
    private static int count = 0;

    public static void checkNameDuplicate(List<String> names) {
        // 예외처리 : 자동차 이름이 같을 경우
        Set<String> uniqueNames = Set.copyOf(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복되지 않아야 합니다.");
        }
    }

    public static void checkNameLength(List<String> names) {
        // 예외처리 : 자동차 이름의 길이가 5글자를 초과하는 경우
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
    }

    public static void addCars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public static void playTurn() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
            System.out.println(car.printNow());
        }
        System.out.println();
    }

    public static void printWinner() {
        int maxNow = cars.stream().mapToInt(car -> car.getNow()).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getNow() == maxNow) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }

    public static void main(String[] args) {
        // 1. 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = List.of(Console.readLine().split(","));

        // 입력 예외 처리
        if(carNames.isEmpty() || carNames.stream().allMatch(String::isBlank)){
            throw new IllegalArgumentException("자동차 이름은 비워둘 수 없습니다.");
        }
        checkNameDuplicate(carNames);
        checkNameLength(carNames);

        // 2. 시도할 횟수 입력
        System.out.println("시도할 횟수는 몇 회인가요?");
        try{
            count = Integer.parseInt(Console.readLine());
            if(count<=0){
                throw new IllegalArgumentException("1이상의 숫자를 입력해야 합니다.");
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("횟수는 숫자로 입력해야 합니다.");
        }
        System.out.println("\n실행결과");

        // 3. 경주 시행
        addCars(carNames);
        while (count > 0) {
            playTurn();
            count--;
        }

        // 4. 우승자 출력
        printWinner();
    }
}
