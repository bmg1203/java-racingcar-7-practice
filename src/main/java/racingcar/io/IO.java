package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class IO {
    /**
     * @return
     * 리스트를 반환
     * 0번 인덱스: 경주할 자동 이름들
     * 1번 인덱스: 경주 횟수
     */
    public static List<String> read() {
        List<String> inputs = new ArrayList<>();

        System.out.println(Constants.INPUT_CAR_NAME);
        //첫번째 입력 처리
        try {
            inputs.add(Console.readLine());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        } finally {
            Console.close();
        }

        System.out.println(Constants.INPUT_RACE_ROUND);
        //두번째 입력 처리
        try {
            inputs.add(Console.readLine());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        } finally {
            Console.close();
        }

        return inputs;
    }
}
