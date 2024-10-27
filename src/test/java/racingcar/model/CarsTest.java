package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 최대_전진_횟수를_구한다() {
        // given
        String[] carNames = {"pobi", "woni"};
        Cars cars = Cars.from(carNames);

        cars.getCars()
            .get(0)
            .addAdvanceMarker(); // pobi: 1회 전진
        cars.getCars()
            .get(1)
            .addAdvanceMarker(); // woni: 1회 전진
        cars.getCars()
            .get(1)
            .addAdvanceMarker(); // woni: 2회 전진

        // when
        int maxAdvanceMarkerCount = cars.getMaxAdvanceMarkerCount();

        // then
        assertThat(maxAdvanceMarkerCount).isEqualTo(2);
    }

    @Test
    void 가장_많이_전진한_우승자를_찾는다() {
        // given
        String[] carNames = {"pobi", "woni", "jun"};
        Cars cars = Cars.from(carNames);

        Car pobi = cars.getCars()
                       .get(0);
        Car woni = cars.getCars()
                       .get(1);
        Car jun = cars.getCars()
                      .get(2);

        pobi.addAdvanceMarker();  // pobi: 1회 전진
        woni.addAdvanceMarker();  // woni: 1회 전진
        woni.addAdvanceMarker();  // woni: 2회 전진
        jun.addAdvanceMarker();   // jun: 1회 전진
        jun.addAdvanceMarker();   // jun: 2회 전진

        int maxAdvanceMarkerCount = cars.getMaxAdvanceMarkerCount();

        // when
        List<Car> winners = cars.findWinners(maxAdvanceMarkerCount);

        // then
        assertThat(winners).hasSize(2)
                           .containsExactly(woni, jun);
    }

    @Test
    void 중복된_자동차_이름이_있으면_예외가_발생한다() {
        // given
        String[] carNames = {"pobi", "woni", "woni"};

        // when, then
        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_2개_미만이면_예외가_발생한다() {
        // given
        String[] carNames = {"pobi"};

        // when, then
        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
