N = 30
boy, girl = 1, 0
for i in range(0, N):
  # n-1명까지 늘어서 있는 상태에서 구한다
  boy, girl = boy + girl, boy
print(boy + girl)
