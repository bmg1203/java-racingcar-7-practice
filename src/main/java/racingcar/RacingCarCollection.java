package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class RacingCarCollection {
    private LinkedHashMap<String, Integer> carList;
    private Integer tryCount;
    private final int MAX_LENGTH = 5;


    public RacingCarCollection(String carString, String readTryCount) {
        carList = new LinkedHashMap<>();
        String[] cars = carString.split(",");
        validate(cars);
        arrToMap(cars);
        tryCount = Integer.parseInt(readTryCount);
    }

    private void arrToMap(String[] cars) {
        for (String s : cars){
            carList.put(s, 0);
        }
    }


    private void validate(String[] cars) {
        validateCarNmaeBlank(cars);
        validateCarNameLength(cars);
        validateDuplicateName(cars);
        validateNotAllowedCharacter(cars);
    }

    private void validateCarNmaeBlank(String[] cars) {
        for (String car : cars){
            if (car.matches(" "))throw  new IllegalArgumentException("[ERROR] : 자동차 이름에 공백은 포함하지 않습니다.");
        }
    }

    private void validateNotAllowedCharacter(String[] cars) {
        for (String car : cars) {
            if (!car.matches("[a-zA-Z]+")) throw new IllegalArgumentException("[ERROR] : 허용되지 않은 문자가 포함되어있습니다.");
        }
    }

    private void validateDuplicateName(String[] cars) {
        int carsLength = cars.length;
        HashSet<String> duplicateNameSet = new HashSet<>();
        for (String car : cars) {
            duplicateNameSet.add(car);
        }
        if (carsLength != duplicateNameSet.size()) throw new IllegalArgumentException("[ERROR] : 자동차의 이름이 중복되어서는 안됩니다.");
    }

    private void validateCarNameLength(String[] cars) {
        for (String car : cars) {
            if (car.length() > MAX_LENGTH || car.isEmpty()) throw new IllegalArgumentException("[ERROR] : 자동차 이름은 5자 이하이거나 비어서는 안됩니다.");
        }
    }

    public LinkedHashMap<String, Integer> getCarList() {
        return carList;
    }

    public Integer getTryCount() {
        return tryCount;
    }
}
