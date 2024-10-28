package racingcar;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String carNames = inputView.readLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Cars cars = new Cars(Parser.trimSplit(carNames));

        String playCountInput = inputView.readLine("시도할 횟수는 몇 회인가요?");
        PlayCount playCount = new PlayCount(playCountInput);

        Race race = new Race(outputView);
        race.play(cars, playCount);
    }
}
