package racingcar.domain;

import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars (List<RacingCar> racingCars){
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars(){
        return racingCars;
    }
}