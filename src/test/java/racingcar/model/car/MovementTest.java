package racingcar.model.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovementTest {

	@Test
	@DisplayName("랜덤으로 생성한 수의 크기가 4 미만이라면 자동차는 전진하지 않는다.")
	void 수의_값이_4_미만이라면_이동하지_않는다() {
		// given
		String carName = "name";
		Car car = new Car(carName);
		int expectedMovement = car.getMovement();
		int randomNumber = 3;

		// when
		car.move(randomNumber);

		// then
		assertEquals(expectedMovement, car.getMovement());
	}

	@Test
	@DisplayName("랜덤으로 생성한 수의 크기가 4 이상이라면 자동차는 전진한다.")
	void 수의_값이_4_이상이라면_이동한다() {
		// given
		String carName = "name";
		Car car = new Car(carName);
		int movementValue = 1;
		int expectedMovement = car.getMovement() + movementValue;
		int randomNumber = 4;

		// when
		car.move(randomNumber);

		// then
		assertEquals(expectedMovement, car.getMovement());
	}
}