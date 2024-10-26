package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();

        if (carName == null || carName.isEmpty()){
            throw new IllegalArgumentException("경주할 자동차 이름 입력 필요함.");
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCount = Console.readLine();

        List<String> carNameList = Arrays.asList(carName.split(","));
    }
}