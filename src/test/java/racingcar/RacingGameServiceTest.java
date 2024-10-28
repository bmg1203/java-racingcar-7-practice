package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.RacingGameService;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameServiceTest {

    @Test
    public void testMultipleWinners() {
        // Given
        Car car1 = new Car("Car1", "------");
        Car car2 = new Car("Car2", "-------");
        Car car3 = new Car("Car3", "-------"); // 동일한 Displacement를 가진 차

        CarRepository.getInstance().save(car1);
        CarRepository.getInstance().save(car2);
        CarRepository.getInstance().save(car3);

        RacingGameService winnerDecider = new RacingGameService();

        // When
        String winners = winnerDecider.decideWinner();

        // Then
        // 여러 우승자가 있는지 확인
        assertEquals("Car2, Car3", winners); // 예상 우승자 목록을 확인합니다.
    }

    @Test
    public void testUniWinners() {
        // Given
        RacingGameService winnerDecider = new RacingGameService();
        Car car1 = new Car("Car1", "------");
        Car car2 = new Car("Car2", "------");
        Car car3 = new Car("Car3", "--------"); // 이 차가 가장 앞선다고 가정

        CarRepository.getInstance().save(car1);
        CarRepository.getInstance().save(car2);
        CarRepository.getInstance().save(car3);

        // When
        String winners = winnerDecider.decideWinner();

        // Then
        System.out.println("Winners: " + winners); // 반환된 우승자를 출력합니다.
        assertEquals("Car3", winners); // 예상 우승자 목록을 확인합니다.
    }
    
    @Test
    public void testAcceptCarListWithExceedingMaxLength() {
        // Given
        String carNameExceedingMaxLength = "CarNameThatExceedsMaxLength";
        System.setIn(new ByteArrayInputStream(carNameExceedingMaxLength.getBytes()));

        // When
        RacingGameService racingGameService = new RacingGameService();
        Throwable exception = assertThrows(IllegalArgumentException.class, racingGameService::acceptCarList);

        // Then
        assertEquals("경주할 자동차 이름은 5자 이하만 가능합니다.", exception.getMessage());
    }

}