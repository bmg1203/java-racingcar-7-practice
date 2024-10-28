package racingcar.RacingCarTest;


import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.service.RacingCarService;
import racingcar.service.ValidateService;
import racingcar.util.*;
import racingcar.view.InstructionView;
import racingcar.view.ResultView;
import racingcar.view.RoundView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.ConditionConstant.*;
import static racingcar.util.ErrorMessage.*;
import static racingcar.util.PromptMessage.*;

public class BaseFunctionTest {


    @Test
    void 지시사항_출력_체크_테스트() {

        //given
        InstructionView view = new InstructionView();
        String expectedMessage = PROMPT_CAR_NAMES;

        //when
        String message = PROMPT_CAR_NAMES;

        //then
        assertThat(view.printInstruction(message)).isEqualTo(expectedMessage);
    }

    @Test
    void 입력_받기_기능_테스트() {
        //given
        String input = "pobi, woni, jun\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        String expectedNames = "pobi, woni, jun";
        String names = Console.readLine();

        //then
        assertThat(names).isEqualTo(expectedNames);
    }

    @Test
    void 입력_유효성_검증_테스트() {
        // given
        String names = "pobi, woni, jun";
        String raceCount = "4";
        ValidateService service = new ValidateService();
        List<String> expectValidateNames = List.of("pobi", "woni", "jun");
        long expectValidateRaceCount = 4;

        // when
        List<String> validateName = service.validateName(names);
        long validateRaceCount = service.validateRaceCount(raceCount);

        // then
        assertThat(validateName).isEqualTo(expectValidateNames);
        assertThat(validateRaceCount).isEqualTo(expectValidateRaceCount);
    }

    @Test
    void 이름_길이_에러_테스트() {
        //given
        // 🥲 : 유니코드로 길이가 2로 인식
        String longerThanFiveName = "🥲🥲🥲";
        ValidateService service = new ValidateService();

        //when

        //then
        assertThatThrownBy(() -> service.validateName(longerThanFiveName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_CAR_NAME_LENGTH);
    }

    @Test
    void 이름_공백_에러_테스트() {
        //given
        String hasBlankName = ", fobi";
        ValidateService service = new ValidateService();

        //when

        //then
        assertThatThrownBy(() -> service.validateName(hasBlankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_BLANK_INPUT);
    }

    @Test
    void 경주차_이름_지정_테스트() {
        //given
        RacingCarService racingCarService = new RacingCarService();
        List<String> expectedNames = Arrays.asList("fobi", "woni", "^jun");
        RandomGenerator randomGenerator = new RandomsWrapper();

        //when
        RacingCars racingCars = racingCarService.setupRaceCars(Arrays.asList("fobi", "woni", "^jun"), randomGenerator);

        //then
        IntStream.range(0, racingCars.size()).forEach(i -> {
            assertThat(racingCars.getRacingCars().get(i).getName()).isEqualTo(expectedNames.get(i));
        });
    }

    @Test
    void 경주차_움직임_전진_테스트() {
        //given
        RandomGenerator moveCondition = new MockRandomGenerator(MOVE_CONDITION);
        List<String> racingCarNames = Arrays.asList("fobi", "woni", "^jun");
        RacingCars racingCars = new RacingCars(racingCarNames.stream()
                .map((String name) -> new RacingCar(name, moveCondition))
                .toList());
        long expectMoveCount = 1;

        //when
        racingCars.runRound();

        //then
        IntStream.range(0, racingCars.size()).forEach(i -> {
            assertThat(racingCars.getRacingCars().get(i).getMoveCount()).isEqualTo(expectMoveCount);
        });
    }

    @Test
    void 경주차_움직임_멈춤_테스트() {
        //given
        RandomGenerator stopCondition = new MockRandomGenerator(STOP_CONDITION);
        List<String> racingCarNames = Arrays.asList("fobi", "woni", "^jun");
        RacingCars racingCars = new RacingCars(racingCarNames.stream()
                .map((String name) -> new RacingCar(name, stopCondition))
                .toList());

        long expectMoveCount = 0;

        //when
        racingCars.runRound();

        //then
        IntStream.range(0, racingCars.size()).forEach(i -> {
            assertThat(racingCars.getRacingCars().get(i).getMoveCount()).isEqualTo(expectMoveCount);
        });
    }

    @Test
    void 경주_진행_결과_테스트() {

        //given
        // fobi만 움직이지 못함
        List<String> racingCarNames = Arrays.asList("fobi", "woni", "jun");
        List<Integer> moveCondition = Arrays.asList(1, 5, 5);
        RacingCars racingCars = new RacingCars(IntStream.range(0, moveCondition.size())
                .mapToObj(i -> new RacingCar(racingCarNames.get(i), new MockRandomGenerator(moveCondition.get(i)))) // RacingCar 객체를 생성
                .collect(Collectors.toList()));

        RoundView roundView = new RoundView();

        String expectedOutput = "\n실행 결과\n" +
                "fobi : \n" +
                "woni : -\n" +
                "jun : -\n\n" +
                "fobi : \n" +
                "woni : --\n" +
                "jun : --\n\n" +
                "fobi : \n" +
                "woni : ---\n" +
                "jun : ---\n\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        roundView.startRaceRound();

        // when
        IntStream.range(0, 3).forEach(i -> {
            IntStream.range(0, racingCars.size()).forEach(j -> {
                racingCars.getRacingCars().get(j).move();
            });
            roundView.showRoundResults(racingCars);
        });

        // then
        String actualOutput = outputStream.toString();
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    void 경주_우승자_결과_테스트() {
        //given
        List<String> racingCarNames = Arrays.asList("fobi", "woni", "jun");
        ResultView resultView = new ResultView();
        RacingCars racingCars = new RacingCars(racingCarNames.stream()
                        .map((String name) -> new RacingCar(name, new MockRandomGenerator(MOVE_CONDITION)))
                        .toList());

        String expectResult = "최종 우승자 : fobi\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        // fobi만 움직임
        racingCars.getRacingCars().getFirst().move();
        long maxMoveCount = racingCars.findMaxMoveCount();
        RacingCars bestDriver = racingCars.findBestDriver(maxMoveCount);
        resultView.printResult(bestDriver);

        // then
        String actualOutput = outputStream.toString();
        assertThat(actualOutput).isEqualTo(expectResult);
    }


}
