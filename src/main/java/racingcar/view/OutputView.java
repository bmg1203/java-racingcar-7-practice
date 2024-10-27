package racingcar.view;

import java.util.Iterator;
import java.util.List;
import racingcar.domian.car.Car;

public class OutputView {

    public static void showProcessView(List<Car> cars) {

        Iterator<Car> iterator = cars.iterator();

        while (iterator.hasNext()) {
            Car car = iterator.next();
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();

    }


    public void showResult(List<Car> winners) {

        StringBuilder winnersStringBuilder = new StringBuilder();
        Iterator<Car> carIterator = winners.iterator();
        while (carIterator.hasNext()) {
            Car winner = carIterator.next();
            winnersStringBuilder.append(winner.getCarName());
            if (carIterator.hasNext()) {
                winnersStringBuilder.append(",");
                winnersStringBuilder.append(" ");
            }
        }

        System.out.println("최종 우승자 : " + winnersStringBuilder);
    }
}
