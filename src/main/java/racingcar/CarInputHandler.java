package racingcar;


import camp.nextstep.edu.missionutils.Console;

public class CarInputHandler {
    public String userInputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    public String[] splitCarNames(String carNames){
        String[] separatedNames  = carNames.split(",");
        return separatedNames;
    }
}
