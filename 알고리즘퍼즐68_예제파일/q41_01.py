n = 4

# 초깃값을 설정
cards = [list(range(1, n * 2 + 1))]
answer = list(reversed(range(1, n * 2 + 1)))

flag = True
depth = 1
while flag:
  # 탐색
  result = []
  for c in cards:
    for i in range(1, n + 1):
      temp = c[i:i+n] + c[0:i] + c[i+n:]
      # 상태 확인 후 탈출
      if temp == answer:
        flag = False
      result.append(temp)
  # 다음 탐색 대비
  cards = result
  depth += 1

print(depth)
