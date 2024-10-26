package racingcar;
import static java.util.stream.Collectors.joining;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<String> cars = getCars();

        int count = getCount();

        List<Integer> moves = new ArrayList<>(Collections.nCopies(cars.size(),0));

        runRace(count, cars, moves);

        printWinner(cars, moves);
    }

    private static List<String> getCars() {
        String input = getString();
        List<String> cars = parseCarList(input);
        return cars;
    }

    private static String getString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static List<String> parseCarList(String input) {
        List<String> cars = new ArrayList<String>(Arrays.asList(input.split(",")));
        return cars;
    }

    private static int getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private static void runRace(int count, List<String> cars, List<Integer> moves) {
        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < cars.size(); j++) {
                moveForward(moves, j);
            }
            printMoves(cars, moves);
        }
    }

    private static void moveForward(List<Integer> moves, int j) {
        if (determineMovement()) moves.set(j, moves.get(j) + 1);
    }

    private static boolean determineMovement() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private static void printMoves(List<String> cars, List<Integer> moves) {
        StringBuilder roundResult = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            roundResult.append(cars.get(i)).append(" : ");
            roundResult.append("-".repeat(moves.get(i)));
            roundResult.append("\n");
        }
        System.out.println(roundResult);
    }

    private static void printWinner(List<String> cars, List<Integer> moves) {
        int maxValue = getMaxValue(moves);

        List<Integer> maxIndices = getMaxIndices(moves, maxValue);

        String result = getResult(cars, maxIndices);

        System.out.println("최종 우승자 : " + result);
    }

    private static int getMaxValue(List<Integer> moves) {
        return moves.stream().max(Integer::compare).orElse(0);
    }

    private static List<Integer> getMaxIndices(List<Integer> moves, int maxValue) {
        List<Integer> maxIndices = new ArrayList<>();
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i).equals(maxValue)) {
                maxIndices.add(i);
            }
        }
        return maxIndices;
    }

    private static String getResult(List<String> cars, List<Integer> maxIndices) {
        String result = String.join(", ", maxIndices.stream()
                .map(index -> cars.get(index))
                .collect(Collectors.toList()));
        return result;
    }
}