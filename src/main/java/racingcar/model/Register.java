package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Register {
    // 경주 할 자동차들 리스트 등록 기능
    // 자동차들의 전진 횟수 조회 기능
    // 우승자 조회 기능

    public ArrayList<Car> carList;

    public Register() {
        this.carList = new ArrayList<>();
    }

    public void carListUp(ArrayList<String> participateCars) {
        for (String name : participateCars) {
            carList.add(new Car(name));
        }
    }

    public LinkedHashMap<String, Integer> carsMoveCount() {
        LinkedHashMap<String, Integer> moves = new LinkedHashMap<>();
        for (Car c : carList) {
            moves.put(c.name, c.distance);
        }
        return moves;
    }

    public ArrayList<String> racingWinner() {
        LinkedHashMap<String, Integer> carMoves = carsMoveCount();
        int maxMove = Collections.max(carMoves.values());

        ArrayList<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> m : carMoves.entrySet()) {
            if (m.getValue() == maxMove) {
                winners.add(m.getKey());
            }
        }
        return winners;
    }
}
