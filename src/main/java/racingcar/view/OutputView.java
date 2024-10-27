package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public void requestCarNameMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void requestNumberOfRoundsMessage(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void raceStartMessage(){
        System.out.println("실행 결과");
    }
    public void displayRaceProgress(List<Car>carList){
        for(Car car : carList){
            String progress = "-".repeat(car.getDistance());
            System.out.println(car.getName() + " : " + progress);
        }
        System.out.println();
    }
}
