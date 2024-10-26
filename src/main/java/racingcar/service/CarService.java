package racingcar.service;

public class CarService {
    String[] cars;
    int moveCount;

    public void createGame(String carNames) {
        splitCarNames(carNames);
        for (String car: cars) {
            validateCarNames(car);
        }
    }

    public void splitCarNames(String carNames) {
        cars = carNames.split(",");
    }

    public void validateCarNames(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}
