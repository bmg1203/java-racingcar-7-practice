package racingcar.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;
import racingcar.domain.Round;
import racingcar.repository.GameRepository;
import racingcar.repository.RoundRepository;
import racingcar.util.DependencyFactory;

public class GameRepositoryTest {

    private GameRepository gameRepository = GameRepository.getInstance();
    private RoundRepository roundRepository = RoundRepository.getInstance();

    @BeforeAll
    public static void beforeAll() {
        DependencyFactory.initialize();
    }

    @Test
    @DisplayName("Game, Round 저장 및 참조관계 테스트")
    public void testGameRoundSaveAndReferToRound() {

        // given
        Game exGame = new Game.Builder().build();
        Integer gameId = gameRepository.saveAndReturnId(exGame);

        Round exRound1 = new Round.Builder().build();
        Round exRound2 = new Round.Builder().build();

        //when
        exRound1.addGameId(gameId);
        exRound2.addGameId(gameId);

        roundRepository.save(exRound1);
        roundRepository.save(exRound2);

        //then
        Game game = gameRepository.findByGameId(gameId);

        for (Round round : game.getRoundList()) {
            assertEquals(round.getGameId(), gameId);
        }
    }
}
