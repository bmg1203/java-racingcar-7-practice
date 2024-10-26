package racingcar;

public class Validator {

    static void validateCarNames(String carNames) {
        checkNameExist(carNames);
        for (String carName : carNames.split(",", -1)) {
            String stripCarName = carName.strip();
            checkEmptyName(stripCarName);
            checkCarNameLength(stripCarName);
        }
    }

    static void checkNameExist(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다");
        }
        String[] splitCarNames = carNames.split(",");
        if (splitCarNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다");
        }
    }

    static void checkEmptyName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("쉼표 이전 또는 이후에 자동차 이름이 존재하지 않습니다");
        }
    }

    static void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다");
        }
    }

    static void validateTryCount(String tryCount) {
        try {
            int tryCountNum = Integer.parseInt(tryCount);
            checkNotPositiveValue(tryCountNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수가 자연수가 아닙니다");
        }
    }

    static void checkNotPositiveValue(int tryCountNum) {
        if (tryCountNum <= 0) {
            throw new IllegalArgumentException("시도할 횟수가 자연수가 아닙니다");
        }
    }
}
