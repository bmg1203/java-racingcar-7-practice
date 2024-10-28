package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class AttemptCountParser {


    public String inputAttemptCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    /**
     * 입력받은 시도 횟수가 양수인지 검증하는 메서드
     * @param input 사용자가 입력한 시도횟수
     * @return 유효한 입력일 경우, int로 형변환 후 return
     **/
    public int validateAttemptCount(String input){
        try {
            int number = Integer.parseInt(input);
            if (number <= 0) {
                throw new IllegalArgumentException("시도 횟수는 0보다 커야합니다.");
            }
            return number;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수가 숫자가 아닙니다.");
        }
    }

    public int getAttemptCount(){
        return validateAttemptCount(inputAttemptCount());
    }
}
