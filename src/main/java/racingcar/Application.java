package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        playerNameSplit(inputName);

    }

    public static void playerNameSplit(String inputName) {
        StringTokenizer tokenizer = new StringTokenizer(inputName, ",");
        Map<String, Integer> player = new HashMap<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            player.put(token, 0);
        }
    }
    public static int randomNum(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum;
    }
    public static int goAndStopNum(){
        if(randomNum() > 3) {
            return 1;
        } else return 0;
    }

    public static void racingByCount(int inputTryCount){
    }

}
