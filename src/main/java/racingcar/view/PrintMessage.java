package racingcar.view;

public class PrintMessage {

    public static final String START_MESSAGE = "경주할 자동자 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ATTEMPTS_GAME_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public static final String RESULT_MESSAGE = "\n실행 결과";
    public static final String END_GAME_MESSAGE = "최종 우승자 : ";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printAttemptsMessage() {
        System.out.println(ATTEMPTS_GAME_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printEndGameMessage(String winners) {
        System.out.println(END_GAME_MESSAGE + winners);
    }

    public void printCarProgress(String carName, String progress) {
        System.out.println(carName + " : " + progress);
    }

}
