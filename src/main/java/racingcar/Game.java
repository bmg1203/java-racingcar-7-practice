package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {


    public void startGame() {
        List<Car> cars;
        int totalMoves;
        String input;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = readLine();
        cars = parseCars(input);

        System.out.println("시도할 횟수는 몇 회인가요?");
        input = readLine();
        totalMoves = parseMoveCount(input);

        System.out.println("\n실행 결과");
        for(int i = 0 ; i < totalMoves ; i++){
            for(Car car : cars){
                car.move();
            }
            printCarsPosition(cars);
        }
        printWinners(cars);
    }

    List<Car> parseCars(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException("비어있는 문자열입니다.");
        }

        List<Car> cars = new ArrayList<>();
        List<String> carsNames = Arrays.asList(input.split(","));
        for(String carName : carsNames){
            if(carName.length()>5){
                throw new IllegalArgumentException("이름이 5글자 이상입니다.");
            }
            cars.add(new Car(carName));
        }
        return cars;
    }

    int parseMoveCount(String input){
        int totalMoves = 0;
        try{
            totalMoves = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력이 정수가 아닙니다.");
        }
        if(totalMoves < 0){
            throw new IllegalArgumentException("시도횟수가 음수입니다.");
        }
        return totalMoves;
    }

    void printCarsPosition(List<Car> cars){
        String mark = "-";
        for(Car car : cars){
            System.out.println(car.getName()+" : "+mark.repeat(car.getPosition()));
        }
        System.out.println();
    }

}
