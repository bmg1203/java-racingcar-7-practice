package racingcar.object;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.object.carEngine.AlwaysOnDriveCarEngine;
import racingcar.object.carEngine.BrokenCarEngine;
import racingcar.racingapp.model.car.Car;
import racingcar.racingapp.model.car.Cars;
import racingcar.racingapp.model.race.Lap;
import racingcar.racingapp.model.value.vo.CarName;
import racingcar.racingapp.model.value.vo.LapRecord;
import racingcar.racingapp.model.value.vo.Mileage;

class LapTest {

    @Test
    void launchLap으로_랩을수행하고_랩의결과를받는다() {
        Lap lap = new Lap(new Cars(List.of(
                Car.ready(new AlwaysOnDriveCarEngine(), new CarName("1번씽씽이")),
                Car.ready(new BrokenCarEngine(), new CarName("2번폐차")))));

        // 두 번 달리는데, 씽씽이는 두번 모두 달리고, 폐차는 두번 모두 서있는다
        lap.launchLap();
        LapRecord firstLapRecord = lap.submitRecords();
        System.out.println(firstLapRecord);
        lap.launchLap();
        LapRecord secondLapRecord = lap.submitRecords();
        System.out.println(secondLapRecord);

        // 랩-기록의 결과는 CarName 오름차순이다
        // firstLap
        assertThat(firstLapRecord.carRecords().get(0).mileage())
                .isEqualTo(new Mileage(1));
        assertThat(firstLapRecord.carRecords().get(1).mileage())
                .isEqualTo(new Mileage(0));
        // secondLap
        assertThat(secondLapRecord.carRecords().get(0).mileage())
                .isEqualTo(new Mileage(2));
        assertThat(secondLapRecord.carRecords().get(1).mileage())
                .isEqualTo(new Mileage(0));
    }

}