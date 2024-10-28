package racingcar;

public class ExceptionHandler {
    public static String[] carNamesException(String cars){
        if (!cars.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분되어야 합니다.");
        }

        String[] carNames = cars.split(",");

        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있습니다.");
            }

            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해야 합니다. Name: " + carNames[i]);
            }

            for (int j = i + 1; j < carNames.length; j++) {//중복 체크
                if (carNames[i].equals(carNames[j])) {
                    throw new IllegalArgumentException("자동차 이름이 중복되었습니다 Name : " + carNames[i]);
                }
            }

        }
        return carNames;
    }

    public static Integer Exception(String input) {
        int tryCount;

        try {
            tryCount = Integer.parseInt(input);
            if (tryCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

        return tryCount;
    }
}