package common;

import dto.ValidatedInputDataDTO;
import java.util.HashMap;
import policy.RacingCarPolicy;
import policy.RacingPolicy;
import repository.RaceStatusRepository;
import repository.Repository;
import service.RacingCarService;
import service.RacingService;

public class RacingCarBeanFactory implements BeanFactory {

    @Override
    public RacingPolicy provideRacingPolicy() {
        return new RacingCarPolicy();
    }

    @Override
    public Repository provideVehicleRepository() {
        return new RaceStatusRepository(new HashMap<String, Long>());
    }

    @Override
    public RacingService provideRacingService(ValidatedInputDataDTO validatedInputDataDTO) {
        return new RacingCarService(validatedInputDataDTO,provideRacingPolicy(),provideVehicleRepository());
    }

}
