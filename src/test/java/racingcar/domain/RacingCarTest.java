package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    @DisplayName("이름을 갖는 자동차를 생성할 수 있다.")
    public void createRacingCarWithName() {
        String name = "이름";
        RacingCar racingCar = new RacingCar(name);

        String racingCarName = racingCar.getName();

        assertThat(racingCarName).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차는 5자를 초과하는 이름을 가질 수 없다.")
    public void racingCarCannotHaveNameOver5Length() {
        String name = "여섯자리이름";

        assertThatThrownBy(() -> new RacingCar(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름은 NULL 이거나 Empty일 수 없다.")
    public void racingCarCannotHaveEmptyName(String name) {
        assertThatThrownBy(() -> new RacingCar(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차는 4 이상의 숫자를 받으면 1 이동한다.")
    public void moveWhenGiveNumberOver4() {
        RacingCar racingCar = new RacingCar("자동차");

        racingCar.move(4);

        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 4 미만의 숫자를 받으면 움직이지 않는다.")
    public void stopWhenGiveNumberLessThan4() {
        RacingCar racingCar = new RacingCar("자동차");

        racingCar.move(3);

        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

}
