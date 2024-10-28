package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameListValidator {
    public static void validate(List<String> carNameList) {
        Set<String> uniqueCarNameSet = new HashSet<>(carNameList);

        if (uniqueCarNameSet.size() < carNameList.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
