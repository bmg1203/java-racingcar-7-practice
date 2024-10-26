package racingcar.controller;

import racingcar.service.ViewService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ViewController {
    private static ViewController viewController;
    private static InputView inputView=InputView.getInstance();
    private static OutputView outputView=OutputView.getInstance();

    public static ViewController getInstance() {
        if (viewController == null){
            viewController = new ViewController();
        }
        return viewController;
    }

    public void printGuide(){
        outputView.inputMessage();
        String carName = inputView.readLine();
    }

    public void printCountGuide(){
        outputView.inputCountMessage();
        inputView.readLine();

    }
}
