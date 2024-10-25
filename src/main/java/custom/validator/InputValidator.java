package custom.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class InputValidator {
    public void checkEmptyInput(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("입력은 null 일 수 없습니다");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력은 빈 문자열 일 수 없습니다");
        }
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력은 공백으로만 구성될 수 없습니다");
        }
    }

    public void checkNumberOfCars(List<String> input) {
        if (input.size() < 2) {
            throw new IllegalArgumentException("자동차가 2대 미만 입력되었습니다");
        }
    }

    public void validateCarNamesForLength(List<String> input) {
        for (String name : input) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름 중 5자를 초과하는 이름이 있습니다");
            }
        }
    }

    public void validateCarNamesForDuplicateNames(List<String> input) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (String name : input) {
            if (!uniqueCarNames.add(name)) { // add()가 false 를 반환하면 중복이 있음
                throw new IllegalArgumentException("자동차 이름 중 중복된 이름이 있습니다");
            }
        }
    }

    public void validateCarNamesForSpaces(List<String> input) {
        for (String name : input) {
            if (name.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름 중 공백이 포함된 이름이 있습니다");
            }
        }
    }

    public void validateCarNamesForInvalidCharacters(List<String> input) {
        for (String carName : input) {
            if (!carName.matches("[a-zA-Z가-힣]+")) {
                throw new IllegalArgumentException("차량 이름은 알파벳이나 한글로 작성되어야 합니다.");
            }
        }
    }

    public void validateCarNames(List<String> input) {
        validateCarNamesForLength(input);
        validateCarNamesForDuplicateNames(input);
        validateCarNamesForSpaces(input);
        validateCarNamesForInvalidCharacters(input);
    }
}