N = 8                     # 각 색의 수
start = (1 << N) - 1      # 시작 상태(0이N개,1이N개)
mask = (1 << N * 2) - 1   # 비트 마스크

# 목표 상태(0과 1을 번갈아 설정)
goal1 = 0
for i in range(0, N):
  goal1 = (goal1 << 2) + 1
goal2 = mask - goal1

# 교환 횟수
count = N * 2
for i in range(0, 1 << N * 2): # 교환하는 시작 위치의 비트열
  turn = i ^ (i << 1) ^ (i << 2)
  turn = (turn ^ (turn >> (N * 2))) & mask

  # 목표와 일치하면 교환하는 위치에 있는 수의 최소치를 판정
  if (start ^ turn == goal1) or (start ^ turn == goal2):
    count = min(count, "{:b}".format(i).count('1'))
    print("{:b}".format(i))

print(count)
