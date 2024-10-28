package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    void 움직일_수_있는_최소거리를_충족하지_못하면_자동차는_전진하지_않는다() {
        Car yh = new Car("yh");

        yh.moveForward(3);

        assertEquals(0, yh.currentLocation());
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 거리가_4이상이면_자동차는_앞으로_갈_수_있다(int distance) {
        Car yh = new Car("yh");

        yh.moveForward(distance);

        assertEquals(1, yh.currentLocation());
    }

    @Test
    void 자동차의_초기_위치는_0이다() {
        Car yh = new Car("yh");
        assertEquals(0, yh.currentLocation());
    }

    @Test
    void 자동차_이름이_5자를_초과하면_IllegalArgumentException이_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new Car("javaji"));
    }

    @Test
    void 자동차는_이름을_가질_수_있다() {
        assertDoesNotThrow(() -> new Car("pobi"));
    }

}