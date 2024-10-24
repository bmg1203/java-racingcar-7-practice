package racingcar.view;

import racingcar.util.io.InputConsole;

public class InputView {

    private final int MINIMUM_TRY_COUNT = 1;

    public String getCarNames() {
        return InputConsole.readLine();
    }

    public int getTryCount() {
        try {
            int tryCount = Integer.parseInt(InputConsole.readLine());
            validateTryCount(tryCount);
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 시도 횟수입니다.");
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
