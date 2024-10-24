# java-racingcar-precourse

## 2주차 - 자동차 경주

* * *  

### 기능 요구 사항 생각해보기

각 패키지의 클래스의 기능은 다음과 같다

##### racingcar package
> Application : 프로그램을 실행하는 Main함수가 있는 클래스  
> GameManager : 자동차 경주 게임을 관리하는 클래스. 프로그램의 중심을 담당한다  
> InputManager : 사용자가 입력받는 값들을 관리하는 클래스  
> OutputManager : 결과를 출력하는 클래스  
> RacingCar : 자동차 객체를 생성하고 관리하는 클래스
  
  
##### inspector package  
> InspectInputValue : 입력받은 문자열의 값이 유효한지 검사하는 클래스  
> InspectResult : 레이싱의 우승자를 결정하는 클래스
  
  
##### util package
> RandomGenerator : 랜덤한 변수를 생성하는 클래스
> InputNameParser : 입력받은 문자열을 파싱하는 클래스
  
  
##### exceptor package
> ExceptionHandler : 오류와 잘못 입력 받은 값을 관리하는 클래스
  
  
##### constant package
> ConstantHandler : 상수를 관리하는 클래스. 상수가 많아질 경우 클래스 단위로 분리하여 관리한다
  
* * *
  
### 생각해볼 프로그래밍 요구 사항
  
1. 공백만 입력되는 경우 :  원칙상으로는 입력이 가능하다. 그러나 사용자의 입장에서 공백 문자가 자동차의 이름이 되었을 때, 이 부분에서 혼동할 여지가 있다. 예를 들어 공백 문자인 자동차가 단독 우승일 경우, 우승자를 출력할 때 공백만 출력이 되어 공백이 우승했는지, 아니면 단독 우승인지를 파악할 수 없다. 따라서 공백이 입력되었다면 예외처리한다.  
  
2. 공백이 중간에 입력되는 경우, "pobi, woni, jun" 혹은 "pobi,woni,jun"과 같이 사용자의 입력에 따라 구분자 앞뒤로 공백이 올 수 있다. 이는 String 클래스의 trim 메서드 또는 strip 메서드를를 사용하여 간단하게 제거할 수 있다. 단, 후술할 유니코드 입력 문제 및 화이트스페이스의 종류로 인하여 strip 메서드만 사용한다.  

3. 이름 중간에 공백이 있는 경우 : "pobi, won i, jun" 과 같은 경우, 공백을 문자로 포함해야 할것인가? 지금은 자바로만 프로그램을 작성하기에 그럴 일은 없으나, 다른 언어나 외부의 라이브러리와 연결했을 때 배열을 나누거나 검색하는 과정에서 추가로 로직을 더 짜야하는 문제가 될 수 있다. 예를 들어 다음과 같이 문자열을 split하는 방식으로 새로운 플레이어를 등록한다면, "woni"와 "woni "를 구분할 수 없다. 그렇기에 공백이 중간에 오는 경우 이를 예외처리 해줘야한다.  
	- case 1 : 아예 공백 처리
	- case 2 : 이름 사이의 공백을 지우고 등록
  
4.  "pobi, pobi, pobi" : 이 역시 마찬가지로 예외처리 해줘야 한다. 실제 레이싱 게임에서 중복된 데이터가 들어가는 것은 불가능하고, 어떤 포비가 이겼는지 알 수 없다. 예를 들어 3명의 포비의 점수가 3,4,2고 결과 출력시 pobi라 한다면, 이것이 어떤 포비인 지 알 수 있는가?  
  
5. 유니코드 입력 문제 : 입력에 유니코드가 들어갈 수 있다. 예를 들어 현재 입력인 "pobi" 대신에 "포비"라고 입력이 들어올 수 있고, 심지어는 UTF-8의 범위에서 벗어나는 유니코드도 입력될 수 있다. 예를 들어 🤔는 UTF-16의 영역이지만, 우리가 인식하는 글자 수는 1글자이다. 그렇기에 이를 별도로 처리하는 자바의 메소드인 grapheme 등을 적용할 수 있겠다.  
  
6. 시행횟수에 음수, 실수, 문자열이 들어가는 경우 -> 당연히 예외처리 해줘야한다.  
  
7. 결과를 출력할 때, 2명 이상이 있는 경우는 어떻게 처리할 것인가? -> 이것은 가변리스트로 해결이 가능하다. 가변 리스트인 ArrayList의 경우, 배열의 크기가 따로 지정되지 않기 때문에 결과가 2개 이상인 경우를 해결할 수 있다. 즉, 1등의 점수를 저장하는 변수를 만들고, 이 값이 만약에 갱신이 된다면 ArrayList를 초기화한다. 만약에 최고점과 같다면 ArrayList에 객체를 추가하는 방식으로 1등이 여러 개인 경우를 해결할 수 있다.

* * *

### 구현할 기능 목록  
  
##### racingcar  
	[ ] Application  
	[ ] GameManager  
	[ ] InputManager  
	[ ] OutputManager  
	[ ] RacingCar  
  
##### inspector  
	[ ] InspectInputValue  
	[ ] InspectResult  
  
 ##### util  
 	[ ] RandomGenerator  
	[ ] InputNameParser  
  
##### exceptor
	[ ] ExceptionHandler  
  
##### constant package
	[ ] ConstantHandler