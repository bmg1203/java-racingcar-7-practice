package racingcar.racingapp.model.value.vo;

import racingcar.racingapp.model.value.enums.RaceMaxCounts;

public record Mileage(Integer distance) implements Comparable<Mileage> {

    public static final int MINIMUM_MILEAGE = 0;
    private static final Integer LIMIT_OF_DISTANCE = RaceMaxCounts.MAX_COUNT_OF_LAP.getCount();

    public Mileage {
        if (distance == null) {
            throw new IllegalArgumentException("주행거리가 입력되지 않았습니다.");
        }
        if (distance < MINIMUM_MILEAGE) {
            throw new IllegalArgumentException("주행거리는 음수일 수 없습니다.");
        }
        if (isExceededMaxMileage(distance)) {
            throw new IllegalArgumentException(String.format("지정 가능한 최대 주행 거리는 %d입니다.", LIMIT_OF_DISTANCE));
        }
    }

    public Mileage getIncreased() {
        return new Mileage(distance + 1);
    }

    private static boolean isExceededMaxMileage(Integer distance) {
        return LIMIT_OF_DISTANCE.compareTo(distance) < 0;
    }

    @Override
    public int compareTo(Mileage other) {
        if (other == null) {
            throw new IllegalArgumentException("null은 비교할 수 없습니다.");
        }
        return distance.compareTo(other.distance);
    }

}
