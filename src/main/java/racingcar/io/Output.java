package racingcar.io;

import java.util.*;

public class Output {
    public static void carName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void tryNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void error() {
        System.out.println("올바르지 않은 입력입니다.");
    }

    public static void result() {
        System.out.println("\n실행 결과");
    }

    public static void winner(List<String> winnerlist) {
        System.out.print("최종 우승자 : " + winnerlist.getFirst());
        if(winnerlist.size() > 1) {
            for(int i=1; i<winnerlist.size(); i++) {
                System.out.print(", " + winnerlist.get(i));
            }
        }
    }
}
