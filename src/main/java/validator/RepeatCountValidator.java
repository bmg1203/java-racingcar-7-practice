package validator;

public class RepeatCountValidator {

    public static void validateInputRepeatCount(String inputRepeatCount) {
        repeatCountShouldNotBeBlank(inputRepeatCount);
        repeatCountShouldNotBeBigNumber(inputRepeatCount);
        repeatCountShouldNotBeChar(inputRepeatCount);
        repeatCountShouldNotBeNegativeNumber(Integer.parseInt(inputRepeatCount));
    }

    private static void repeatCountShouldNotBeBlank(String inputRepeatCount) {
        if (inputRepeatCount.isEmpty()) {
            throw new IllegalArgumentException("반복 횟수가 입력되지 않았습니다.");
        }
    }

    private static void repeatCountShouldNotBeBigNumber(String inputRepeatCount) {
        try {
            Integer.parseInt(inputRepeatCount);
        } catch (NumberFormatException e) {
            if (isNumber(inputRepeatCount)) {
                throw new IllegalArgumentException("반복횟수가 너무 큽니다.");
            }
        }
    }

    private static void repeatCountShouldNotBeChar(String inputRepeatCount) {
        try {
            Integer.parseInt(inputRepeatCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("반복 횟수에 숫자가 아닌 문자가 입력 됐습니다.");
        }
    }

    private static void repeatCountShouldNotBeNegativeNumber(int repeatCount) {
        if (repeatCount < 0) {
            throw new IllegalArgumentException("반복 횟수는 0 이상의 정수 입니다.");
        }
    }


    private static boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
