package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            String[] name = inputName();
            for(String str: name){
                if(str.length() > 5){
                    throw new IllegalArgumentException();
                }
            }
            int num = inputNum();

            String[] move = new String[name.length];

            for (int i = 0; i < name.length; i++) {
                move[i] = "";
            }

            System.out.println("실행 결과");
            for (int i = 0; i < num; i++) {
                display(name, move);
            }

            displayWinner(name, move);
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static String[] inputName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = Console.readLine().trim();
        return line.split(",");
    }

    public static int inputNum(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine().trim();
        return Integer.parseInt(input);
    }

    public static boolean Movement(){ //true:전진 false:정지
       int randomNum = Randoms.pickNumberInRange(0, 9);
       return randomNum >= 4;
    }

    public static void display(String[] arr,String[] move){ // 실행 결과 출력

        for(int i = 0; i < arr.length; i++){
            if(Movement())
                move[i] += "-";
            System.out.println(arr[i] + " : " + move[i]);
        }
        System.out.println("\n");
    }

    public static void displayWinner(String[] name, String[] arr){
        List<String> longestStrings = new ArrayList<>();
        int maxLength = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i].length() > maxLength){
                maxLength = arr[i].length();
                longestStrings.clear();
                longestStrings.add(name[i]);
            }
            else if(arr[i].length() == maxLength){
                longestStrings.add(name[i]);
            }
        }
        System.out.println("최종 우승자 : " + longestStrings);
    }
}
