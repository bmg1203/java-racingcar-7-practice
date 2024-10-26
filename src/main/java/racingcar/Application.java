package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static List<String> winnerList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        long attempt = Long.parseLong(Console.readLine());

        Map<String, Long> map = new HashMap<String, Long>();
        for (String name : carName.split(",")) {
            map.put(name, 0L);
        }

        System.out.println("\n실행 결과");

        repeat(attempt, map);
        winnerSelect(map);

        System.out.println("최종 우승자 : " + String.join(",", winnerList));
    }

    public static void winnerSelect(Map<String, Long> map) {
        long winnerNum = Collections.max(map.values());

        for (Map.Entry<String, Long> entry : map.entrySet()) {
            long value = entry.getValue();
            if (value == winnerNum) {
                winnerList.add(entry.getKey());
            }
        }
    }

    public static void repeat(long attempt, Map<String, Long> map) {
        while (attempt-- > 0) {
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                forwardDecision(map, entry);
            }
            practiceOutput(map);
            System.out.println();
        }
    }

    public static void forwardDecision(Map<String, Long> map, Map.Entry<String, Long> entry) {
        if (randomDraw()) {
            map.put(entry.getKey(), entry.getValue() + 1);
        }
    }

    public static boolean randomDraw() {
        int n = Randoms.pickNumberInRange(0, 9);
        return n >= 4;
    }

    public static void practiceOutput(Map<String, Long> map) {
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + mark(entry.getValue()));
        }
    }

    public static String mark(long count) {
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < count; i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
