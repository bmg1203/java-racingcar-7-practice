# java-racingcar-precourse

# 📄기능 구현 목록

## 1. 사용자로부터 입력 받기✅

- **입력받는 화면 문구 출력하기**✅


- **사용자에게 입력 받기**✅
    - "자동차 이름"과 "진행 횟수" 두가지 입력이 존재

  > 입력 화면
  > ```
  > 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
  > > pobi,woni,jun // 사용자 입력
  > 시도할 횟수는 몇 회인가요?
  > > 3 // 사용자 입력
  > ```

## 2. 사용자의 입력 검증하기 및 DTO 생성

- **View에서 Controller로 DTO를 통하여 전달하기**✅
    - ~~DTO로 만드는 과정에서 기본적인 Validation 수행~~
    - 기본적인 유효성 검사는 DTO 생성 시 보다, 사용자의 입력이 들어왔을 때 하는 것이 맞다고 판단해 View에서 검사하는 것으로 수정✅


- **View에서 사용자의 입력을 간단히 검증하기**✅
    - 아무것도 입력되지 않거나 공백만 입력하진 않았는지 검증✅

  > - [x] 입력이 NULL인 경우
  >
  > - [x] 아무것도 입력하지 않은 경우
  >
  > - [ ] ~~공백만 입력한 경우~~ => 공백에 대한 검사는 파싱을 하며 수행하는 것으로 수정


- **Controller에서 사용자의 입력을 검증하기**
    - `,`로 구분된 자동차 이름들에 대한 `String` 검증하기✅
    - 라운드 진행 횟수 검증하기
        - 자동차의 진행과 혼돈을 야기하므로 라운드라고 표현

  > - [ ] 진행 횟수가 정한 범위를 초과하는지 검사
  >
  > - [x] 이름 없이 `,`가 두번 연속으로 등장하는지 검사
  >
  > - [x] 이름이 공백인지 검사
  >
  > - [x] 이름의 길이가 5자 이내인지 검사

<br>

**⚠️이름에 대한 공백 처리**

    자동차의 이름의 앞뒤 공백은 무시하며, 중간 공백은 허용.
    자동차 이름의 길이를 검사할 때는 앞뒤 공백을 trim한 뒤 길이 판단.

## 3. 레이싱을 시작할 준비하기

- **자동차 관련 로직을 관리하는 객체 만들기** (예명 : `Car`)
    - 예상 필드
        - 자동차의 이름
        - 진행한 거리
        - 필드에 대한 getter 메서드


- **레이싱 관련 로직을 관리하는 객체 만들기** (예명 : `Racing`)
    - 예상 필드
        - 자동차 객체에 대한 리스트
        - 총 라운드 횟수
        - 진행한 라운드 횟수
        - 라운드 진행 시 자동차 랜덤 진행을 호출하는 메서드
        - 자동차 객체 리스트에 대한 getter 메서드

## 4. 경주 시작하기 및 실행 결과 출력하기

- **라운드 횟수동안 경주를 진행시킴**


- **라운드가 끝날 때 마다 자동차들의 이동거리를 출력시킴**
    - 사용자가 입력한 순서대로 각 라인에 출력
    - 최초 라운드 출력 전 `실행 결과`라는 문구를 출력

  > 라운드 종료마다 출력할 화면 예시
  >   ```text
  >   pobi : -
  >   woni : 
  >   jun : -
  > 
  >   ```

## 5. 사용자에게 우승자 출력하기

- 복수의 우승자가 존재한다면 사용자가 입력한 순서대로 출력

  > 결과 화면
  > ```text
  > 최종 우승자 : pobi, jun
  > ```

- 프로그램 도중 예외가 발생할 시 예외 메시지를 출력
    - 프로젝트에서 주어지는 테스트 케이스로 인해 출력 후 다시 던지도록 해야함.
