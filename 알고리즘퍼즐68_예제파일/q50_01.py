﻿from itertools import permutations

N = 8 # 모래시계의 수
GOAL = [1] * N # 모두 1이 되면 다음에 동시에 아래로 떨어진다

count = 0
for init in permutations(range(1, N + 1)): # 초기 상태를 순열로 설정
  hourglass = init

  pos = 0
  log = {} # 같은 상태가 되는지를 확인하는 로그
  while True:
    key = tuple(hourglass)
    if key in log and log[key] == pos: # 과거에 같은 상태가 있다면 종료
      break
    if hourglass == GOAL:       # 목표 형태에 달하면 종료
      count += 1
      break
    log[key] = pos

    # 모래시계를 줄인다(남아 있지 않은 경우는 그대로)
    hourglass = list(map(lambda h: h - 1 if h > 0 else 0, hourglass))
    for i in range(0, init[pos]): # 모래시계를 반전
      rev = (pos + i) % N
      hourglass[rev] = init[rev] - hourglass[rev]
    pos = (pos + 1) % N           # 다음 위치로 이동

print(count)
