package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarsParser {

    public List<Car> parse(String invalidCarNames) {
        List<String> splitCarNames = getSplitCarNames(invalidCarNames);
        validateCarNames(splitCarNames);

        return splitCarNames.stream()
                .map(Car::new)
                .toList();
    }

    private List<String> getSplitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    private void validateCarNames(List<String> splitCarNames) {
        validateCarLength(splitCarNames);
        validateNoDuplicates(splitCarNames);
    }

    private void validateCarLength(List<String> splitCarNames) {
        if (splitCarNames.size() < 2) {
            throw new IllegalArgumentException("경주를 하기 위해서는 두대 이상의 자동차가 필요합니다.");
        }
    }

    private void validateNoDuplicates(List<String> splitCarNames) {
        if (splitCarNames.stream().distinct().count() != splitCarNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
        }
    }
}
