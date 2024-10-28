package racingcar.domian.car;

public class Name {

    private String name;
    private static final String NAME_REGEX = "^[a-zA-Z0-9가-힣ㄱ-ㅎ]*$";
    private static final String NAME_FORMAT_ERROR = "[Error]: 올바른 이름 형식이 아닙니다.(특수 문자는 이름에 포함 될 수 없습니다)";
    private static final String NAME_BLANK_ERROR = "[Error]: 이름은 빈칸 일 수 없습니다.";
    private static final String NAME_LENGTH_ERROR = "[Error]: 이름은 5글자 이하입니다";

    private Name(String name) {
        this.name = name;
        validateName();
    }

    public String getName() {
        return name;
    }

    public static Name createName(String name) {
        return new Name(name);
    }

    private void validateName() {
        validateNameIsEmpty();
        validateNameFormat();
        validateNameLength();
    }

    private void validateNameFormat() {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException(NAME_FORMAT_ERROR);
        }
    }

    private void validateNameIsEmpty() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR);
        }
    }

    private void validateNameLength() {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }


    }


}
