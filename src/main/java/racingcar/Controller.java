package racingcar;

import java.util.List;
import racingcar.argumentresolver.ArgumentResolver;
import racingcar.argumentresolver.AttemptCountArgumentResolver;
import racingcar.argumentresolver.CarArgumentResolver;

public class Controller {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private final ArgumentResolver<List<String>> carArgumentResolver = new CarArgumentResolver();
    private final ArgumentResolver<Integer> attemptCountArgumentResolver = new AttemptCountArgumentResolver();

    private final SizeValidator sizeValidator = new SizeValidator();
    private final RangeValidator rangeValidator = new RangeValidator();

    private final CarConverter carConverter = new CarConverter();
    private final AllCarMover allCarMover = new AllCarMover();

    private final WinnersDecider winnersDecider = new WinnersDecider();


    public void run() {
        outputView.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCarNamesRequest = inputView.read();

        List<String> carNames = carArgumentResolver.parse(racingCarNamesRequest);
        sizeValidator.check(carNames);
        List<Car> cars = carConverter.toCars(carNames);

        outputView.println("시도할 횟수는 몇 회인가요?");
        String attemptCountRequest = inputView.read();
        int attemptCount = attemptCountArgumentResolver.parse(attemptCountRequest);
        rangeValidator.check(attemptCount);

        outputView.endLine();
        outputView.println("실행 결과");
        for (int count = 0; count < attemptCount; count++) {
            allCarMover.run(cars);
            outputView.printCarsStatus(cars);
            outputView.endLine();
        }

        outputView.print("최종 우승자 : ");
        List<Car> winners = winnersDecider.run(cars);
        List<String> winnerNames = carConverter.toNames(winners);
        outputView.printNames(winnerNames);
    }

}
