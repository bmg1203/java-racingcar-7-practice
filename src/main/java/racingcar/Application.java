package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars_name = Console.readLine();
        // 자동차 이름 길이 검사
        String[] cars_list = ValidateCarNames.validateCarNames(cars_name);
        // 각 자동차의 전진 횟수 저장
        ArrayList<Integer> advanceCountList = CreateAdvanceCount.createAdvanceCount(cars_list);

    }


}
