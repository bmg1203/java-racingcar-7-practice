package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;

import java.util.ArrayList;

public class CarService {
    private int Generate_RandomValue(){
        return Randoms.pickNumberInRange(0,9);
    }
    private boolean is_Move(int value){
        if(value>=4) return true;
        return false;
    }



}
