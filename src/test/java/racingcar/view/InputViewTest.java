package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

	private InputView inputView = InputView.getInstance();

	@Test
	@DisplayName("자동차 이름을 쉼표로 구분한다.")
	public void readCarNames() {
		// GIVEN
		String input = "a,b,c,d,e,f";

		// WHEN
		List<String> names = inputView.splitNames(input);

		// THEN
		assertThat(names).hasSize(6);
		assertThat(names).contains("a", "b", "c", "d", "e", "f");
	}

	@Test
	@DisplayName("구분자 내에 빈 이름이 있을 경우, IllegalArgumentException을 발생시킨다.")
	public void isEmptyName() {
		// GIVEN
		String input = "a,b,c,,e";

		// WHEN - THEN
		assertThatThrownBy(() -> {
			inputView.splitNames(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("시도 횟수가 숫자로만 입력되었는지 검증한다.")
	public void isNumberCount() {
	    // GIVEN
		String input = "ab12c";

	    // WHEN - THEN
		assertThatThrownBy(() -> inputView.parseCount(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("정확한 시도 횟수를 반환한다.")
	public void parseNumber() {
	    // GIVEN
		String input = "9999";

	    // WHEN
		Integer result = inputView.parseCount(input);

		// THEN
		assertThat(result).isEqualTo(9999);
	}

	@Test
	@DisplayName("Int 범위를 넘어가는 숫자는 예외를 발생시킨다.")
	public void isIntRange() {
	    // GIVEN
		String input = "2147483648";

	    // WHEN - THEN
		assertThatThrownBy(() -> inputView.parseCount(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("시도 횟수에 음수가 들어올 경우 예외를 발생시킨다.")
	public void minusCountTest() {
	    // GIVEN
		String input = "-10";

	    // WHEN - THEN
		assertThatThrownBy(() -> inputView.parseCount(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("시도 횟수에 0이 들어올 경우 예외를 발생시킨다.")
	public void zeroCountTest() {
	    // GIVEN
		String input = "0";

	    // WHEN - THEN
		assertThatThrownBy(() -> inputView.parseCount(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("경주 최대 횟수를 초과하면 예외를 발생시킨다.")
	public void maxCountTest() {
		// GIVEN
		String input = "10000";

		// WHEN - THEN
		assertThatThrownBy(() -> inputView.parseCount(input)).isInstanceOf(IllegalArgumentException.class);
	}
}
