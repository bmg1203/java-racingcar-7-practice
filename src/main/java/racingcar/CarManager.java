package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자 입력으로부터 Car를 생성한다.
 * 자동차와 관련된 기능을 수행한다.
 */
public class CarManager {
    private static final String SPLITTER = ",";

    //TODO 중복 요소 확인시 문제가 되는 요소가 무엇인지 에러메시지에 적을 수 있도록 로직 개선
    public List<Car> createCarsFromInput(String input) {
        List<String> carNames = Arrays.stream(input.split(SPLITTER)).toList();

        validateCount(carNames);
        validateDuplicate(carNames);

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private void validateDuplicate(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 작성할 수 없습니다.");
        }
    }

    private void validateCount(List<String> carNames) {
        if (carNames.size() < 2 || carNames.size() > 1000) {
            throw new IllegalArgumentException("자동차의 개수는 최소 2개부터 최대 1,000개까지 가능합니다.");
        }
    }

    public List<Car> findWinner(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 결과입니다."));

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }
}
