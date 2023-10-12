Model
: Controller와 View에 의존 안함
[ ] BridgeRandomNumberGenerator
- 다리를 만들기 위해 필요한 0, 1 숫자 리턴하는 메서드 보유
[ ] BridgeMaker
- Controller로부터 받은 size 값과 bridgeNumberGenerator를 활용해 makeBridge 메서드 완성
[ ] BridgeGame
- bridge 정보 보유
- 유저 입력 정보 보유
- move 수행하여 정답인지 반환
- retry 할 지를 판단하여 Controller에게 반환

Controller(Application)
: Model과 View를 이용

[메서드] getBridgeSize
[메서드] getBridge 
[메서드] runBridgeGameRound
- move 여부에 따라 OutputView에 X, O 중 출력할 것 전달.
- 위쪽에 출력할 건지 아래쪽에 출력할 건지도 전달해줘야 함
- 그러면 userChoice 리스트 전체를 같이 전달해주는게 맞을듯
[메서드] runBridgeGameUntilQuit

View
: 사용자마다 다르게 보여주어야 하는 데이터에 한하여 Model에만 의존
  Model로부터 데이터를 받을 때, 반드시 Controller를 통해 받아야 한다.
[ ] InputView
- 다리의 길이를 입력받아 생성(3~20) - 예외처리

- [ ] OutputView
[메서드] 매라운드 플레이어가 이동할 칸을 입력(U, D) - 예외처리
[메서드] printMap
- userChoice 리스트와 canMove 여부를 전달받아 map 출력
[메서드]
