package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.dto.CarMoveCountDto;
import racingcar.dto.CarMoveHistoryDto;
import racingcar.exception.RaceException;
import racingcar.utility.NumberUtility;

public class Race {

    private final Cars cars;
    private final String INVALID_MOVE_COUNT_MESSAGE = "유효하지 않은 시도 횟수입니다";
    private final int moveCount;
    private final StringBuilder raceHistoryStringBuilder = new StringBuilder();

    public Race(String moveCount, Cars cars) {
        if(!isValidMoveCount(moveCount)){
            throw new RaceException(INVALID_MOVE_COUNT_MESSAGE);
        }
        this.moveCount = NumberUtility.getNumber(moveCount);
        this.cars = cars;
    }

    private boolean isValidMoveCount(String moveCount) {
        if(!NumberUtility.isNumberStr(moveCount)){
            return false;
        }

        if(!NumberUtility.isPositiveNumber(NumberUtility.getNumber(moveCount))){
            return false;
        }
        return true;
    }

    public void doRace(){
        for (int i = 0; i < moveCount; i++) {
            cars.moveCars();
            addHistory();
        }
    }

    private void addHistory() {
        List<CarMoveHistoryDto> carMoveHistoryDtoList = cars.getCarMoveHistoryDtoList();
        for(CarMoveHistoryDto carMoveHistoryDto : carMoveHistoryDtoList){
            raceHistoryStringBuilder.append(carMoveHistoryDto.toString())
                    .append(System.lineSeparator());
        }
    }

    public String getRaceHistory(){
        return raceHistoryStringBuilder.toString();
    }

    public List<String> getRaceWinners() {
        List<CarMoveCountDto> carMoveCountDtoList = cars.getCarMoveCountDtoList();
        int maxCount = CarMoveCountDto.getMaxMoveCount(carMoveCountDtoList);
        List<String> winnerList = getCollectNameByMoveCount(carMoveCountDtoList, maxCount);
        return winnerList;
    }

    private static List<String> getCollectNameByMoveCount(List<CarMoveCountDto> carMoveCountDtoList, int maxCount) {
        if(maxCount == 0) {
            return Collections.emptyList();
        }
        List<String> winnerList = carMoveCountDtoList
                .stream()
                .filter(carMoveCountDto -> carMoveCountDto.moveCount() == maxCount)
                .map(carMoveCountDto -> carMoveCountDto.name())
                .toList();
        return winnerList;
    }
}
