package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final int MIN_COUNT = 1;
    private static final int MAX_NAMES_COUNT = 10;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_PLAY_COUNT = 25;
    private static final int MIN_MOVE_NUMBER = 4;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            startGame();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void startGame()  {
        printStartMessage();
        String input = getCarNamesInput().replaceAll(" ","");
        validateEmptyInput(input);
        String[] names = splitWithComma(input);
        validateNamesCount(names);
        validateNameLength(names);
        printTryCountMessage();
        input = getPlayCount();
        int playCount = validateNumber(input);
        validatePlayCount(playCount);
        playGame(names, playCount);
    }

    public static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printTryCountMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static String getCarNamesInput() {
        return Console.readLine();
    }

    public static void validateEmptyInput(String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException("정확한 값을 입력해 주세요.");
        }
    }

    public static String[] splitWithComma(String input) {
        return input.split(",");
    }

    public static void validateNamesCount(String[] names) {
        if(names.length > MAX_NAMES_COUNT || names.length < MIN_COUNT) {
            throw new IllegalArgumentException("가능한 자동차 수는 최소 1대, 최대 10대입니다.");
        }
    }

    public static void validateNameLength(String[] names) {
        for(String name : names){
            if(name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름의 길이는 1자이상 5자 이하여야 합니다.");
            }
        }
    }

    public static String getPlayCount() {
        return Console.readLine();
    }

    public static int validateNumber(String input) {
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수는 숫자가 입력되어야 합니다.");
        }
    }

    public static void validatePlayCount(int playCount) {
        if (playCount > MAX_PLAY_COUNT || playCount < MIN_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 " + MAX_PLAY_COUNT + "이하인 자연수여야 합니다.");
        }
    }

    private static void playGame(String[] names, int playCount) {
        int[] moves = new int[names.length];
        printGamePlayStartMessage();
        for(int i = 0; i < playCount; i++){
            moveCars(moves);
            printCurrentMoves(names,moves);
        }
    }

    public static void moveCars(int[] moves) {
        int number = 0;
        for(int i = 0; i < moves.length; i++){
            number = Randoms.pickNumberInRange(0,9);
            if(number >= MIN_MOVE_NUMBER){
                moves[i]++;
            }
        }
    }

    public static void printGamePlayStartMessage() {
        System.out.println("\n실행결과");
    }

    public static void printCurrentMoves(String[] names, int[] moves) {
        for(int i = 0 ; i < names.length; i++){
            System.out.print(names[i] + " : ");
            for(int j = 0 ; j < moves[i]; j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
