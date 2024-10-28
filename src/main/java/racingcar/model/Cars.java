package racingcar.model;

import static racingcar.constant.ErrorMessages.DUPLICATE_CAR_NAME;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private static final String DELIMITER = ",";
    private final List<Car> cars;

    public Cars(String carNames) {
        validateUniqueNames(carNames);

        cars = new ArrayList<>();
        for (String name : carNames.split(DELIMITER)) {
            cars.add(new Car(new CarName(name)));
        }
    }

    public void moveCarsAccordingToGameRule() {
        cars.forEach(car -> car.moveRandomly(Randoms.pickNumberInRange(0, 9)));
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateUniqueNames(String carNames) {
        String[] namesArray = carNames.split(DELIMITER);
        Set<String> uniqueNames = new HashSet<>(List.of(namesArray));

        if (uniqueNames.size() != namesArray.length) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        }
    }
}