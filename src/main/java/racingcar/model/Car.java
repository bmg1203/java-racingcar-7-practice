package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

  private final String name;
  private int position;

  public Car(String name) {
    validateName(name);

    this.name = name;
    this.position = 0;
  }

  public String getName() {
    return name;
  }

  private void validateName(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
    }
    if (name.isEmpty()) {
      throw new IllegalArgumentException("자동차 이름에는 빈 스페이스가 포함될 수 없습니다.");
    }
  }

  public int getPosition() {
    return position;
  }

  public void move() {
    if (canMove()) {
      position++;
    }
  }

  private boolean canMove() {
    return Randoms.pickNumberInRange(0, 9) >= 4;
  }
}
