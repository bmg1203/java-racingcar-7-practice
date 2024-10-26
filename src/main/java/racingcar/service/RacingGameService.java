package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.RacingCar;

public class RacingGameService {
    private static final Integer NAME_LENGTH_LIMIT = 5;

    public List<RacingCar> initializeRacingGame(String carNames, Integer tryCount){
        if (!validateCarNames(carNames) || !validateTryCount(tryCount)){
            return null;
        }

        String[] parseCarName = processCarName(carNames);

        List<RacingCar> racingCars = new ArrayList<>();

        for (String carName : parseCarName){
            racingCars.add(new RacingCar(carName));
        }

        return racingCars;
    }

    public Integer convertTryCountToInt(String tryCount){
        if (tryCount.matches(".*[a-zA-Z]+.*")) {
            throw new IllegalArgumentException("숫자 이외의 문자는 입력할 수 없습니다.");
        }
        return Integer.parseInt(tryCount);
    }

    public List<RacingCar> getWinners(List<RacingCar> racingCars) {
        List<RacingCar> winners = new ArrayList<>();

        // 가장 높은 위치를 찾기
        int maxPosition = 0;
        for (RacingCar car : racingCars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        // 가장 높은 위치에 있는 자동차들 찾기
        for (RacingCar car : racingCars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    private String[] processCarName(String carNames) {
        String[] parseCarName = carNames.split(",");
        // 이름에서 공백 제거
        for (int i = 0; i < parseCarName.length; i++) {
            if (parseCarName[i].isBlank() || parseCarName[i].isEmpty()){
                throw new IllegalArgumentException(i + "번 사용자의 자동차 이름이 입력 되지 않았습니다.");
            }

            parseCarName[i] = parseCarName[i].trim();
        }
        return parseCarName;
    }


    private boolean validateTryCount(Integer tryCount){
        if (tryCount <= 0){
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return true;
    }

    private boolean validateCarNames(String carNames){
        if (carNames == null || carNames.isEmpty()){
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }

        String[] splitCarNames = processCarName(carNames);

        if (splitCarNames.length < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상 입력해야 합니다.");
        }

        for (String carName : splitCarNames){
            if (carName.length() > NAME_LENGTH_LIMIT){
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력 하셔야 합니다.");
            }
        }

        Set<String> carNameSet = new HashSet<>(Arrays.asList(splitCarNames));

        // 배열의 길이와 Set의 크기를 비교하여 중복된 이름이 있는지 확인
        if (splitCarNames.length != carNameSet.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복된 이름이 있습니다.");
        }

        return true;
    }



}
