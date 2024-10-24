package racingcar.Model;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameCars {
    public static final ArrayList<Car> cars=new ArrayList<>();

    public GameCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void playGame(){
        for (Car car : cars) {
            if(Randoms.pickNumberInRange(0,9)>4){
                car.ongoing();
            }
        }
    }

    public int findWinnerPositions(){
        return cars.stream()
                .max(Comparator.comparingInt(Car::getOngoingCount))
                .map(Car::getOngoingCount)
                .orElse(Integer.MIN_VALUE);
    }

    public List<Car> findWinnerCars(){
        return cars.stream()
                .filter(car->car.getOngoingCount()==findWinnerPositions())
                .toList();
    }
}