package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static Map<String, String> cars = new LinkedHashMap<>();
    public static List<String> winners = new ArrayList<>();
    public static int N;
    public static void main(String[] args) {
        try {
            input();
            output();
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void input(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = Console.readLine().split(",");
        for(String car: input){
            cars.put(car, "");
        }

        if(cars.isEmpty() || !isValid()) throw new IllegalArgumentException();

        System.out.println("시도할 횟수는 몇 회인가요?");
        N = Integer.parseInt(Console.readLine());
    }

    public static boolean isValid(){
        for (String car : cars.keySet()) {
            if (car.length() > 5) return false;
        }

        return true;
    }

    public static void race() {
        for(Map.Entry<String,String> car: cars.entrySet()){
            int num = Randoms.pickNumberInRange(0, 9);
            if(num >= 4) {
                cars.put(car.getKey(), car.getValue() + "-");
            }

            System.out.println(car.getKey() + " : " + car.getValue());
        }
        System.out.println();
    }

    public static void winner() {
        int max_size = 0;
        for(Map.Entry<String, String> car: cars.entrySet()){
            if(max_size < car.getValue().length()){
                max_size = car.getValue().length();
            }
        }

        for(Map.Entry<String, String> car: cars.entrySet()){
            if(max_size == car.getValue().length()){
                winners.add(car.getKey());
            }
        }
    }

    public static void output() {
        System.out.println("실행 결과");
        for(int i = 0; i < N; i++) {
            race();
        }

        winner();

        System.out.print("최종 우승자 : ");
        for(int i = 0; i < winners.size(); i++){
            String str = ", ";
            if (i == winners.size()-1) str = "";
            System.out.print(winners.get(i) + str);
        }
    }
}
