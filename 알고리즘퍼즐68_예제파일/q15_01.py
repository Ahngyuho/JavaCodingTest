N = 10      # 계단의 단 수
STEPS = 4   # 한 번에 진행할 수 있는 단 수

def move(a, b):
  if a > b:
     # A가 B보다 위에 있으면 종료
    return 0
  elif a == b: 
    # 같은 단에서 멈추면 수를 셈
    return 1 
  cnt = 0
  for da in range(1, STEPS + 1):
    for db in range(1, STEPS + 1):
      cnt += move(a + da, b - db) # 재귀적으로 탐색
  return cnt

# A는 0의 위치에서 B는 N의 위치에서 스타트
print(move(0, N))
