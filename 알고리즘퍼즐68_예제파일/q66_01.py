N = 6
FREE, USED, WALL = 0, 1, 9

# 보초 값으로 양끝과 중앙에 벽을 설정
seat = [WALL] + [FREE] * N + [WALL] + [FREE] * N + [WALL]

def multi(input_list):
  output = 1
  for i in input_list:
    output *= i
  return output

def search(person):
  count = 0
  # 옆에 사람이 없는 좌석을 찾는다
  for i in range(0, len(seat)):
    if seat[i] == FREE:
      if (seat[i - 1] != USED) and (seat[i + 1] != USED):
        # 비어 있다면 앉고 다음을 탐색
        seat[i] = USED
        count += search(person + 1)
        seat[i] = FREE
  # 옆에 사람이 없는 좌석이 있다면 위에서 카운트한 값, 그 외에는 계승
  return count if (count > 0) else multi(range(1, seat.count(FREE) + 1))

print(search(0))