package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String carName;
    int space = 0;
    Car(String carName){
        this.carName=carName;
    }
    public void randomRacing(){
        int a = Randoms.pickNumberInRange(0,9);
        if(a>=4){
            this.space +=1;
        }
    }
}
