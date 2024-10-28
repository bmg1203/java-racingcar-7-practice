package racingcar.filter;

import java.util.Arrays;
import java.util.List;
import racingcar.common.exception.InvalidCarNameException;
import racingcar.common.util.CarListCollector;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.model.RacingCarList;
import racingcar.model.RacingCarProxy;

public class RacingCarListParsingFilter implements Filter<RaceRequest, RaceResponse> {
    private static final String NAME_DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    @Override
    public RaceResponse doFilter(RaceRequest request, RaceFilterChain chain) {
        RacingCarList racingCarList = createCarListFromRequest(request.command());
        RaceRequest updatedRequest = request.withCarList(racingCarList);
        return chain.doFilter(updatedRequest);
    }

    private RacingCarList createCarListFromRequest(String carNamesExpression) {
        List<String> carNames = parseCarNames(carNamesExpression);
        return carNames.stream()
                .map(RacingCarProxy::create)
                .collect(CarListCollector.toCarList());
    }

    private List<String> parseCarNames(String expression) {
        return Arrays.stream(expression.split(NAME_DELIMITER))
                .map(String::trim)
                .filter(this::isValidCarName)
                .toList();
    }

    private boolean isValidCarName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new InvalidCarNameException();
        }
        return true;
    }
}
