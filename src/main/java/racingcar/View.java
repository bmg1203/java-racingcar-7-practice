package racingcar;


public class View {
    public void printInputPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printResults(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
