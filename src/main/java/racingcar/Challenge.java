package racingcar;

import java.util.ArrayList;
import java.util.Comparator;

public class Challenge {

    private ArrayList<Car> partCars;
    ArrayList<String> winners;

    public Challenge() {
        partCars = new ArrayList<>();
        winners = new ArrayList<>();
    }

    public void addCar(Car car) {
        partCars.add(car);
    }

    public void makeWinnerList()
    {
        partCars.sort(Comparator.comparingInt(Car::getDistance).reversed());
        int tmp = partCars.get(0).getDistance(); // 가장 앞에 있는(가장 큰 distance)

        for (Car car : partCars) {
            if(car.getDistance() == tmp) {
                winners.add(car.getCarName());
            }
        }
    }

    public void printStep() {
        for(Car car : partCars) {
            System.out.print(car.getCarName() + " : ");
            for(int i=0; i<car.getDistance(); i++)
                System.out.print("-");
            System.out.println();
        }
        System.out.println();
    }

    public void printWinner() {
        System.out.println(String.join(", ", winners));
    }
}
