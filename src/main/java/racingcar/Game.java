package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> participants = new ArrayList<>();
    private int gameRepeat;

    public Game(List<String> carNamesList, int gameRepeat) {
        registerParticipants(carNamesList);
        this.gameRepeat = gameRepeat;
    }

    private void registerParticipants(List<String> carNamesList) {
        carNamesList.forEach(carName -> participants.add(new Car(carName, 0)));
    }

    public void moveCar() {
        for (Car participant : participants) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                participant.move();
            }
        }
    }

    public void printProgress() {
        String DISTANCE_INDICATOR = "-";
        String NAME_DISTANCE_SPLIT = " : ";
        StringBuilder printMessage = new StringBuilder();

        for (Car participant : participants) {
            printMessage.setLength(0);

            String participantName = participant.getName();
            int participantDistance = participant.getDistance();

            printMessage.append(participantName);
            printMessage.append(NAME_DISTANCE_SPLIT);
            printMessage.append(DISTANCE_INDICATOR.repeat(participantDistance));
            printMessage.append("\n");

            System.out.println(printMessage);
        }
    }
}
