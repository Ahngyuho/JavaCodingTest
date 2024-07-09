N = 6
FREE, USED, WALL = 0, 1, 9
memo = {}

def multi(input_list):
  output = 1
  for i in input_list:
    output *= i
  return output

def search(seat):
  key = tuple(seat)
  if key in memo:
    return memo[key]
  count = 0
  # 옆에 사람이 없는 좌석을 찾는다
  for i in range(0, len(seat)):
    if seat[i] == FREE:
      if (seat[i - 1] != USED) and (seat[i + 1] != USED):
        # 비어 있다면 앉고 다음을 탐색
        seat[i] = USED
        count += search(seat)
        seat[i] = FREE

  # 옆에 사람이 없는 좌석이 있다면 위에서 카운트한 값, 그 외에는 계승
  output = count if (count > 0) else multi(range(1, seat.count(FREE) + 1))
  memo[key] = output
  return output

print(search([WALL] + [FREE] * N + [WALL] + [FREE] * N + [WALL]))