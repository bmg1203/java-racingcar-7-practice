package racingcar.view;

import racingcar.dto.CarStatusDto;

import java.util.List;

public class OutputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자";
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String NAME_DELIMITER = ", ";

    public static void printInputCarNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public static void printInputRoundMessage() {
        System.out.println(INPUT_ROUND_MESSAGE);
    }

    public static void printRoundResult(List<CarStatusDto> roundResult) {
        for (CarStatusDto carStatusDto : roundResult) {
            System.out.println(carStatusDto.toString());
        }
        System.out.println();
    }

    public static void printWinnerNames(List<String> names) {
        System.out.println(FINAL_WINNER_MESSAGE + NAME_POSITION_SEPARATOR + String.join(NAME_DELIMITER, names));
    }
}
