package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {
    private final String inputCarName;
    private final String inputCount;
    private final Validation validation = new Validation();
    private final List<Player> players = new ArrayList<>();
    private List<String> records = new ArrayList<>();
    private String result;

    public CarRacing(String inputCarName, String inputCount) {
        this.inputCarName = inputCarName;
        this.inputCount = inputCount;
    }

    void startRacing() {
        getPlayers();
        recordRacer();
    }

    void getRacingResult() {
        for (String lab : records) {
            System.out.println(lab);
        }
        System.out.println(this.result);
    }

    private void recordRacer() {
        if (!validation.isRightCount(inputCount)) throw new IllegalArgumentException("잘못된 횟수를 입력했습니다.");

        try {
            int count = Integer.parseInt(inputCount);

            while (count != 0) {
                checkMoveForwardOrStop();
                setRecordLap();
                count--;
            }

            resultRace();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 횟수를 입력했습니다.");
        }
    }

    private void resultRace() {
        int max = players.stream().mapToInt(i -> i.count).max().orElse(0);
        String result = players.stream().filter(i -> i.count == max).map(i -> i.name).collect(Collectors.joining(", "));
        this.result = "최종 우승자 : " + result;
    }

    private void setRecordLap() {
        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            sb.append(player.name).append(" : ").append("-".repeat(player.count)).append("\n");
        }
        records.add(sb.toString());
    }

    private void checkMoveForwardOrStop() {
        for (Player player : players) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                player.count++;
            }
        }
    }

    private void getPlayers() {
        if (!validation.isRightInputName(inputCarName)) throw new IllegalArgumentException("자동차 입력이 잘못되었습니다.");
        for (String name : inputCarName.split(",")) {
            players.add(new Player(name, 0));
        }
    }

    List<String> getRecords() {
        return this.records;
    }

    String getResult() {
        return this.result;
    }
}
