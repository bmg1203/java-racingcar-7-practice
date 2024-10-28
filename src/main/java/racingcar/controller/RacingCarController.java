package racingcar.controller;

import racingcar.exception.ErrorCode;
import racingcar.model.Cars;
import racingcar.service.MovingCarService;
import racingcar.service.MovingCarServiceImpl;
import racingcar.service.SeperateCarNameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final SeperateCarNameService seperateCarNameService;
    private final MovingCarService movingCarService;

    private final OutputView outputView;
    private final InputView inputView;


    public RacingCarController(final SeperateCarNameService seperateCarNameService,
                               final MovingCarService movingCarService){

        this.seperateCarNameService = seperateCarNameService;
        this.movingCarService = movingCarService;
        this.outputView = new OutputView();
        this.inputView = new InputView();

    }

    public void run(){


        String carNamesWithDelimeter = inputView.getRacingCarNamesWithDelimeter();

        Cars cars = seperateCarNameService.seperateCarNameFromCarNamesWithDelimeter(carNamesWithDelimeter);

        int countOfTry = inputView.getCountOfTry();
        checkValidateTryCount(countOfTry);

        outputView.printResult();
        playRacingGame(cars,countOfTry);

    }

    private void checkValidateTryCount(int countOfTry) {

        if(countOfTry<=0){
            throw new IllegalArgumentException(ErrorCode.CANT_TRY_COUNT_UNDER_ZERO.getMessage());
        }

    }

    // 차를 움직이고 , 결괏값을 추출
    private void playRacingGame(final Cars cars, int countOfTry){

        for(int i=0;i<countOfTry;i++){

            movingCarService.moveCars(cars);
            cars.getCars().forEach(car -> outputView.printCarsMove(car.getName(),car.getMoveCount()));
            System.out.println();

        }

        outputView.rankResult(cars.getTopRankCarName());

    }



}
