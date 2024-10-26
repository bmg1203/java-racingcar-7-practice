package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printResult(Map<String,String> cars){
        for(String key:cars.keySet()){
            System.out.println(key + " : " + cars.get(key));
        }
    }

    public void printWinner(List<String> winner){
        if(winner.size()==1){
            System.out.println("최종 우승자 : " + winner);
            return;
        }
        StringBuilder sb = new StringBuilder();
        String firstWinner = winner.get(0);
        sb.append(firstWinner);
        winner.remove(firstWinner);
        for(String name : winner){
            sb.append(", ");
            sb.append(name);
        }
        System.out.println("최종 우승자 : " + sb);
    }
}
