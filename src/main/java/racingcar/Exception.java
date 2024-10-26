package racingcar;

public class Exception {
    public void except1(String[] strings) {
        if (strings.length==0){
            throw new IllegalArgumentException("Car name cannot be empty or whitespace");
        }
        for (String str : strings) {
            if (str == null || str.trim().isEmpty()) {
                throw new IllegalArgumentException("Car name cannot be empty or whitespace");
            }
            if (str.length() > 5) {
                throw new IllegalArgumentException("String length exceeds 5 characters: " + str);
            }
        }
    }
    public void except2(String[] strings){
        if (strings.length==1){
            throw new IllegalArgumentException("Cannot race with just one car");
        }
    }

    public void except3(int input) {
        if (input<1){
            throw new IllegalArgumentException("Count cannot be less than 1");
        }
    }
}
