memo = { 0x000fff: 0, 0xfff000: 0, 0xcccccc: 0, 0x333333: 0 }
queue = [0x000fff, 0x333333] # 초깃값을 왼쪽 위가 0인 것으로만 걸러냄
W, H = 4, 6
mask = []
for i in range(0, W * H):
  if i % W < W - 1:
    mask.append((1 << 1 | 1) << i) 
  if i < W * (H - 1):
    mask.append((1 << W | 1) << i) 

depth = 0
while len(queue) > 0:
  print(depth, len(queue) * 2) # 답은 2배한다
  depth += 1
  next_queue = []
  for q in queue:
    for m in mask:
      if ((q & m) != 0) and ((q & m) != m) and (q ^ m) not in memo:
        memo[q ^ m] = depth
        # 비트를 반전한 것을 메모에 설정한다
        memo[(q ^ m) ^ ((1 << W * H) - 1)] = depth
        next_queue.append(q ^ m)
  queue = next_queue