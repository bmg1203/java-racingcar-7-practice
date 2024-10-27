package racingcar.view;

import racingcar.domain.Winners;

import static racingcar.message.InfoMessage.WINNER_NOTIFICATION_MESSAGE;

public class WinnersView {

    public void show(Winners winners) {
        String result = winners.getWinnersList();
        System.out.print(WINNER_NOTIFICATION_MESSAGE.getMessage() + result);
    }
}
