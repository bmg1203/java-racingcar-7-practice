package racingcar.view;

public class OutputView {
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private OutputView(){

    }

    public static OutputView getInstance() {
        return OUTPUT_VIEW;
    }
}
