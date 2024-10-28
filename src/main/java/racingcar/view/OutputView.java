package racingcar.view;

import java.util.Iterator;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.dto.CarDto;

public class OutputView {
    private static final String FINAL_WINNER_CONSTANT = "최종 우승자 : ";

    public static void showProcessView(List<Car> cars) {

        Iterator<Car> iterator = cars.iterator();

        while (iterator.hasNext()) {
            Car car = iterator.next();
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();

    }


    public void showResult(List<CarDto> winners) {

        StringBuilder winnersStringBuilder = new StringBuilder();
        Iterator<CarDto> carIterator = winners.iterator();
        while (carIterator.hasNext()) {
            CarDto winner = carIterator.next();
            winnersStringBuilder.append(winner.getName());
            if (carIterator.hasNext()) {
                winnersStringBuilder.append(",");
                winnersStringBuilder.append(" ");
            }
        }

        System.out.println(FINAL_WINNER_CONSTANT + winnersStringBuilder);
    }
}
