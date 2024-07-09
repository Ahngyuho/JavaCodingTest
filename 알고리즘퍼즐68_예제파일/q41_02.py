n = 5
# 순방향으로 탐색하는 초깃값
fw = [list(range(1, n*2 + 1))]
# 역방향으로 탐색하는 초깃값
bw = [list(reversed(range(1, n*2 + 1)))]

depth = 1
while True:
  # 순방향으로 탐색
  temp = []
  for c in fw:
    for i in range(1, n + 1):
      temp.append(c[i:i+n] + c[0:i] + c[i+n:])
  fw = temp
  if len(set(map(tuple, fw)) & set(map(tuple, bw))) > 0:
    break 
  depth += 1

  # 역방향으로 탐색
  temp = []
  for c in bw:
    for i in range(1, n + 1):
      temp.append(c[n:i+n] + c[0:n] + c[i+n:])
  bw = temp
  if len(set(map(tuple, fw)) & set(map(tuple, bw))) > 0:
    break 
  depth += 1

print(depth)