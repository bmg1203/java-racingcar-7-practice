package racingcar.model;

import java.util.Objects;

public class RacingCount {

    private static final int MIN_COUNT = 1;

    private final int count;

    private RacingCount(int count) {
        validateCount(count);
        this.count = count;
    }

    public static RacingCount from(int count) {
        return new RacingCount(count);
    }

    private void validateCount(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("시도횟수는 최소 1회 이상이여아 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCount that = (RacingCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }
}
