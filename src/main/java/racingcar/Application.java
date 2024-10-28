package racingcar;


import racingcar.controller.RacingController;
import racingcar.dto.RaceRequest;
import racingcar.model.RacingModel;
import racingcar.view.RacingView;


public class Application {

    public static void main(String[] args) {
        RacingModel model = new RacingModel();
        RacingView view = new RacingView();
        RacingController controller = new RacingController(model, view);

        String[] carNames = view.getCarNames();
        int roundCount = view.getRoundCount();
        RaceRequest request = new RaceRequest(carNames, roundCount);
        controller.run(request);  // 게임 실행

    }
}
