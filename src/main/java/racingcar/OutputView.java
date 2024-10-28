package racingcar;

public class OutputView {
    public void printRaceStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRaceProcess(Cars cars) {
        for (Car car : cars.getCars()) {
            printStatus(car);
        }
        System.out.println();
    }

    public void printWinners(Cars cars) {
        String winners = String.join(", ", cars.getWinners());
        System.out.printf("최종 우승자 : %s\n", String.join(", ", cars.getWinners()));
    }

    private void printStatus(Car car) {
        String carName = car.getCarName();
        String distance = "-".repeat(car.getDistance());

        System.out.printf("%s : %s\n", carName, distance);
    }
}