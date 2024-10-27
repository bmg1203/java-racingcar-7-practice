/*
 * RacingCars
 *
 * ver1
 *
 * 2024-10-24
 *
 * 저작권 주의
 */
package racingcar.domain;

import racingcar.dto.CarDTO;
import racingcar.service.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private static final int CAR_LIST_MAX_SIZE = 10;

    private final RandomNumber randomNumber;
    private final List<Car> carList;

    public RacingCars(String readLine) {//todo 이름 중복
        List<Car> tmpList = new ArrayList<>();
        List<String> usedList = new ArrayList<>();
        String[] nameArray = readLine.split(",");
        for (String name : nameArray) {
            Car car = new Car(name);
            usedList.add(name);
            tmpList.add(car);
        }
        validationDuplicateName(nameArray, usedList);
        validationListSize(tmpList);
        this.carList = tmpList;
        randomNumber = new RandomNumber();
    }

    private void validationDuplicateName(String[] nameArray, List<String> usedList) {
        for (String name : nameArray) {
            usedList.remove(name);
            nameCheck(usedList, name);
        }
    }

    private void nameCheck(List<String> usedList, String name) {
        if (usedList.contains(name)) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름은 허용 하지 않습니다.");
        }
    }

    private void validationListSize(List<Car> tmpList) {
        if (tmpList.size() > CAR_LIST_MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차의 수는 " + CAR_LIST_MAX_SIZE + "이하만 가능합니다.");
        }
    }

    public void move() {
        for (Car car : carList) {
            if (randomNumber.isAdvance()) {
                car.advance();
            }
        }
    }

    public String getStates() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : carList) {
            CarDTO carDTO = car.getCarDTO();
            stringBuilder.append(carDTO.getState());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getWinners() {
        List<String> winnerList = getWinnerList();
        return String.join(", ", winnerList);
    }

    private List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : carList) {
            CarDTO carDTO = car.getCarDTO();
            if (carDTO.getPosition() == maxPosition) {
                winnerList.add(carDTO.getCarName());
            }
        }
        return winnerList;
    }

    private int getMaxPosition() {
        int max = -1;
        for (Car car : carList) {
            CarDTO carDTO = car.getCarDTO();
            int position = carDTO.getPosition();
            if (position > max) {
                max = position;
            }
        }
        return max;
    }
}
