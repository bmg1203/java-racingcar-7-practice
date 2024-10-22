package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarArrayCheck {

	String[] carArray = {};
	int carLength = 0;
	Map<String, Integer> carMap = new LinkedHashMap<String, Integer>();

	public void carNameCheck(String carName) {
		if (carName.endsWith(",")) {
			System.err.println("자동차 이름은 빈문자열로 입력할 수 없습니다.");
			throw new IllegalArgumentException();
		}
		carNameSplit(carName);
	}

	private void carNameSplit(String carName) {
		this.carArray = carName.split(",");
		this.carLength = carArray.length;
		check();
	}

	private void check() {
		carArrayLength();
		carMap();
	}

	private void carArrayLength() {
		if (carArray == null || carLength <= 1) {
			System.err.println("경주할 자동차를 2개 이상 입력해주세요.");
			throw new IllegalArgumentException();
		}
	}

	private void carMap() {
		for (String name : carArray) {
			nameCheck(name);
			carMap.put(name, 0);
		}
	}

	private void nameCheck(String name) {
		if (name.isBlank()) {
			System.err.println("자동차 이름은 공백으로 입력할 수 없습니다.");
			throw new IllegalArgumentException();
		}
		if (name.length() > 5) {
			System.err.println("자동차 이름은 5자 이하로 입력해주세요.");
			throw new IllegalArgumentException();
		}
		if (carMap.containsKey(name)) {
			System.err.println("자동차 이름은 중복될 수 없습니다.");
			throw new IllegalArgumentException();
		}
	}

	public Map<String, Integer> getCarMap() {
		return carMap;
	}

}
