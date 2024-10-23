package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.domain.Car;

public class RaceView {

    public ArrayList<String> inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        ArrayList<String> carNames = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (!token.isEmpty() && token.length() <= 5 && validateNameToken(token)) {
                carNames.add(token);
            } else {
                throw new IllegalArgumentException("자동차 이름 형식이 올바르지 않습니다.");
            }
        }

        return carNames;
    }

    // (,) 기준으로 분리된 자동차 이름 토큰의 형식을 검증
    private boolean validateNameToken(String input) {
        // 양 쪽 공백 제거
        input = input.trim();

        // 검증 기준 : 영어, 한글만 허용, 공백 포함 특수문자 불허
        Pattern pattern = Pattern.compile("^[a-zA-Z가-힣]+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public int inputTryTime() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int N = 0;
        try {
            N = Integer.parseInt(Console.readLine().trim());
            if (N <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return N;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }

    }

    public void printRace(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.print(car.getCarName() + " : ");
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(List<Car> cars) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < cars.size() - 1; i++) {
            System.out.print(cars.get(i).getCarName() + ", ");
        }
        System.out.println(cars.getLast().getCarName());
    }


}
