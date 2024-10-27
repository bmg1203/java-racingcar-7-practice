package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name){
        this.name = name;
    }

    public void moveForward(){
        this.position++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}
