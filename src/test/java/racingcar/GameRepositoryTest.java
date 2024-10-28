package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class GameRepositoryTest {

    GameRepository gameRepository = new GameRepository();

    @Test
    void 자동차_이름_설정_테스트() {
        // given
        String names = "tokki,pobi,nori";

        // when
        gameRepository.setCarsNames(names);
        List<String> allNames = gameRepository.getAllNames();

        // then
        assertThat(allNames).containsExactly("tokki", "pobi", "nori");
    }


}
