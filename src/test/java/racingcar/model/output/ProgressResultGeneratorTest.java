package racingcar.model.output;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.model.car.Car;

class ProgressResultGeneratorTest {

	private final String carMovementSymbol = "-";
	private final String separator = " : ";
	private final int minRequiredValueForMovement = 4;

	@Test
	@DisplayName("하나의 자동차가 게임에 참여한 경우 중간 결과를 생성할 수 있다.")
	void 하나의_자동차의_중간_결과를_생성한다() {
		// given
		String carName = "name";
		List<Car> car = List.of(new Car(carName));
		car.getFirst().move(minRequiredValueForMovement);
		String expectedResult = carName + separator + carMovementSymbol;

		// when
		String progressResult = ProgressResultGenerator.generateProgressResult(car);

		// then
		assertEquals(expectedResult, progressResult);
	}

	@Test
	@DisplayName("다수의 자동차가 게임에 참여한 경우 중간 결과를 생성할 수 있다.")
	void 다수의_자동차의_중간_결과를_생성한다() {
		// given
		String carName1 = "name1";
		String carName2 = "name2";
		List<Car> cars = List.of(new Car(carName1), new Car(carName2));
		cars.getFirst().move(minRequiredValueForMovement);
		cars.getLast().move(minRequiredValueForMovement);
		String lineSeparator = "\n";
		String expectedResult = carName1 + separator + carMovementSymbol + lineSeparator
				+ carName2 + separator + carMovementSymbol;

		// when
		String progressResult = ProgressResultGenerator.generateProgressResult(cars);

		// then
		assertEquals(expectedResult, progressResult);
	}

	@Test
	@DisplayName("자동차가 전진하지 않은 경우 중간 결과를 생성할 수 있다.")
	void 전진하지_않은_자동차의_중간_결과를_생성한다() {
		// given
		String carName = "name";
		List<Car> car = List.of(new Car(carName));
		String expectedResult = carName + separator;

		// when
		String progressResult = ProgressResultGenerator.generateProgressResult(car);

		// then
		assertEquals(expectedResult, progressResult);
	}

	@ParameterizedTest
	@DisplayName("자동차가 여러 번 전진한 경우 중간 결과를 생성할 수 있다.")
	@CsvSource(value = {"1, -", "2, --", "3, ---"})
	void 전진한_자동차의_중간_결과를_생성한다(int number, String movement) {
		// given
		String carName = "name";
		List<Car> car = List.of(new Car(carName));
		IntStream.range(0, number)
			.forEach(n -> car.getFirst().move(minRequiredValueForMovement));
		String expectedResult = carName + separator + movement;

		// when
		String progressResult = ProgressResultGenerator.generateProgressResult(car);

		// then
		assertEquals(expectedResult, progressResult);
	}
}