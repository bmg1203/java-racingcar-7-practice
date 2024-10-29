package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input.split(",");
    }

    public int readRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int rounds = Integer.parseInt(Console.readLine());
            if (rounds <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
            }
            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }
}
