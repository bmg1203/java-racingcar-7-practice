//package racingcar.view;
//
//import camp.nextstep.edu.missionutils.Console;
//import java.util.Iterator;
//import java.util.List;
//import racingcar.domian.car.Car;
//import racingcar.repository.CarRepository;
//
//public class View {
//
//    public String[] showCarListInput() {
//        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
//        String inputCarNames = camp.nextstep.edu.missionutils.Console.readLine();
//
//        String[] carNames = inputCarNames.split(",");
//        return deleteBlank(carNames);
//
//    }
//
//    private String[] deleteBlank(String[] carNames) {
//        String[] deleteBlankCarNames = new String[carNames.length];
//        for (int i = 0; i < deleteBlankCarNames.length; i++) {
//            deleteBlankCarNames[i] = carNames[i].replace(" ", "");
//        }
//        return deleteBlankCarNames;
//
//    }
//
//    public String ShowTryNumberInput() {
//        System.out.println("시도할 횟수는 몇 회인가요?");
//        return Console.readLine();
//    }
//
//    public void startProcessView() {
//        System.out.println();
//        System.out.println("실행결과");
//    }
//
//    public static void showProcessView(List<Car> cars) {
//
//        Iterator<Car> iterator = cars.iterator();
//
//        while (iterator.hasNext()) {
//            Car car = iterator.next();
//            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
//        }
//        System.out.println();
//
//    }
//
//
//    public void showResult(CarRepository carRepository) {
//        List<Car> winners = carRepository.findWinners();
//        StringBuilder winnersStringBuilder = new StringBuilder();
//
//        Iterator<Car> carIterator = winners.iterator();
//        while (carIterator.hasNext()) {
//            Car winner = carIterator.next();
//            winnersStringBuilder.append(winner.getCarName());
//            if (carIterator.hasNext()) {
//                winnersStringBuilder.append(",");
//                winnersStringBuilder.append(" ");
//            }
//        }
//
//        System.out.println("최종 우승자 : " + winnersStringBuilder);
//    }
//}
