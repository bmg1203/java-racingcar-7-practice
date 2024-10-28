package racingcar;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputHandler inputHandler = new InputHandler();
        List<String> carNames = inputHandler.getCarNames();
        Integer tryCount = inputHandler.getTryCount();

        RacingSimulation racingSimulation = new RacingSimulation();
        List<CarRecord> carRecords = racingSimulation.simulateRace(carNames, tryCount);

    }
}
