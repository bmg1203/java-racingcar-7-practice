package racingcar;
import camp.nextstep.edu.missionutils.*;

import java.util.Arrays;


public class Racingcar {
    private String[] carNames;
    private int count;
    private String[] moveResults;

    public void start(){
        input();
        racingDisplay();
        winnerDisplay();
    }

    public void input(){
        System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawCarName = Console.readLine();
        inputExCarName(rawCarName);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String count = Console.readLine();
        inputExCount(count);


    }

    public boolean invCarNameLen(){
        for (String carName : carNames)
            if(carName.length() >= 6) return true;
        return false;
    }

    public boolean hasBlankCarName(){
        for (String carName : carNames)
            if(carName.contains(" ")) return true;
        return false;
    }

    public void inputExCarName(String rawCarName){
        if(rawCarName.isEmpty()) throw new IllegalArgumentException("자동차 입력이 없습니다.");
        if(rawCarName.endsWith(",")) throw new IllegalArgumentException("자동차 입력시 ','로 끝날 수는 없습니다.");
        carNames = rawCarName.split(",");
        if(carNames.length == 0) throw new IllegalArgumentException("쉼표만 입력될 수는 없습니다.");
        if(carNames.length == 1) throw new IllegalArgumentException("자동차 1대로 경주를 진행 할 수 없습니다.");
        if(invCarNameLen()) throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        if(hasBlankCarName()) throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수는 없습니다.");
    }

    public void inputExCount(String count){
        if(count.isEmpty()) throw new IllegalArgumentException("시도 횟수 입력이 없습니다.");
        if(!count.matches("\\d+")) throw new IllegalArgumentException("공백이 포함될 수 없고 하나 이상의 정수만 입력할 수 있습니다.");
        this.count = Integer.parseInt(count);
        if(this.count == 0) throw new IllegalArgumentException("시도 횟수가 0이 될 수는 없습니다.");
    }

    public void initMoveResults(){
        moveResults = new String[carNames.length];
        Arrays.fill(moveResults, "");
    }


    public boolean move(){
        return 4 <= Randoms.pickNumberInRange(0, 9);
    }

    public void racingDisplay(){
        initMoveResults();
        for(int i = 0; i < count; i++){
            for(int j = 0; j < carNames.length; j++){
                if(move()){
                    moveResults[j] +="-";
                }
                System.out.println(carNames[j] + " : "+ moveResults[j]);
            }
            System.out.println();
        }
    }

    public int findMaxDistance(){
        int maxDistance = 0;
        for (String result : moveResults) {
            if (result.length() > maxDistance) {
                maxDistance = result.length();
            }
        }
        return maxDistance;
    }

    public void winnerDisplay(){
        int maxDistance = findMaxDistance();
        StringBuilder winners = new StringBuilder();


        for (int i = 0; i < moveResults.length; i++) {
            if (moveResults[i].length() == maxDistance) {
                if (!winners.isEmpty()) {
                    winners.append(", ");
                }
                winners.append(carNames[i]);
            }
        }

        System.out.println("최종 우승자 : " + winners);
    }


}
