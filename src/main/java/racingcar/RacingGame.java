package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import camp.nextstep.edu.missionutils.Randoms;


public class RacingGame{

    private final CarNameParser carNameParser;
    private final AttemptCountParser attemptCountParser;
    private final RandomGenerator randomGenerator;

    // 경주에 참가한 자동차 리스트
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(CarNameParser carNameParser, AttemptCountParser attemptCountParser, RandomGenerator randomGenerator){
        this.carNameParser = carNameParser;
        this.attemptCountParser = attemptCountParser;
        this.randomGenerator = randomGenerator;
    }


    /**
     * 우승자 출력 기능
     */
    public void outputWinners(List<String> winnerNames){
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }

    /**
     * 우승자 확인 기능
     * */
    public List<String> getWinners(){
        String winnerName;
        int maxMoveCount = getMaxMoveCount();

        return cars.stream()
                .filter(car ->car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .toList();
    }

    /**
     * cars 중 moveCount 최대값 찾는 메서드
     * */
    public int getMaxMoveCount(){
        int maxMoveCount = 0;
        for(Car car : cars){
            if(car.getMoveCount() > maxMoveCount){
                maxMoveCount = car.getMoveCount();
            }
        }
        return maxMoveCount;
    }


    /**
     * 실행결과 출력 기능
     * */
    public void outputRaceResult(Car car){
        System.out.println(car.getName() + " : "+ "-".repeat(car.getMoveCount()));
    }

    /**
     * 자동차 객체들을 생성하고 자동차 리스트에 추가하는 객체
     * */
    public void addCars(List<String> validatedCarNames){
        for(String carName : validatedCarNames){
            cars.add(new Car(carName));
        }
    }

    /**
     * 경주에 참가한 자동차들(RacingGame의 cars) 전진 메서드
     *  - 랜덤 값이 4이상일때만
     *    매 전진 시 실행 결과 출력
     */
    public void moveCars(){
        for(Car car : cars){
            car.move(randomGenerator.getRandomNumber());
            outputRaceResult(car);
        }
        System.out.println();
    }

    /**
     * 사용자가 입력한 시도횟수만큼 전진을 반복하는 메서드
     * */
    public void raceByAttemptCount(int attemptCount){
        System.out.println("실행 결과");
        for(int i = 0; i<attemptCount; i++){
            moveCars();
        }
    }


    /**
     * 사용자가 시도할 횟수를 입력받는 메서드
     **/
    public int getAttemptCount(){
        return attemptCountParser.getAttemptCount();
    }

    /**
     * 입력받은 자동차 이름 리스트를 반환하는 메서드
     * */
    public List<String> getValidatedCarNames(){
        String input = carNameParser.inputCarNames();
        String[] splitCarName = carNameParser.splitCarNamesByComma(input);

        return carNameParser.getValidatedCarNames(splitCarName);
    }

    public List<Car> getCars() {
        return cars;
    }
}
