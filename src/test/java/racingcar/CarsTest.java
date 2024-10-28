package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.strategy.MovementStrategy;
import racingcar.strategy.RandomMovementStrategy;

class CarsTest {

    Cars cars;
    MovementStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new RandomMovementStrategy();
    }

    @Test
    @DisplayName("자동차 생성")
    void addCarsTest() {
        //given
        Set<String> input = Set.of("pobi", "ddot");
        //when
        cars = new Cars(strategy);
        cars.addCars(input);
        //then
        assertEquals(input, cars.keySet());
    }

    @Test
    @DisplayName("가장 앞선 승자의 위치는?")
    void findWinScore() {
        //given
        Set<String> input = Set.of("pobi", "ddot", "a");
        cars = new Cars(strategy);
        cars.addCars(input);
        //when
        cars.putAll(Map.of("pobi", 1, "ddot", 2, "a", 6));

        //then
        assertEquals(6, cars.findWinScore());
    }


    @Test
    @DisplayName("승자가 한 명일 떄")
    void getWinnerNamesTest() {
        //given
        Set<String> input = Set.of("pobi", "ddot", "a");
        cars = new Cars(strategy);
        cars.addCars(input);
        //when
        cars.putAll(Map.of("pobi", 1, "ddot", 2, "a", 6));
        //then
        assertEquals("a", cars.getWinnerNames(cars.findWinScore()));
    }


    @Test
    @DisplayName("승자가 두명 이상 일 떄")
    void getWinnerNamesMoreThanOneTest() {
        //given
        Set<String> input = Set.of("pobi", "ddot", "a");
        cars = new Cars(strategy);
        cars.addCars(input);
        //when
        cars.putAll(Map.of("pobi", 7, "ddot", 7, "a", 7));
        //then
        assertEquals(String.join(", ", cars.keySet()),
                cars.getWinnerNames(cars.findWinScore()));
    }


    @Test
    @DisplayName("한 회차 전진 기능 테스트 NsTest 적용")
    void goTest() {
        //given
        Set<String> input = Set.of("pobi", "ddot");
        cars = new Cars(strategy);
        cars.addCars(input);
        //when
        //then
        assertRandomNumberInRangeTest(
                () ->
                {
                    cars.go();
                    assertEquals(cars.get("pobi"), 1);
                    assertEquals(cars.get("ddot"), 0);
                },
                4, 3
        );

    }

}