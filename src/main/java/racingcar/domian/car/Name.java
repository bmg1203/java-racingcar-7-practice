package racingcar.domian.car;

public class Name {

    private String name;

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
        if (!name.matches("^[a-zA-Z0-9]*$")) {
            throw new IllegalArgumentException("올바른 이름 형식이 아닙니다.");
        }
    }

    private void validateNameIsEmpty() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈칸 일 수 없습니다.");
        }
    }

    private void validateNameLength() {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Error: 이름은 5글자 이하입니다");
        }


    }


}
