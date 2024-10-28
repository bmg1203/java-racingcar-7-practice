package racingcar.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.RacingCar;
import racingcar.inputManager.InputManager;
import racingcar.outputManager.OutputManager;
import racingcar.referee.Referee;

public class Race {
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private final Referee referee;

    public Race(InputManager inputManager, OutputManager outputManager, Referee referee){
        this.inputManager = inputManager;
        this.outputManager = outputManager;
        this.referee = referee;
    }

    public List<Car> createParticipant(List<String> carName) {
        List<Car> carList = new ArrayList<>();

        if(carName.isEmpty()){
            throw new NullPointerException("리스트가 비었습니다.");
        }

        for(int i = 0; i < carName.size(); i++){
            String name = carName.get(i);
            carList.add(new RacingCar(name));
        }
        return carList;
    }

    public void start() {
        inputManager.whatIsYourName();
        List<String> carName = inputManager.splitName(inputManager.getName());
        List<Car> carList = createParticipant(carName);

        inputManager.HowManyAttempt();
        int attemptCount = inputManager.getNumberOfAttempt();

        System.out.println();
        System.out.print("실행 결과");
        for(int i = 0; i < attemptCount; i++){
            List<Car> result = referee.checkDrivingDistance(carList);
            outputManager.printExecutionResult(result);
        }

        List<Car> winners = referee.judgeWinner(carList);
        outputManager.printWinner(winners);
    }
}
