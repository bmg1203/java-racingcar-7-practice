package racingcar;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        MessagePrinter messagePrinter = new MessagePrinter();
        InputReader inputReader = new InputReader();
        InputExtractor inputExtractor = new InputExtractor();
        NumCounter numCounter = new NumCounter();
        MapBuilder mapBuilder = new MapBuilder();
        RandomPicker randomPicker = new RandomPicker();
        WinnerSorter winnerSorter = new WinnerSorter();

        System.out.println(messagePrinter.carNameGuideMessage);
        String userInputCar = inputReader.getUserInput();

        List<String> carNames = inputExtractor.extractCarNames(userInputCar);
        int carCount = numCounter.countCars(carNames);
        numCounter.validateCarCount(carCount);
        numCounter.validateCarNames(carNames);

        System.out.println(messagePrinter.roundNumGuideMessage);
        String userInputRound = inputReader.getUserInput();
        int totalRounds = inputExtractor.extractRound(userInputRound);

        // 자동차 이름과 전진횟수를 매핑
        mapBuilder.mapCarNamesToForwardCounts(carNames);
        // 자동차 이름과 출력할 라인 문자열을 매핑
        mapBuilder.mapCarNamesToStringForwardLines(carNames);

        System.out.println(messagePrinter.resultGuideMessage);
        // 입력된 라운드 횟수만큼 랜덤라운드 1회를 반복
        for(int i = 0; i < totalRounds; i++){
            randomPicker.runSingleRandomRound(carNames);
            mapBuilder.mapSingleRandomRoundResult(i);
        }
        System.out.println(messagePrinter.totalRandomResultMessage());

        //우승자 목록 도출하기
        Map<String, Integer> totalForwardCount= mapBuilder.getCarNameAndForwardCount();
        Map<String, Integer> sortedTotalForwardCount = winnerSorter.sort(totalForwardCount);
        List<String> winnerList = winnerSorter.getJointWinners(sortedTotalForwardCount);
    }
}