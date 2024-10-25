package racingcar;

import static racingcar.controller.carMoveController.moveController;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.domain.InputContainer;
import racingcar.repository.RacingCarRepository;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validator validator = new Validator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarRepository racingCarRepository = RacingCarRepository.getInstance();


        InputContainer inputContainer = inputView.readConsole();
        String inputCars = inputContainer.getCars();
        int attempts = inputContainer.getAttempts();
        String[] cars = inputCars.split(",");

        Map<String, String> carMoveMap = racingCarRepository.getCarMoveMap();
        for(String car : cars) { //cars의 앞 뒤에 공백이 있을 경우 고려
            Boolean carNameLengthValidate = validator.carNameLengthValidate(car);
            if (carNameLengthValidate) {
                carMoveMap.put(car, "");
            } else {
                throw new IllegalArgumentException("레이싱카의 이름의 길이는 5를 넘을 수 없습니다.");
            }
        }


        int trial = 0;
        int randomNum = 0;
        while (trial < attempts) {
            trial++;
            moveController(cars, carMoveMap);
            outputView.printPerAttempt(carMoveMap);
        }

        int winnerPosition = 0;
        ArrayList<String> winners = new ArrayList<>();
        for (Entry<String, String> items : carMoveMap.entrySet()) {
            int position = items.getValue().length();

            if (position > winnerPosition) {
                winnerPosition = position;
                winners.clear();
                winners.add(items.getKey());
            } else if (position == winnerPosition) {
                winners.add(items.getKey());
            } else {
                continue;
            }
        }

        outputView.printWinner(winners);
    }


}
