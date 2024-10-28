package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RegistrationManager {

    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private Car[] cars;

    public RegistrationManager(List<String> carNames) {
        cars = new Car[carNames.size()];
        enroll(carNames);
    }

    public void enroll(List<String> name) {
        for (int index = 0; index < cars.length; index++) {
            cars[index] = new Car(name.get(index));
        }
    }

    private String getLowerCaseName(String carName) {
        carName = carName.trim();
        if (!Pattern.matches("[a-zA-Z]+", carName)) {
            throw new IllegalArgumentException("자동차 이름은 알파벳으로만 구성되어야 합니다.");
        }
        return carName.toLowerCase();
    }

    private static void isValidlengthName(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void checkValidCarNames() {
        for (Car car : cars) {
            String curCarName = car.name();
            car.rename(getLowerCaseName(curCarName));
            isValidlengthName(car.name());
        }
    }

    public void checkDuplicatePlayer() {
        ArrayList<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            if (carNames.contains(car.name())) {
                throw new IllegalArgumentException("중복된 자동차 이름은 사용할 수 없습니다.(대문자와 소문자는 동일하게 인식됩니다.)");
            }
            carNames.add(car.name());
        }
    }

    public void checkValidCarCount() {
        if (cars.length < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("자동차 대수는 2대 이상이여야 합니다.");
        }
    }

    public Car[] getRegisteredPlayers() {
        return cars;
    }

}
