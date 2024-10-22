package racingcar.view;

public class OutputView {
    private static final String START_COMMAND="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_COUNTS="시도할 횟수는 몇 회인가요?";
    private static final String RACING_PROCESS="실행 결과";
    private static final String RACING_WINNER="결과 : %s";

    public static void printStartCommand(){
        System.out.println(START_COMMAND);
    }

    public static void printRacingCounts(){
        System.out.println(RACING_COUNTS);
    }

    public static void printRacingProcess(){
        System.out.println(RACING_PROCESS);
    }

    public static void printRacingWinner(){
        System.out.println(RACING_WINNER);
    }
}
