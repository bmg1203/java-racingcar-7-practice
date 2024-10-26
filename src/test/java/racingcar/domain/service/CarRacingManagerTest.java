package racingcar.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRacingManagerTest {
    @Test
    @DisplayName("자동차를 움직일 수 있다.")
    void 자동차_움직이기() {
        // given
        final CarRacingManager carRacingManager = CarRacingManager.from("1,2,3");

        // when
        carRacingManager.moveForward("1");

        // then
        assertThat(carRacingManager.getDistance("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자를 출력할 수 있다.")
    void 우승자_출력() {
        // given
        final CarRacingManager carRacingManager = CarRacingManager.from("1,2,3");

        // when
        carRacingManager.moveForward("1");

        // then
        assertThat(carRacingManager.getWinners()).isEqualTo("1");
    }

    @Test
    @DisplayName("우승자가 여러 명일 수 있다.")
    void 우승자_여러명() {
        // given
        final CarRacingManager carRacingManager = CarRacingManager.from("우승자1, 우승자2, loser");
        carRacingManager.moveForward("우승자1");
        carRacingManager.moveForward("우승자2");

        // when
        final String winners = carRacingManager.getWinners();

        // then
        assertThat(winners).contains("우승자1", "우승자2");
    }
}