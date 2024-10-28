package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private Car car;

    @BeforeEach
    void 초기_세팅() {
        car = Car.from("우테코");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤_숫자가_0에서_3까지_일때_이동_상황_테스트(int number) {
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getPosition()).isEqualTo(0);
                    assertThat(car.getMoveStatus()).isEqualTo("");
                },
                number
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 랜덤_숫자가_4이상_일때_이동_상황_테스트(int number) {
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getPosition()).isEqualTo(1);
                    assertThat(car.getMoveStatus()).isEqualTo("-");
                },
                number
        );
    }
}
