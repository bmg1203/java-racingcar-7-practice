package racingcar.model;

import racingcar.dto.CarDto;

public class Car {
    private static final int MOVE_CRITERIA_VALUE = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String POSITION_MARK = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name.strip());
        this.name = name.strip();
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름을 1자에서 " + MAX_NAME_LENGTH + "자 이하로 입력하지 않았습니다.: " + name);
        }
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_CRITERIA_VALUE) {
            position++;
        }
    }

    //현재 상태를 표시(ex. pobi : ---)
    public String displayState() {
        return name + " : " + POSITION_MARK.repeat(position);
    }

    public CarDto toCarDtO() {
        return new CarDto(name, position);
    }
}
