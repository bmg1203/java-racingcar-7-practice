package racingcar;

import java.util.List;

public class InputExtractor {

    public List<String> extractCarNames(String userInputCar) {
        validateUserInputCar(userInputCar);

        String delimiter = ",";
        List<String> carNames = List.of(userInputCar.split(delimiter));
        validateCarNames(carNames);

        return carNames;
    }

    public int extractRound(String userInputRound) {
        try {
            int totalRounds = Integer.parseInt(userInputRound);
            validateRounds(totalRounds);
            return totalRounds;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public int countCars(List<String> carNames) {
        int carCount = carNames.size();
        validateCarCount(carCount);

        return carCount;
    }

    public void validateUserInputCar(String userInputCar) {
        if (userInputCar == null) {
            throw new IllegalArgumentException();
        }
    }

    public void validateCarNames(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            validateCarName(carName);
        }
    }

    public void validateCarName(String carName) {
        int carNameLength = carName.length();
        if (carNameLength <= 0 || carNameLength > 5) {
            throw new IllegalArgumentException();
        }

        int trimedCarNameLength = carName.trim().length();
        if (trimedCarNameLength == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateCarCount(int carCount) {
        if (carCount <= 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRounds(int totalRounds) {
        if (totalRounds <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
