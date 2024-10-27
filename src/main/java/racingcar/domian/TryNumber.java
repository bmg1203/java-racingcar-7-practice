package racingcar.domian;

public class TryNumber {

    private int tryNumber;

    private TryNumber(int tryNumber) {
        this.tryNumber = tryNumber;
    }


    public static TryNumber createTryNumber(String tryNumber) {
        int convertedNumber = convertToInteger(tryNumber);
        return new TryNumber(convertedNumber);
    }

    private static int convertToInteger(String tryNumber) {
        try {
            return Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public int getTryNumber() {
        return tryNumber;
    }


}
