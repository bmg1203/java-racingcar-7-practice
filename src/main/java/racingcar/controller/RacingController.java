package racingcar.controller;

import java.util.Iterator;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.response.Winners;
import racingcar.service.RacingService;
import racingcar.util.Parser;
import racingcar.util.RandomNumberPicker;
import racingcar.view.RacingInputView;
import racingcar.view.RacingOutputView;

public class RacingController {

    private final RacingService racingService;
    private final RacingInputView inputView;
    private final RacingOutputView outputView;

    public RacingController(RacingService racingService, RacingInputView inputView, RacingOutputView outputView) {
        this.racingService = racingService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String namesInput = inputView.requestNamesInput();
        Cars cars = racingService.createCars(namesInput);

        String countInput = inputView.requestCountInput();
        progress(countInput, cars);

        Winners winners = racingService.findWinners(cars);
        finish(winners);
    }

    private void progress(String countInput, Cars collection) {
        int count = Parser.parseInt(countInput);
        List<Car> cars = collection.getCars();

        outputView.guideProgress();
        for (int i = 0; i < count; i++) {
            cars.forEach(car -> {
                car.move(RandomNumberPicker.pick());
                outputView.showProgressResult(car.getName(), car.getDistance());
            });
            outputView.enter();
        }
    }

    private void finish(Winners winners) {
        Iterator<Car> carIterator = winners.cars().iterator();

        outputView.guideFinal();
        winners.cars().forEach(winner -> {
            outputView.showWinners(carIterator.next().getName());
            if (carIterator.hasNext()) {
                outputView.delimit();
            }
        });
    }
}
