package racingcar.util;

import racingcar.model.RacingCar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.util.Constants.*;

/**
 * CarFactory 클래스는 경주 게임에서 사용자가 입력한 carNames 입력 값에 대한 검증 및 생성을 담당한다.
 */
public class CarFactory {

    /**
     * 입력된 문자열을 바탕으로 RacingCar 객체 리스트를 생성한다.
     *
     * @param input 콤마로 구분된 자동차 이름 문자열
     * @return 생성된 RacingCar 객체 리스트
     * @throws IllegalArgumentException 입력 값이 비어있거나, 이름이 중복 또는 5자 초과일 경우 발생
     */
    public static List<RacingCar> createCars(String input) {
        List<String> carNames = validateAndParseInput(input);

        validateUniqueNames(carNames);

        return carNames.stream()
                .map(String::trim)
                .map(CarFactory::createCar)
                .toList();
    }

    /**
     * 입력 값이 null 또는 빈 문자열인지 검증한다.
     *
     * @param input 자동차 이름 입력 문자열
     * @return 파싱하여 생성된 carName의 정보가 담긴 String 배열
     * @throws IllegalArgumentException 입력이 비어있을 경우 혹은 파싱 후 리스트가 비어있을 경우 발생
     */
    private static List<String> validateAndParseInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAMES_ERROR);
        }

        List<String> carNames = Arrays.stream(input.split(",")).toList();

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LIST_ERROR);
        }

        return carNames;
    }

    /**
     * 자동차 이름 배열에서 중복 이름이 있는지 검증한다.
     *
     * @param carNames 자동차 이름 배열
     * @throws IllegalArgumentException 중복된 이름이 있을 경우 발생
     */
    private static void validateUniqueNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String carName : carNames) {
            carName = carName.trim();
            if (!uniqueNames.add(carName)) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR + carName);
            }
        }
    }

    /**
     * 자동차 이름의 길이를 검증하고, 유효하면 RacingCar 객체를 생성한다.
     *
     * @param carName 생성할 자동차 이름
     * @return 생성된 RacingCar 객체
     * @throws IllegalArgumentException 이름이 공백(space)이거나, 이름의 길이가 0이거나, 5자 초과일 경우 발생
     */
    private static RacingCar createCar(String carName) {

        if (carName.isBlank()) {
            throw new IllegalArgumentException(BLANK_NAME_ERROR);
        }

        if (carName.length() > MAX_CAR_NAME_LENGTH || carName.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR + carName);
        }
        return new RacingCar(carName);
    }
}
