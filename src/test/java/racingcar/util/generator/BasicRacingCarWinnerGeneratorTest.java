package racingcar.util.generator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

public class BasicRacingCarWinnerGeneratorTest {
    private final BasicRacingCarWinnerGenerator basicRacingCarWinnerGenerator;

    public BasicRacingCarWinnerGeneratorTest() {
        this.basicRacingCarWinnerGenerator = new BasicRacingCarWinnerGenerator();
    }

    @Test
    public void 우승자_한명_테스트() {
        assertSimpleTest(() -> {
            // given
            List<RacingCar> cars = List.of(new RacingCar("창의"));

            // when
            List<RacingCar> winners = basicRacingCarWinnerGenerator.generateWinner(cars);

            // then
            assertThat(winners)
                    .usingRecursiveComparison()
                    .isEqualTo(cars);
        });
    }

    @Test
    public void 우승자_다수_테스트(){
        assertSimpleTest(() -> {
            // given
            List<RacingCar> cars = List.of(new RacingCar("창의"), new RacingCar("상현"));

            // when
            List<RacingCar> winners = basicRacingCarWinnerGenerator.generateWinner(cars);

            // then
            assertThat(winners)
                    .usingRecursiveComparison()
                    .isEqualTo(cars);
        });
    }
}
