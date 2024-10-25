package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public  static String getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();

        if (carInput == null) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.\n");
        }
        return carInput;
    }

    public static String[] trimCars(String[] cars) {
        for (int i = 0; i < cars.length; i++) {
            cars[i] = cars[i].trim();

            if (cars[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.\n");
            }
        }
        if (cars.length > 10) {
            throw new IllegalArgumentException("자동차는 10개 이하로 입력해 주세요.\n");
        }
        return cars;
    }

    public static int getRaceNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberInput = Console.readLine();
        int numberInt = Integer.parseInt(numberInput);

        if (numberInt > 10) {
            throw new IllegalArgumentException("횟수는 10회 이하로 입력해주세요\n");
        }
        return numberInt;
    }

    // 각 자동차가 전진한 횟수 기록하는 기능도 있음
    public static void progressWhenMoreFour(List<StringBuilder> raceResult, int randomNumber, int j, int[] progresses) {
        if (randomNumber >= 4) {
            raceResult.get(j).append("-");
            progresses[j]++;
        }
    }

    public static void printWinner(String[] cars, int[] progresses) {
        int maxProgress = -1;
        List<String> winners = new ArrayList<>();

        for (int progress : progresses) {
            if (progress > maxProgress) {
                maxProgress = progress;
            }
        }
        for (int i = 0; i < cars.length; i++) {
            if (progresses[i] == maxProgress) {
                winners.add(cars[i]);
            }
        }

        System.out.print("최종 우승자 : ");
        var result = String.join(", ", winners);
        System.out.println(result);
    }

    public static void raceCar(String[] cars, int raceNumber){
        List<StringBuilder> raceResult = new ArrayList<>();
        int[] progresses = new int[cars.length];

        System.out.println("실행 결과");

        for (int i = 0; i < cars.length; i++) {
            raceResult.add(new StringBuilder());
        }

        for (int i = 0; i < raceNumber; i++) {
            for (int j = 0; j < cars.length; j++) {
                System.out.print(cars[j] + " : ");
                
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                progressWhenMoreFour(raceResult, randomNumber, j, progresses);
                
                System.out.print(raceResult.get(j));
                System.out.print("\n");
            }
            System.out.print("\n");
        }
        printWinner(cars, progresses);
    }

    public static void main(String[] args) {
        String carInput = getCarName();

        String[] splitCar = carInput.split(",", -1);
        String[] trimmedCar = trimCars(splitCar);

        int raceNumber = getRaceNumber();

        raceCar(trimmedCar, raceNumber);
    }
}