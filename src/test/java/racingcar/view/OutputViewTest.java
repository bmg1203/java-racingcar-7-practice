package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RoundSnapshotDto;
import racingcar.dto.WinnersDto;
import racingcar.model.car.CarSnapshot;

public class OutputViewTest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("실행 결과 출력 시 의도한 형식대로 출력된다.")
    void shouldDisplayResultInExpectedFormat() {
        // given
        RoundSnapshotDto carStatusesOfFirstRound = new RoundSnapshotDto(List.of(
                new CarSnapshot("pobi", 3, 1),
                new CarSnapshot("juni", 2, 1)
        ));

        RoundSnapshotDto carStatusesOfSecondRound = new RoundSnapshotDto(List.of(
                new CarSnapshot("pobi", 4, 2),
                new CarSnapshot("juni", 3, 2)
        ));

        List<RoundSnapshotDto> carMovementResults = List.of(
                carStatusesOfFirstRound, carStatusesOfSecondRound
        );

        // when
        OutputView.displayRoundSnapshots(carMovementResults);

        // then
        assertThat(outputStream.toString()).isEqualTo(
                "실행 결과\npobi : ---\njuni : --\n\npobi : ----\njuni : ---\n\n");
    }

    @Test
    @DisplayName("우승자가 한 명인 경우 의도한 형식대로 출력된다.")
    void shouldDisplaySingleWinnerInExpectedFormat() {
        // given
        List<String> nameOfSingleWinner = List.of("pobi");
        WinnersDto winnersDtoOfSingleWinner = new WinnersDto(nameOfSingleWinner);

        // when
        OutputView.displayWinners(winnersDtoOfSingleWinner);

        // then
        assertThat(outputStream.toString()).isEqualTo(
                "최종 우승자 : pobi\n");
    }

    @Test
    @DisplayName("우승자가 여러명인 경우 의도한 형식대로 출력된다.")
    void shouldDisplayWinnersInExpectedFormat() {
        // given
        List<String> nameOfWinners = List.of("pobi", "jun");
        WinnersDto winnersDto = new WinnersDto(nameOfWinners);

        // when
        OutputView.displayWinners(winnersDto);

        // then
        assertThat(outputStream.toString()).isEqualTo(
                "최종 우승자 : pobi, jun\n");
    }
}
