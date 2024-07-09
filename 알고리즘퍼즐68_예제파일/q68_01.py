# 목표를 초깃값으로서 설정
memo = { 0x000fff: 0, 0xfff000: 0, 0xcccccc: 0, 0x333333: 0 }
queue = list(memo.keys())

W, H = 4, 6

# 교환 가능한 위치를 설정
mask = []

for i in range(0, W * H):
  # 가로로 이웃한다
  if i % W < W - 1: 
    mask.append((1 << 1 | 1) << i) 
  # 세로로 이웃한다
  if i < W * (H - 1):
    mask.append((1 << W | 1) << i) 

depth = 0
while len(queue) > 0: # 탐색해야 하는 것이 있는 한 반복한다
  print(depth, len(queue))
  depth += 1
  next_queue = []
  for q in queue:
    for m in mask:
      # 2군데가 ‘둘 다 0’이거나 ‘둘 다 1’인 경우 이외에서 미탐색 부분을 탐색
      if ((q & m) != 0) and ((q & m) != m) and (q ^ m) not in memo:
        memo[q ^ m] = depth
        next_queue.append(q ^ m)
  queue = next_queue