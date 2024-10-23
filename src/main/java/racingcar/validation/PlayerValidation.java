package racingcar.validation;

public class PlayerValidation {
    
    private final static int MAX_NAME_LENGTH = 5;
    private final static int MIN_PLAYERS = 2;
    
    public static void validation(String players) {
        if (hasNotRest(players)) {
            throw new IllegalArgumentException("player는 ,(쉼표)로 구분됩니다.");
        }
        String[] playerArray = players.split(",");
        if (playerArray.length < MIN_PLAYERS) {
            throw new IllegalArgumentException("player는 2명 이상이여야 합니다.");
        }
        for (String player : playerArray) {
            playerValidate(player);
        }
    }

    private static boolean hasNotRest(String players) {
        return !players.contains(",");
    }

    private static void playerValidate(String player) {
        if (player.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("player의 이름은 최대 5글자입니다.");
        }
        if (isNotString(player)) {
            throw new IllegalArgumentException("잘못된 player 입니다.");
        }
    }

    private static boolean isNotString(String player) {
        boolean flag = false;
        String[] playerToCharter = player.split("");
        for (String charter : playerToCharter) {
            if (charter.matches("[^a-zA-Z가-힣]*")) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
