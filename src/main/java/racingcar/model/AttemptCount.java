package racingcar.model;

import java.math.BigInteger;

public class AttemptCount {
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger DECREMENT_VALUE = BigInteger.ONE;
    private BigInteger count;

    public AttemptCount(String count) {
        this.count = convertToBigInteger(count);
        validateNonNegative(this.count);
    }

    public boolean isCountZero() {
        return count.equals(ZERO);
    }

    public void decreaseCount() {
        count = count.subtract(DECREMENT_VALUE);
    }

    private BigInteger convertToBigInteger(String count) {
        try {
            return new BigInteger(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다.");
        }
    }

    private void validateNonNegative(BigInteger number) {
        if (isNegative(number)) {
            throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
        }
    }

    private boolean isNegative(BigInteger number) {
        return number.compareTo(BigInteger.ZERO) < 0;
    }
}
