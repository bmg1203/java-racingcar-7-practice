package service;

import common.BeanFactory;
import common.RacingCarBeanFactory;
import dto.ValidatedInputDataDTO;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.Repository;

class RacingCarServiceTest {

    @DisplayName("자동차 객체를 생성하여 repository에 저장한다.")
    @Test
    void generateCar() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,lala", 3L);
        RacingService racingService = beanFactory.provideRacingService(validatedInputDataDTO);

        //when
        String result = racingService.racingStart();
        Repository repository = racingService.getRaceStatusRepository();

        //then
        Assertions.assertThat(repository.size()).isEqualTo(3);
    }

    @DisplayName("이름에는 중복값이 올 수 없다.")
    @Test
    void isDuplicateName() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,dada", 3L);
        RacingService racingService = beanFactory.provideRacingService(validatedInputDataDTO);

        //when
        Repository repository = racingService.getRaceStatusRepository();

        //then
        Assertions.assertThatThrownBy(racingService::racingStart).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 이름은 사용할 수 없습니다.");
    }


    @DisplayName("레이스 진행사항을 출력한다.")
    @Test
    void runRace() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,dodo", 10L);
        RacingService racingService = beanFactory.provideRacingService(validatedInputDataDTO);
        racingService.generateRacer(validatedInputDataDTO.name().split(","));
        //when

        String strings = racingService.runRace(validatedInputDataDTO.name().split(","));
        System.out.println(strings);

        //then

    }


    @DisplayName("레이스 우승자를 찾는다.")
    @Test
    void findRaceWinner() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,dodo", 10L);
        RacingService racingService = beanFactory.provideRacingService(validatedInputDataDTO);
        List<String> status = new ArrayList<>();
        racingService.generateRacer(validatedInputDataDTO.name().split(","));
        //when

        String raceStatus = racingService.runRace(validatedInputDataDTO.name().split(","));
        String winner = racingService.fineRaceWinner();
        System.out.println(raceStatus + "\n"+winner);

        //then

    }

}