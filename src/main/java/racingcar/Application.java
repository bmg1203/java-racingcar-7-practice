package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    public static class View {
        // 사용자로 부터 자동차 이름들을 입력 받음
        private String inputCarName() {
            return Console.readLine();
        }
        // 사용자로 부터 자동차 이동 횟수를 입력 받음
        private String inputCarRoundCount() {
            return Console.readLine();
        }

        // 경주할 자동차 입력에 대한 출력
        private void printOutputCarName(String input) {
            System.out.println(input);
        }
        // 시도할 이동 횟수 입력에 대한 출력
        private void printOutputCarRoundCount(String inputCount) {
            System.out.println(inputCount);
        }

        // 자동차들의 이동 상황(차수별 실행 결과)에 대한 출력
        // 우승자 출력(단독 우승자)
        // 우승자 출력(공동 우승자)
    }

    public static class Validator {
        private static final String VALID_NAME_PATTERN = "^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$";
        private static final int NAME_MAX_LENGTH = 5;
        private static final String POSITIVE_INTEGER_PATTERN = "^[0-9]+$";


        private static final String VALIDATE_NAME_PATTERN_MSG = "자동차 이름 입력 형식은 , 단위로 작성해주십시오";
        private static final String MAX_NAME_SIZE_MSG = "이름은 최대 5자까지 가능합니다.";
        private static final String VALIDATE_POSITIVE_INTEGER_MSG = "이동 횟수는 0 이상의 정수만 가능합니다.";

        private void validateAll(String inputCarNames, String inputCarRoundCount) {
            validateNameForm(inputCarNames);
            validateNameCount(inputCarNames);
            validateInputCarRoundCount(inputCarRoundCount);
        }


        // 자동차 이름 입력 형식을 검증 (쉼표로 구분), 아니면 throw
        private void validateNameForm(String input) {
            if (!input.matches(VALID_NAME_PATTERN)) {
                throw new IllegalArgumentException(VALIDATE_NAME_PATTERN_MSG);
            }
        }
        // 자동차 이름이 5자 이내인지 검증
        private void validateNameCount(String input) {
            String[] names = input.split(",");
            for (String name : names) {
                if (name.length() > NAME_MAX_LENGTH) {
                    throw new IllegalArgumentException(MAX_NAME_SIZE_MSG);
                }
            }
        }

        // 이동 횟수 입력을 검증 (양의 정수만 가능.. 음수, 음의 소수, 숫자가 아니거나, 너무 큰 수)
        private void validateInputCarRoundCount(String inputCarRoundCount) {
            if (!inputCarRoundCount.matches(POSITIVE_INTEGER_PATTERN)) {
                throw new IllegalArgumentException(VALIDATE_POSITIVE_INTEGER_MSG);
            }
        }

    }

    public static class Car {
        private String name;
        private int position;

        public void attemptMoveForward() {
            //일단은 구현체로 전진 구현
            if (isMovable()) {
                position++;
            }
        }

        private static boolean isMovable() {
            return Randoms.pickNumberInRange(0, 9) >= 4;
        }
    }

    public static class business {
        // 전진하는 로직 구현(랜덤으로 0~9까지 숫자 뽑아서 4 이상이면 60%의 확률로 전진)
        // 우승자를 정함
    }
}
