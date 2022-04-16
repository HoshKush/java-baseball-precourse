## 기능 목록
+ inputNum : 사용자 입력 숫자
+ targetNum : 컴퓨터 생성 숫자

----------------------------------------
### Game[컴퓨터]

----------------------------------------
1. createGame
    + 새로운 게임을 생성한다.
2. generateNumberStr
    + 각 자리의 수가 유일한 주어진 자릿수의 숫자를 생성한다 (ex : 234)
3. pollNumberInList(List<Integer> list)
    + list안에 존재하는 임의의 숫자를 반환 및 제거.

-----------------------------------------
### GameProcessor[게임 진행]

-----------------------------------------
1. isBall
    + 볼 여부를 판단한다.
    + 입력받은 숫자가 targetNum에 존재하면서 위치가 다를 시 1 반환
2. isStrike
    + 스트라이크 여부를 판단한다.
    + 입력받은 숫자가 targetNum에 존재하면서 위치가 같을 시 1 반환
3. isNothing
    + 낫싱 여부를 판단한다.
    + inputNum 중 어떠한 숫도 targetNum과 일치하지 않을 시 true반환
4. isSame
    + inputNum과 targetNum 같을 시 true 반환

------------------------------------------
### InputValidation

------------------------------------------
1. isDuplicated
    + 숫자의 중복사용 여부를 체크한다.
2. isThreeDigits
    + 주어진 문자열이 3자리 숫자인지 체크한다.
