package racingcar.validation;

import java.util.HashSet;
import java.util.List;

public class CarNameValidation {
    public void isNotDuplicate(List<String> carNameList){
        HashSet<String> carNameSet = new HashSet<>(carNameList);
        if(carNameList.size() != carNameSet.size()){
            throw new IllegalArgumentException("중복된 이름이 존재하지 않아야 합니다.");
        }
    }
    public void isNotOnlyOne(List<String> carNameList){
        if(carNameList.size() == 1){
            throw new IllegalArgumentException("자동차가 2대 이상이어야 경주할 수 있습니다.");
        }
    }
}
