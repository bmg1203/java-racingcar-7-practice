package racingcar.service;

import racingcar.model.entity.Cars;
import racingcar.model.dto.RacingResult;
import racingcar.model.entity.RacingChance;

/**
 * 자동차들 객체를 RacingController로부터 전달 받아서 경주 기능을 수행
 * RacingController로부터 결과값을 요청받으면 저장소에 요청하고 값을
 * 회신하는 역할 수행
 */
public interface RacingService {
    
    void raceOfCarsAndChance(Cars cars, RacingChance racingChance);

    RacingResult getResult();
}
