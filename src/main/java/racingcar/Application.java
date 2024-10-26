package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Application {

    static void race(Map<String, Integer> cars, List<String> keys) {
        for (String key : keys) {
            int n = Randoms.pickNumberInRange(0, 9);

            if (n >= 4) {
                cars.put(key, cars.get(key) + 1);
            }

            System.out.println(key + " : " + "-".repeat(cars.get(key)));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> keys = List.of(Console.readLine().split(","));
        // 예외처리: 입력한 자동차 이름이 올바르지 않은 경우
        if (!InputValidation.isValidKeys(keys)) {
            throw new IllegalArgumentException();
        }

        Map<String, Integer> cars = new HashMap<>();
        for (String key : keys) {
            cars.put(key, 0);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numInput = Console.readLine();
        if (!InputValidation.isValidNumber(numInput)){
            throw new IllegalArgumentException();
        }
        int num = Integer.parseInt(numInput);

        System.out.println("\n실행 결과");
        for (int i = 0; i < num; i++) {
            race(cars, keys);
        }

        List<String> winners = new LinkedList<>();
        int maxMove = 0;
        for (String key : keys) {
            int move = cars.get(key);
            if (move > maxMove) {
                maxMove = move;
                winners.clear();
                winners.add(key);
            } else if (move == maxMove) {
                winners.add(key);
            }
        }

        String result = String.join(", ", winners);
        if (maxMove == 0) {
            System.out.println("최종 우승자 : 없음");
        }else{
            System.out.println("최종 우승자 : " + result);
        }
    }
}
