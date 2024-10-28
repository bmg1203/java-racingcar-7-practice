package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RacingRequestDto;
import racingcar.dto.RacingResponseDto;
import racingcar.model.car.Car;
import racingcar.model.car.strategy.MoveBehavior;
import racingcar.model.car.strategy.RandomMove;
import racingcar.model.racing.Racing;
import racingcar.model.result.RoundResult;
import racingcar.util.CarNameParser;
import racingcar.util.RaceRoundParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void run() {
        RacingRequestDto racingRequest = inputView.getRacingRequest();
        Racing racing = initRacing(racingRequest);

        List<RoundResult> roundResults = runRacing(racing);
        List<String> winners = racing.getWinners()
                .stream()
                .map(Car::getName)
                .toList();

        outputView.printRacingResponse(new RacingResponseDto(roundResults, winners));
    }

    private Racing initRacing(RacingRequestDto racingRequest) {
        MoveBehavior behavior = new RandomMove();
        List<String> carNames = CarNameParser.parseCarName(racingRequest.rawCarNames());
        List<Car> cars = carNames.stream()
                .map(carName -> new Car(behavior, carName))
                .toList();
        int roundsToRace = RaceRoundParser.parseRaceRound(racingRequest.rawRoundsToRace());
        return Racing.from(cars, roundsToRace);
    }

    private List<RoundResult> runRacing(Racing racing) {
        List<RoundResult> roundResults = new ArrayList<>();
        while (racing.hasNextRound()) {
            racing.executeRound();
            roundResults.add(RoundResult.from(racing.getParticipants().getParticipants()));
        }
        return roundResults;
    }
}
