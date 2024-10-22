package racingcar;

public class CommaCarNameTokenizer {
    private static final String COMMA = ",";

    public String[] split(String input) {
        String[] carNames = input.split(COMMA);

        for(String carName: carNames){
            if(carName.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            if(carName.isBlank()){
                throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
            }
        }

        return carNames;
    }
}
