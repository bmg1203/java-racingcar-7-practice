package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceControl {
    private List<String> nameList;
    private int trialCount;
    List<Car> carList = new ArrayList<>();

    /**
     * 경주할 자동차 이름을 등록합니다.
     */
    String enroll() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        return input;
    }

    /**
     * 경주할 자동차 이름을 검증합니다.
     *
     * @param input 경주할 자동차 이름 목록 문자열
     */
    void verifyName(String input) {
        // 입력의 끝에 쉼표가 있는지 확인하여 예외 처리
        if (input.trim().endsWith(",")) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다: 이름이 비어있습니다.");
        }

        // 각 이름의 길이를 확인하여 5자를 초과하는 경우 예외 처리
        String[] names = input.split(",");
        for (String name : names) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다: " + name.trim());
            }
        }

        this.nameList = Arrays.stream(input.split(","))
                .map(String::trim) // 각 문자열 요소의 양 끝 공백 제거
                .collect(Collectors.toList());
    }


    /**
     * 경주할 자동차 명단을 확정합니다.
     */
    void confirmRoster() {
        for (String name : this.nameList) {
            Car car = new Car(name);

            this.carList.add(car);  // 생성된 Car 객체를 리스트에 추가
        }
    }

    /**
     * 경주할 횟수를 정합니다.
     */
    void decideRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        this.trialCount = Integer.parseInt(Console.readLine());

        this.verifyRound();
    }

    /**
     * 경주할 횟수를 검증합니다.
     */
    private void verifyRound() {
        if (this.trialCount <= 0) {
            throw new IllegalArgumentException("경주할 횟수는 최소 1번 이상이어야 합니다.");
        }
    }

    /**
     * 경기를 진행합니다.
     */
    void race() {
        for (int i = 0; i < this.trialCount; i++) {
            for(Car car : this.carList) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    car.move();
                }
            }

            this.record(i);
        }
    }

    /**
     * 경기의 결과를 표시합니다.
     *
     * @param round 경기회차
     */
    void record(int round) {

        System.out.println();

        if (round == 0) {
            System.out.println("실행결과");
        }

        for(Car car : this.carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()) );
        }

    }

    /**
     * 우승자를 출력합니다.
     */
    public void selectWinner() {
        int maxValue = Integer.MIN_VALUE;
        ArrayList<Car> winners = new ArrayList<>();

        for(Car car : this.carList) {
            if (car.getLocation() >= maxValue) {
                maxValue = car.getLocation();
            }
        }

        for(Car car : this.carList) {
            if (car.getLocation() == maxValue) {
                winners.add(car);
            }
        }

        System.out.println();
        System.out.print("최종 우승자 : ");

        List<String> winnerNames = new ArrayList<>();

        for (Car car : winners) {
            winnerNames.add(car.getName()); // 각 우승자의 이름을 리스트에 추가
        }

        System.out.print(String.join(", ", winnerNames));
    }

}
