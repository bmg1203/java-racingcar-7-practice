package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.movement.MovementPolicy;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.dto.request.GameStartRequest;
import racingcar.dto.response.GameResult;
import racingcar.dto.response.Winners;
import racingcar.exception.game.GameException.GameNotInitializedException;
import racingcar.mock.AlternateNumberGenerator;
import racingcar.mock.CanMoveNumberGenerator;
import racingcar.repository.MemoryPlayerRepository;
import racingcar.util.IdGenerator;


@DisplayName("게임 서비스(GaeService) 유스케이스")
class GameServiceTest {

    private GameService createGameService() {
        PlayerService playerService = new PlayerService(
                new MemoryPlayerRepository(),
                new IdGenerator()
        );
        MovementPolicy movementPolicy = new MovementPolicy(
                new RandomMovementStrategy(new CanMoveNumberGenerator())
        );
        return new GameService(playerService, movementPolicy);
    }

    private GameService createGameServiceWithAlternateNumberGenerator() {
        PlayerService playerService = new PlayerService(
                new MemoryPlayerRepository(),
                new IdGenerator()
        );
        MovementPolicy movementPolicy = new MovementPolicy(
                new RandomMovementStrategy(new AlternateNumberGenerator())
        );
        return new GameService(playerService, movementPolicy);
    }

    private GameStartRequest createGameStartRequest() {
        return new GameStartRequest(List.of("p1", "p2", "p3"), 4);
    }


    @DisplayName("게임 초기화하기")
    @Nested
    class 게임_초기화하기 {

        @DisplayName("정상적인 게임 초기화")
        @Test
        void 정상적인_게임_초기화() {
            // given
            GameStartRequest gameStartRequest = createGameStartRequest();
            GameService gameService = createGameService();

            // expect
            Assertions.assertThatCode(() -> gameService.initialize(gameStartRequest))
                    .doesNotThrowAnyException();
        }
    }

    @DisplayName("라운드 진행하기")
    @Nested
    class 라운드_진행하기 {

        @DisplayName("정상적인 라운드 진행")
        @Test
        void 정상적인_라운드_진행() {
            // given
            GameStartRequest gameStartRequest = createGameStartRequest();
            GameService gameService = createGameService();

            gameService.initialize(gameStartRequest);

            // expect
            Assertions.assertThatCode(() -> gameService.playRound())
                    .doesNotThrowAnyException();

        }

        @DisplayName("정상적인 게임 결과 반환")
        @Test
        void 정상적인_게임_결과_반환() {
            // given
            GameStartRequest gameStartRequest = createGameStartRequest();
            GameService gameService = createGameService();

            gameService.initialize(gameStartRequest);

            // when
            GameResult gameResult = gameService.playRound();

            // then
            Assertions.assertThat(gameResult).isNotNull();

        }

        @DisplayName("게임 비초기화시 라운드 진행 시도")
        @Test
        void 게임_비초기화시_라운드_진행_시도() {
            // given
            GameService gameService = createGameService();

            // expect
            Assertions.assertThatCode(() -> gameService.playRound())
                    .isInstanceOf(GameNotInitializedException.class)
                    .hasMessage("게임이 초기화되지 않았습니다.");
        }

    }

    @DisplayName("다음 라운드 확인하기")
    @Nested
    class 다음_라운드_확인하기 {

        @DisplayName("다음 라운드 존재 확인")
        @Test
        void 다음_라운드_존재_확인() {
            // given
            GameService gameService = createGameService();
            GameStartRequest gameStartRequest = new GameStartRequest(List.of("p1", "p2", "p3"), 2);
            gameService.initialize(gameStartRequest);

            // when
            gameService.playRound();
            boolean result = gameService.hasNextRound();

            // then
            Assertions.assertThat(result).isTrue();

        }

        @DisplayName("다음 라운드 없음 확인")
        @Test
        void 다음_라운드_없음_확인() {
            // given
            GameService gameService = createGameService();
            GameStartRequest gameStartRequest = new GameStartRequest(List.of("p1", "p2", "p3"), 2);
            gameService.initialize(gameStartRequest);

            // when
            gameService.playRound();
            gameService.playRound();
            boolean result = gameService.hasNextRound();

            // then
            Assertions.assertThat(result).isFalse();

        }
    }

    @DisplayName("승자들 조회하기")
    @Nested
    class 승자들_조회하기 {

        @DisplayName("단독 승자 확인")
        @Test
        void 단독_승자_확인() {
            // given
            GameService gameService = createGameServiceWithAlternateNumberGenerator();
            GameStartRequest gameStartRequest = new GameStartRequest(List.of("p1", "p2"), 3);
            gameService.initialize(gameStartRequest);
            gameService.playRound();
            gameService.playRound();
            gameService.playRound();

            // when
            Winners winners = gameService.getWinners();
            int totalWinners = winners.names().size();

            // then
            Assertions.assertThat(totalWinners).isEqualTo(1);

        }

        @DisplayName("공동 승자 확인")
        @Test
        void 공동_승자_확인() {
            // given
            GameService gameService = createGameService();
            GameStartRequest gameStartRequest = new GameStartRequest(List.of("p1", "p2", "p3"), 4);
            gameService.initialize(gameStartRequest);
            gameService.playRound();
            gameService.playRound();
            gameService.playRound();
            gameService.playRound();

            // when
            Winners winners = gameService.getWinners();
            int totalWinners = winners.names().size();

            // then
            Assertions.assertThat(totalWinners).isEqualTo(3);
        }
    }

}