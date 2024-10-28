package racingcar.validator;

import java.util.List;
import java.util.stream.Stream;

// 완료
public class InputValidator {

  private static final String DELIMITER = ",";

  public List<String> checkCarNames(String carNames) {

    List<String> carNameList;

    if (carNames.endsWith(",") || carNames.startsWith(",")) {
      throw new IllegalArgumentException("구분자로 끝나는 문자열은 입력할 수 없습니다");
    }
    try {
      carNameList = Stream.of(carNames.split(DELIMITER))
              .map(String::trim)
              .toList();
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("유효하지 않은 구분자입니다.", e);
    }

    if (carNameList.size() < 2) {
      throw new IllegalArgumentException("자동차 이름은 2개 이상이어야 합니다.");
    }

    for (String carName : carNameList) {
      if (carName.trim().isBlank()) {
        throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
      }
    }
    for (String carName : carNameList) {
      if (carName.length() > 5) {
        throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
      }
    }
    for (int i = 0; i < carNameList.size(); i++) {
      for (int j = i + 1; j < carNameList.size(); j++) {
        if (carNameList.get(i).equals(carNameList.get(j))) {
          throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
      }
    }

    return carNameList;
  }

  public int isValidAtmp(String numberOfAttempts) {

    int parseAtmp;

    try {
      parseAtmp = Integer.parseInt(numberOfAttempts);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("유효한 시도 횟수가 아닙니다", e);
    }

    if (parseAtmp < 1 || parseAtmp > 99) {
      throw new IllegalArgumentException("시도 횟수는 0과 100 사이여야 합니다.");
    }
    return parseAtmp;
  }
}


