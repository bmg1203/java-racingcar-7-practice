# java-racingcar-precourse
### 기능 목록
> 1. 입력값 검증 - 사용자가 잘못된 값을 입력시 try-with-resources로
>   IllegalArgumentException을 발생, 리소스 해제, 애플리케이션은 종료
>    1. 자동차 이름 입력 검증 - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능
>       
>       이름으로 올 수 있는것 => 영어,한글,숫자,문자
>       1. ,를 기준으로 구분시 이름 양쪽 공백은 제거하는 기능
>       2. ,를 기준으로 구분했을 _때 이름이 1자 이상 5자 이하가 되도록 검증하는 기능
>       3. 자동차 이름 중복을 검증하는 기능
>    2. 시도할 횟수 입력 검증
>       1. 횟수 입력 값을 처리하는 기능 - 0, 자연수가 아닐경우 예외처리
> 2. 자동차 경주를 진행하는 기능 - 시도 횟수가 0일 경우 공동 우승
> 3. 매 횟수마다 랜덤값을 구해 전진 여부를 구현하는 기능 - Randoms.pickNumberInRange(0, 9); 사용
> 4. 매 횟수마다 전진 결과를 출력하는 기능
> 5. 우승자를 구하는 기능
> 6. 최종우승자를 출력하는 기능 - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분
