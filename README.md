# java-racingcar-precourse
## 프로젝트 설명
이 과제는 간단한 자동차 경주 게임을 구현하는 과제입니다.

사용자는 레이싱에 참여할 자동차 이름을 쉼표로 구분하여 여러 개 입력할 수 있습니다.  
각 자동차는 전진하거나 멈출 수 있으며, 전진 여부는 0부터 9 사이의 무작위 값에 따라 결정됩니다.  
값이 4 이상일 때 자동차는 전진합니다.

경기는 사용자가 지정한 N 라운드만큼 진행되며, 각 라운드에서 자동차는 한 번씩 이동 기회를 가집니다.  
매 라운드 종료 시 경기 현황을 출력하고, 최종 라운드 종료 후 우승자 목록을 출력합니다.



<br>

- - -

# 과제 진행 과정

객체 지향 설계와 MVC 패턴을 활용하여 과제를 해결해 볼 생각입니다.  
"객체지향의 사실과 오해" 책에서 배운 What/Who 사이클 접근법으로 설계를 해봤습니다.  

너무 구체적인 설계를 하면, 이전의 설계에 지나치게 의존하여 더 나은 방향을 찾지 못하는  
역효과가 발생할 것 같아 추상적이라도 역할이 확실한 설계를 하도록 노력했습니다.  

<br>

**P.S. 초반 설계가 변경되었습니다.** [(해당 커밋)](https://github.com/Hacanna42/java-racingcar-7/commit/54870d782b89d4b6a79599e73831418ac693e490)  
```
커밋 54870d7 에서...

: 처음에는 MVC 패턴을 위해 패키지 구조를 Model, View, Controller로 만들고
개발을 시작했습니다, 하지만 개발 도중 패키지 구조와 MVC 패턴은 아무런
관계가 없다는 것을 깨닫게 되었습니다. 기존의 패키지 구조로 계속 개발을 이어갈 경우
Model에는 RacingGame과 Car가 겹치게 되는데 이 경우 Car의 strategy를 Model 패키지에
두기엔 RacingGame과는 관련이 없어서 무언가 일관성이 떨어지고 도메인별 응집도가
낮아진다고 생각했습니다. 따라서 도메인별 응집도를 높이기 위해 계층형 구조에서
도메인형 구조로 패키지 구조를 변경했습니다.
```

<br>





## 구현할 기능 목록
1. 자동차 이름과 시도할 횟수를 입력받는 기능
2. 입력 값이 올바른지 검증하는 기능
3. 무작위 값을 구한 후 4 이상인지 확인하는 기능
4. 무작위 값에 따라 차를 전진시키는 기능
5. 차의 이름과 현재 위치를 출력하는 기능
6. 우승자를 출력하는 기능  

<br>

## What(무엇이 필요한가)
- [x] 자동차가 필요하다  
    자동차는 이름과 위치를 필드로 가져야 한다.  


- [x] 경주 게임이 필요하다  
    경주 게임은 자동차 목록이 필요하다.  
    시도할 횟수도 필요하다.  
    자동차를 규칙에 맞게 조작해야 한다.  
    게임 종료 시 우승자를 판단해야 한다.  


- [x] 입력 처리  
    자동차 이름과 시도할 횟수를 입력받아야 한다.


- [x] 출력 처리  
    실시간 현황을 출력해야 한다.  
    최종 우승자를 출력해야 한다.  

<br>

## Who(누가 담당할 것인가)
- [x] Model/Car 클래스 (자동차 역할)  
- [x] Controller/RacingGame 클래스 (경주 게임 역할)  
- [x] View/InputHandler 클래스 (입력 처리 역할)
- [x] View/OutputHandler 클래스 (출력 처리 역할)


<br>

## 구체적인 제한사항
1. 자동차 이름에는 반점(,)이 포함될 수 없습니다. 가능한 경우 구분자로 인식됩니다.
2. 경주 진행 횟수는 최소 1 이상입니다.
