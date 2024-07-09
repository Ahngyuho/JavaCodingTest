N = 10      # 계단의 단 수
STEPS = 4   # 한 번에 진행할 수 있는 단 수

dp = [0] * (N + 1)          # t회 이동으로 이동한 위치 집계
cnt = 0
dp[N] = 1                   # 초깃값 설정

for i in range(0, N):   # 이동 횟수(최대 N)
  for j in range(0, N + 1): # 이동 시작           
    for k in range(1, STEPS + 1):
      if k > j:
        break 
      print(j-k, j)  
      dp[j - k] += dp[j]
    dp[j] = 0                # 이동을 시작한 곳은 클리어
  if i % 2 == 1:
    cnt += dp[0]             # 짝수 회 이동으로 반대 위치에 도착
    
print(cnt)
