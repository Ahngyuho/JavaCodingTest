W, H = 5, 6
ALL = (1 << W) - 1

# 각 행의 남자 수를 저장
boys = ["{:b}".format(i).count("1") for i in range(0, ALL + 1)]

# 세 개의 행 배치가 가능한가(위의 2행에 다음의 행을 이을 수 있는가?)
def check(r1, r2, r3):
  result = True
  for i in range(0, W): # 1행의 각 위치에 대해 확인
    # 좌우로 나열되어 있는지 확인
    # 파이썬은 Negative Shift가 안되므로 조건문으로 구분
    if i < 1:
      m1 = (0b111 >> 1) & ALL
    else: 
      m1 = (0b111 << (i - 1)) & ALL  
    m2 = 1 << i       # 상하로 나열되어 있는지 확인
    if (r1 & m2 == m2) and (r2 & m1 == m1) and (r3 & m2 == m2):
      result = False      # 남자가 나열된 경우는 NG
    if ((r1 ^ ALL) & m2 == m2) and ((r2 ^ ALL) & m1 == m1) and \
       ((r3 ^ ALL) & m2 == m2):
      result = False      # 여자가 나열되어 있는 경우도 NG
  return result

# 위의 2행에 이어지는 행의 해시를 작성
next = {}
for r1 in range(0, 1 << W): # 첫 번째 행
  for r2 in range(0, 1<< W): # 두 번째 행
    next[(r1, r2)] = [r3 for r3 in range(0, ALL + 1) if check(r1, r2, r3)]

memo = {}
def search(pre1, pre2, line, used):
  if (pre1, pre2, line, used) in memo:
    return memo[(pre1, pre2, line, used)] # 과거에 탐색 완료된 경우

  if line >= H:    # 맨 마지막 행까지 탐색했다면
    memo[(pre1, pre2, line, used)] = 1 if (used == W*H//2) else 0
    return memo[(pre1, pre2, line, used)]

  result = 0
  if line == H - 1:   # 맨 마지막 행의 직전
    for row in next[(pre2, pre1)]:
      if (pre1 in next[(row, row)]) and \
        (used + boys[row] <= W * H // 2):
        result += search(row, pre1, line + 1, used + boys[row])
  else:       # 맨 마지막 행 이외
    for row in next[(pre2, pre1)]:
      if used + boys[row] <= W * H // 2:
        result += search(row, pre1, line + 1, used + boys[row])
  memo[(pre1, pre2, line, used)] = result
  return result

count = 0
for r0 in range(0, 1 << W): # 맨 처음 행을 설정
  count += search(r0, r0, 1, boys[r0])
print(count)