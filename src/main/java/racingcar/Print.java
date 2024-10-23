package racingcar;

public class Print {

    static void nameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    static void numberInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    static void printPosition(Car car) {
        System.out.println(car.name + " : " + "-".repeat(car.position));
    }
}
