package racingcar.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;
import racingcar.model.CarRacing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingController {

    private static final String WHITE_SPACE = " ";
    private static final String EMPTY_STRING = "";

    private final InputView inputView;
    private final OutputView outputView;
    private CarRacing carRacing;
    private int totalRound;

    public CarRacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        setUpCarRacing();
        setUpTotalRound();
        startCarRacing();
        displayFinalWinner();
    }

    private void startCarRacing() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < totalRound; i++) {
            carRacing.moverCarsForwardRandomly();
            outputView.showRoundResult(carRacing.getRacingCars());
        }
    }

    private void setUpCarRacing() {
        String carNameInput = inputView.getRacingCarNameInput();
        List<String> carNames = validateCarNameInput(carNameInput);
        List<Car> racingCars = carNames.stream().map(Car::new).toList();
        this.carRacing = new CarRacing(racingCars);
    }

    private void setUpTotalRound() {
        String totalRoundInput = inputView.getTotalRoundInput();
        validateTotalRoundInput(totalRoundInput);
    }

    private void displayFinalWinner() {
        outputView.showFinalWinner(carRacing.getWinners());
    }

    public List<String> validateCarNameInput(String carNameInput) {
        String trimmedCarNameInput = carNameInput.replaceAll(WHITE_SPACE, EMPTY_STRING);

        if (trimmedCarNameInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름으로 공백은 불가능합니다.");
        }
        if (!trimmedCarNameInput.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표로 구분합니다. 쉼표를 입력해주세요.");
        }

        List<String> carNames = Arrays.stream(trimmedCarNameInput.split(",")).toList();
        Set<String> nameSet = new HashSet<>();
        if (carNames.size() == 1 || carNames.contains(EMPTY_STRING)) {
            throw new IllegalArgumentException("자동차 이름은 2개 이상 입력해야합니다.");
        }
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다: " + name);
            }
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
        return carNames;
    }

    public void validateTotalRoundInput(String totalRoundInput) {
        if (totalRoundInput.isBlank()) {
            throw new IllegalArgumentException("시도 횟수를 공백 없이 자연수로 입력해주세요.");
        }
        try {
            totalRound = Integer.parseInt(totalRoundInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 공백 없는 하나의 자연수만 가능합니다.");
        }
        if (totalRound <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 큰 자연수만 가능합니다.");
        }
    }
}
