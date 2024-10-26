package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.utils.StringReplacer;
import racingcar.utils.StringSplitter;
import racingcar.validate.RacingcarAttemptValidate;
import racingcar.validate.RacingcarNameValidate;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final StringReplacer stringReplacer;
    private final StringSplitter stringSplitter;
    private final RacingService racingService;
    private final RacingcarNameValidate racingcarNameValidate;
    private final RacingcarAttemptValidate racingcarAttemptValidate;

    public RacingController(InputView inputView, OutputView outputView, StringSplitter stringSplitter,StringReplacer stringReplacer, RacingService racingService, RacingcarNameValidate racingcarNameValidate,  RacingcarAttemptValidate racingcarAttemptValidate) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringReplacer = stringReplacer;
        this.stringSplitter = stringSplitter;
        this.racingService = racingService;
        this.racingcarNameValidate = racingcarNameValidate;
        this.racingcarAttemptValidate = racingcarAttemptValidate;
    }

    public void run() {

        /* 자동차 이름 입력 */

        outputView.askCarName();//상수 데이터 출력

        String carNames = inputView.askCarName();//자동차 이름 입력

        racingcarNameValidate.isBlank(carNames);//Null 및 공백 입력 검증

        carNames = stringReplacer.removeSpaces(carNames);//문자열 내부 공백 제거

        List<String> carList = stringSplitter.split(carNames);//구분자 기준으로 문자열 리스트 반환

        racingcarNameValidate.isMoreThanFiveLetters(carList);//5글자 초과 검증

        racingcarNameValidate.isDuplicate(carList);//중복 입력 검증

        racingService.saveCarName(carList);//검증을 마친 자동차 이름 리스트 저장

        /* 시도 횟수 입력 */

        outputView.askAttempt();//상수 데이터 출력

        String attempt = inputView.askAttempt();//시도 횟수 입력

        racingcarAttemptValidate.isBlank(attempt);//공백 입력 검증

        racingcarAttemptValidate.isParsable(attempt);//정수로 변환 가능 여부 검증, 자료형 범위 내

    }
}
