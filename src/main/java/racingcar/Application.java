package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;
// 각 자동차 입력받기

public class Application {
    private static List<String> registerCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine();
        String[] names = input.split(",");

        List<String> carNames = new ArrayList<>();
        for (String name : names) {
            name = name.trim(); // 공백 제거
            if (name.length() <= 5) {
                carNames.add(name);
            } else {
                System.out.println("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return carNames;
    }

    public static void main(String[] args) {
        // 자동차 입력받기
        List<String> carNames = registerCars();
        System.out.println(carNames);
    }
}
