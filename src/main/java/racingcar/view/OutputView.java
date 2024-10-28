package racingcar.view;

import java.util.LinkedHashMap;

public class OutputView {

    private static final String FIRST_INITIAL_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SECOND_INITIAL_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String PLAY_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printFirstInitialMessage() {
        System.out.println(FIRST_INITIAL_MESSAGE);
    }

    public void printSecondInitialMessage() {
        System.out.println(SECOND_INITIAL_MESSAGE);
    }

    public void printPlayMessage() {
        System.out.println(PLAY_MESSAGE);
    }

    public void printRoundResult(LinkedHashMap<String, Integer> gameEntry) {
        for (String carName : gameEntry.keySet()) {
            String result = getResult(gameEntry.get(carName));
            System.out.println(carName + " : " + result);
        }
        System.out.print('\n');
    }

    private String getResult(Integer value) {
        String result = "";
        for (int i = 0; i < value; i++) {
            result = result + "-";
        }
        return result;
    }

    public void printWinnerMessage(String winner) {
        System.out.println(WINNER_MESSAGE + winner);
    }
}
