package vehicle;

import policy.RacingPolicy;

public class Car implements Vehicle{
    private final String carName;
    private final RacingPolicy racingPolicy;
    private Long moveForwardCount;

    public Car(String carName, RacingPolicy racingPolicy, Long moveForwardCount) {
        this.carName = carName;
        this.racingPolicy = racingPolicy;
        this.moveForwardCount = moveForwardCount;
    }
    public Car(String carName, RacingPolicy racingPolicy) {
        this.racingPolicy = racingPolicy;
        this.carName = validateNameLength(carName);
        this.moveForwardCount = 0L;
    }

    @Override
    public RacingPolicy getRacingPolicy() {
        return this.racingPolicy;
    }

    @Override
    public String getVehicleName() {
        return this.carName;
    }

    @Override
    public Long getMoveForwardCount() {
        return this.moveForwardCount;
    }

    @Override
    public void move() {
        moveForwardCount+=1L;
    }

    public String validateNameLength(String carName){
        if(carName.length() > racingPolicy.getNameLengthPolicy()){
            //TODO : exceptionMessage Enum 만들어서 관리 하기.
           throw  new IllegalArgumentException("자동차 이름은 "+ racingPolicy.getNameLengthPolicy()+"를 넘을 수 없습니다.");
        }
        return carName;
    }



}
