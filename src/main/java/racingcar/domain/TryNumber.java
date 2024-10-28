package racingcar.domian;

public class TryNumber {

    private int tryNumber;

    private static final String NUMBER_RANGE_ERROR =
            "[ERROR]:시도횟수의범위를 확인해주세요. " + "[" + "1 ~ " + Integer.MAX_VALUE + "]";
    private static final String NUMBER_NOT_POSITIVE_NUMBER_ERROR = "[ERROR]:시도횟수는 양수를 입력해주세요.";
    private static final String NUMBER_CAN_NOT_PARSE_ERROR = "[ERROR]:숫자로 변환 할 수 없습니다.";


    private TryNumber(int tryNumber) {
        this.tryNumber = tryNumber;
    }


    public static TryNumber createTryNumber(String tryNumber) {
        int convertedNumber = convertToInteger(tryNumber);
        isPositiveNumber(convertedNumber);
        return new TryNumber(convertedNumber);
    }


    private static int convertToInteger(String tryNumber) {
        try {
            long parseLong = Long.parseLong(tryNumber);
            return validateMaxRange(parseLong);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_CAN_NOT_PARSE_ERROR);
        }

    }


    private static int validateMaxRange(long parseLong) {
        if (parseLong > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
        }
        return (int) parseLong;
    }


    public int getTryNumber() {
        return tryNumber;
    }


    private static boolean isPositiveNumber(int tryNumber) {
        if (tryNumber > 0) {
            return true;
        }
        throw new IllegalArgumentException(NUMBER_NOT_POSITIVE_NUMBER_ERROR);
    }


}
