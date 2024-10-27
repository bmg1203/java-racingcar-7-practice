package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;

class ResultsTest {

    private Results results;
    private Car pobi;
    private Car woni;

    @BeforeEach
    void setUp() {
        results = Results.empty();
        pobi = new Car("pobi");
        woni = new Car("woni");
    }

    @DisplayName("경주 결과들은 자동차들의 입력 순서를 보장하며 모두 저장된다")
    @Test
    void 자동차들의_경주_결과들을_저장() {
        results.saveAll(List.of(pobi, woni));

        assertThat(results.getResults()).containsExactly(createResult(pobi, woni));
    }

    private Result createResult(Car... cars) {
        Result result = Result.empty();
        for (Car car : cars) {
            result.save(car.name(), car.position());
        }
        return result;
    }

    @DisplayName("조회를 위해 반환한 자동차들의 경주 결과들은 수정이 불가능하다")
    @Test
    void 자동차들의_경주_결과들_복사본은_수정_불가() {
        results.saveAll(List.of(pobi, woni));

        List<Result> copyResults = results.getResults();

        assertThatThrownBy(copyResults::removeFirst)
                .isInstanceOf(UnsupportedOperationException.class);
    }

}
