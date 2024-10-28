package racingcar.View;

import racingcar.Dto.CarData;
import racingcar.Dto.RoundResult;

import java.util.List;

public class OutputView {
    private static final String moveText = "-";
    private static final String delimiter = ", ";
    public void printRoundResults(List<RoundResult> roundResults){
        System.out.println("출력");
        roundResults.forEach(this::printEachRoundResult);
    }
    public void printEachRoundResult(RoundResult roundResult){
        for(CarData carData : roundResult.getCarData()){
            String carName = carData.getCarName();
            int distance = carData.getDistance();
            String movement = moveText.repeat(distance);
            System.out.printf("%s : %s\n",carName,movement);
        }
        System.out.println();
    }
    public void printWinners(List<String> winners){
        String winnerNames= String.join(delimiter, winners);
        System.out.printf("%s가 최종 우승했습니다.",winnerNames);
    }
}
