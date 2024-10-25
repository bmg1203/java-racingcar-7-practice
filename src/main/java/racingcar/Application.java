package racingcar;

import racingcar.Input.Read;
import racingcar.Input.Split;
import racingcar.Input.Validation;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 자동차 이름 입력 요청 문자열 출력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        // 입력 받기
        String cars = Read.read();

        // 빈 문자열일 경우 예외 발생 시키기
        Validation.isnull(cars);

        // 입력 받은 문자열 쉼표 기준으로 나누기
        String [] carArray = Split.splitbycomma(cars);

        // 각 자동차 이름이 유효한지 확인
        for (String car : carArray) {
            Validation.isnull(car);
            Validation.lengthover5(car);
        }

        // 시도 횟수 입력 요청 문자열 출력
        System.out.println("시도할 횟수는 몇 회인가요?");

        // 입력 받기
        int movenumber = Integer.parseInt(Read.read());
        if (movenumber < 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }

        // 매번 값을 수정해야 하기 때문에 조회, 수정이 많아서 Map 자료형 선택
        Map<String, Integer> race = new HashMap<>();

        // Map 안에 자동차의 이름을 key로 초기값인 0 넣기
        for (String car : carArray) {
            race.put(car, 0);
        }
    }
}
