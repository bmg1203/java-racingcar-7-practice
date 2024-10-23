package racingcar.car;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<String> carNames) {
        validateDuplicateCars(carNames);

        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void validateDuplicateCars(List<String> carNames) {
        int count = (int) carNames.stream()
                .distinct()
                .count();

        if (count != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복으로 입력할 수 없습니다.");
        }
    }
}
