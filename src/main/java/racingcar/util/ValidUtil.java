package racingcar.util;

public class ValidUtil {
    public static boolean isNumeric(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean isEmpty(String input){
        return input == null || input.isEmpty();
    }


}
