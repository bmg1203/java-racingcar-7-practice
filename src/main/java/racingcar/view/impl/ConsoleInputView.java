package racingcar.view.impl;

import static racingcar.common.constant.OutputMessage.INPUT_CAR_NAMES;
import static racingcar.common.constant.OutputMessage.INPUT_ROUND;

import camp.nextstep.edu.missionutils.Console;
import racingcar.config.FilterConfig;
import racingcar.view.InputView;

public class ConsoleInputView implements InputView {
    private final FilterConfig filterConfig = new FilterConfig();

    @Override
    public String displayCarNameRequest() {
        System.out.println(INPUT_CAR_NAMES.getMessage());
        String inputCarNames = Console.readLine();
        filterConfig.getCarNameFilterChain().doFilter(inputCarNames);
        return inputCarNames;
    }

    @Override
    public String displayRoundRequest() {
        System.out.println(INPUT_ROUND.getMessage());
        String inputRound = Console.readLine();
        filterConfig.getRoundFilterChain().doFilter(inputRound);
        return inputRound;
    }
}
