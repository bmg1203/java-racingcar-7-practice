package io;

import car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarOutputHandler {

    public void displayRaceResultsByRound(List<Car> carList) {
        System.out.println();
        System.out.println("실행 결과");
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + moveCount(car.getPosition()));
        }
    }

    private String moveCount(int position) {
        StringBuilder stringPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringPosition.append("-");
        }
        return stringPosition.toString();
    }

    public void displayFinalResult(List<Car> carList) {
        int maxPosition = findMaxPosition(carList);
        List<String> winnerList = carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName).toList();

        System.out.println();
        String stringWinnerList = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + stringWinnerList);
    }

    private static int findMaxPosition(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max().orElseThrow(IllegalArgumentException::new);
    }
}
