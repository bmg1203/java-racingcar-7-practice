package racingcar.controller;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.service.Service;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class Controller {
    private Service service;
    private InputView inputView;
    private OutputView outputView;


    public Controller(Service service, InputView inputView, OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void play() {
        String[] carListInput = inputView.showCarListInput();
        String tryNumber = inputView.showTryNumberInput();
        inputView.startProcessView();

        service.saveCars(carListInput);
        service.play(tryNumber);
        List<CarDto> winners = service.whoIsWinner();
        outputView.showResult(winners);

    }
}
