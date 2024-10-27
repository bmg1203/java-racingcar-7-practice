package racingcar.domian;

public class TryNumber {

    private int tryNumber;


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
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }

    }


    private static int validateMaxRange(long parseLong) {
        if (parseLong > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("시도횟수의범위를 확인해주세요. " + "[" + "1 ~ " + Integer.MAX_VALUE + "]");
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
        throw new IllegalArgumentException("시도횟수는 양수를 입력해주세요.");
    }


}
