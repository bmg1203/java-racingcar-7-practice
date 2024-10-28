package racingcar.io;

public class Output {

    public static void printNameGuide() {
        printString("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private static void printString(String string) {
        System.out.println(string);
    }

    public static void printGameCountGuide() {
        printString("시도할 횟수는 몇 회인가요?");
    }

    public static void printManyLines(String hasManyLines) {
        String[] lines = hasManyLines.split("\n");
        for (String line : lines) {
            printString(line);
        }
        paragraphSeparator();
    }

    private static void paragraphSeparator() {
        printString("---");
    }

    public static void printProgressGuide() {
        printString("게임 진행 상황");
    }
}
