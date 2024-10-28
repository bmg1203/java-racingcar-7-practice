package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;
import racingcar.Service.CarService;
import racingcar.Service.GameService;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    CarService carService = new CarService();
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 자동차_이름_입력_테스트() {
        String input = "car1,car2,car3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = InputView.Car_names();
        assertEquals("car1,car2,car3", result);
    }
    @Test
    void 게임_횟수_입력_테스트() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = InputView.Game_count();
        assertEquals(5, result);
    }
    @Test
    void 자동차_이름_분리_테스트(){
        GameService gameService=new GameService();
        String carNames="pobi,woni,jun";
        ArrayList<Car> carList=gameService.Separate_Carnames(carNames);
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getCarName()).isEqualTo("pobi");
        assertThat(carList.get(1).getCarName()).isEqualTo("woni");
        assertThat(carList.get(2).getCarName()).isEqualTo("jun");
    }
    @Test
    void 실행횟수_음수_처리_에러_테스트(){
        String Count="-1";
        ByteArrayInputStream Countin=new ByteArrayInputStream(Count.getBytes());
        System.setIn(Countin);
        assertThrows(IllegalArgumentException.class,()->{
            InputView.Game_count();
        });
    }
    @Test
    void 자동차_전진_테스트(){
        ArrayList<Car> cars=new ArrayList<>();
        Car car1=new Car("pobi");
        Car car2=new Car("woni");
        cars.add(car1);
        cars.add(car2);
        CarService car=new CarService();
        int testValueMove=4;
        int testValueNoMove=3;
        if(car.is_Move(testValueMove)){
            car1.setPosition();
        }
        if(car.is_Move(testValueNoMove)){
            car2.setPosition();
        }
        assertEquals("-",car1.getPosition());
        assertEquals("",car2.getPosition());
    }
    @Test
    void 자동차_이름_5자_초과_테스트(){
        String CarName="woniwoni,pin";
        ByteArrayInputStream CarNamein=new ByteArrayInputStream(CarName.getBytes());
        System.setIn(CarNamein);
        assertThrows(IllegalArgumentException.class,()->{
            InputView.Car_names();
        });
        System.setIn(System.in);
    }
    @Test
    void 우승자_선정_테스트(){
        Car car1=new Car("pobi");
        Car car2=new Car("woni");
        Car car3=new Car("jun");
        car1.setPosition();
        car1.setPosition();
        car1.setPosition();
        car2.setPosition();
        car2.setPosition();
        car3.setPosition();
        car3.setPosition();
        car3.setPosition();
        ArrayList<Car> cars=new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        CarService car=new CarService();
        ArrayList<Car> winners=car.getWinnerCar(cars);
        assertEquals(2, winners.size());
        assertEquals("pobi",winners.get(0).getCarName());
        assertEquals("jun",winners.get(1).getCarName());
    }
    @Test
    void 우승자_출력_테스트(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Car car1=new Car("pobi");
        Car car2=new Car("woni");
        car1.setPosition();
        car1.setPosition();
        car2.setPosition();
        car2.setPosition();
        ArrayList<Car> cars=new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        OutputView.Print_Winners(cars);
        String expectedOutput = "최종 우승자 : pobi, woni";
        assertEquals(expectedOutput, outputStream.toString());
        System.setOut(originalOut);
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
