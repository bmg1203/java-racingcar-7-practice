package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceService {
    private RaceView raceView = new RaceView();
    private List<CarVO> cars;
    private int round;

    public RaceService(List<CarVO> userInputCars, int userInputRound){
        cars=userInputCars;
        round=userInputRound;
    }

    public void raceing(int i){
        for (CarVO car : cars) {
            car.runing();
        }
        raceView.raceState(cars,i);
    }

    public void roundStart(){
        for (int i=0;i<round;i++){
            raceing(i);
        }
    }

    public List<CarVO> carsState() {
        return cars;
    }

    public int getMaxPosition(){
        int position=0;
        for (CarVO car : cars) {
            if(car.getPosition()>position){
                position=car.getPosition();
            }
        }
        return position;
    }


    public List<String> winnerCars() {
        List<String> winners = new ArrayList<>();
        for (CarVO car : cars) {
            if (car.getPosition() == getMaxPosition()) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }


}
