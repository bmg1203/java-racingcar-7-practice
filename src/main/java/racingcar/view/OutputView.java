package racingcar.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;

/**
 * packageName    : racingcar.view
 * fileName       : outputView
 * author         : ehgur
 * date           : 2024-10-25
 * description    : 출력 처리를 담당하는 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-25        ehgur            최초 생성
 */

public class OutputView {
    //----- 싱글톤 패턴 적용 -----//
    private static final OutputView instance = new OutputView();
    private OutputView(){}
    public static OutputView getInstance() {
        return instance;
    }
    //------------------------//

    public void displayResultByLap(Race race, BufferedWriter bw) throws IOException {
        Cars cars = race.getCars();
        int len = cars.getCarCount();

        for (int i = 0; i < len; i++) {
            Car car = cars.getCar(i);
            int carMovement = car.getMoveCount();

            bw.newLine();
            bw.write(car.getName() + " : " + movementGraph(carMovement));
        }
        bw.newLine();
    }

    private String movementGraph(int movement) {
        return "-".repeat(Math.max(0, movement));
    }

    public void displayWinner(int max, Cars cars, BufferedWriter bw) throws IOException{
        List<String> winner = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (car.getMoveCount() == max) {
                winner.add(car.getName());
            }
        }
        String winners = String.join(", ", winner);
        bw.newLine();
        bw.write("최종 우승자 : " + winners);
    }
}
