package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNum = Integer.parseInt(Console.readLine());

        List<String> carNames = nameSpliter(inputNames);
    }

    public static List<String> nameSpliter(String inputNames) {
        String[] splittedNames = inputNames.split(",");
        List<String> carNames = Arrays.stream(splittedNames).collect(Collectors.toList()); // array를 list로 변환
        for (String name : carNames) {
            if(name.length() > 5){
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }
}
