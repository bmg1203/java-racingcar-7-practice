package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final String SPLITTER = ",";

    public static void main(String[] args) {
        String input = readInput();
        List<RacingCar> cars = splitInput(input);
        String trialStr = readInput();
        Integer trial = parseTrial(trialStr);

        for (int i = 0; i < trial; i++) {
            assignRandomNumber(cars);
            checkRandomNumber(cars);
            printCarInfo(cars);
            System.out.println("");
        }

        int winPosition = getWinPosition(cars);
        List<String> winners = getWinners(cars, winPosition);
        printWinners(winners);
    }

    public static String readInput() {
        return Console.readLine();
    }

    public static List<RacingCar> splitInput(String input) {
        String[] racingCars = input.split(SPLITTER);
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String carName : racingCars) {
            checkCarName(carName);
            RacingCar racingCar = new RacingCar(carName);
            racingCarList.add(racingCar);
        }

        for (int i = 0; i < racingCars.length; i++) {
            for (int j = i + 1; j < racingCars.length; j++) {
                checkSameName(racingCars[i], racingCars[j]);
            }
        }
        return racingCarList;
    }

    public static void checkCarName(String carName) {
        if (carName.isEmpty() || carName == null || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkSameName(String car1, String car2) {
        if (car1.equals(car2)) {
            throw new IllegalArgumentException("동일한 이름을 가진 차종을 입력하실 수 없습니다.");
        }
    }

    public static Integer parseTrial(String trialStr) {
        try {
            Integer trial = Integer.parseInt(trialStr);
            return trial;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static Integer getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void assignRandomNumber(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            racingCar.randomNumbers.add(getRandomNumber());
        }
    }

    public static void checkRandomNumber(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            int pos = 0;
            for (int i = 0; i < racingCar.randomNumbers.size(); i++) {
                if (racingCar.randomNumbers.get(i) >= 4) pos++;
            }
            racingCar.position = pos;
        }
    }

    public static void printCarInfo(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            String carInfo = "";
            carInfo += racingCar.name;
            carInfo += " : ";
            for (int i = 0; i < racingCar.position; i++) {
                carInfo += "-";
            }
            System.out.println(carInfo);
        }
    }

    public static Integer getWinPosition(List<RacingCar> racingCarList) {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCarList) {
            if (racingCar.position > maxPosition) maxPosition = racingCar.position;
        }
        return maxPosition;
    }

    public static List<String> getWinners(List<RacingCar> racingCarList, int maxPosition) {
        List<String> winnerList = new ArrayList<>();
        for (RacingCar racingCar : racingCarList) {
            if (racingCar.position == maxPosition) {
                winnerList.add(racingCar.name);
            }
        }
        return winnerList;
    }

    public static void printWinners(List<String> winnerList) {
        String notice = "최종 우승자 : ";
        for (int i = 0; i < winnerList.size(); i++) {
            notice += winnerList.get(i);
            notice += SPLITTER;
            notice += " ";
        }
        notice = notice.substring(0, notice.length() - 2);
        System.out.println(notice);
    }
}