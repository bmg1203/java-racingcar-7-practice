package racingcar;

public class CarNameValidator {
    public void separateByComma(String carNames){
        if (!isCommaSeparated(carNames)) {
            throw new IllegalArgumentException("쉼표(,)로 구분하여 자동차 이름들을 입력해주세요");
        }
    }

    private boolean isCommaSeparated(String carNames){
        return carNames.matches("^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$");
    }

}
