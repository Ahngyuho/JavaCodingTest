W, H = 6, 4
DIR = [[0, 1], [-1, 0], [0, -1], [1, 0]] # 이동 방향
left = [0] * H   # 세로 선을 사용했는지 비트 단위로 저장
bottom = [0] * W # 가로 선을 사용했는지 비트 단위로 저장

def search(x, y, dir, left, bottom):
  left_l = left.copy()
  bottom_l = bottom.copy()
  # 경계를 넘거나 사용 완료된 경우는 진행할 수 없음
  if (dir == 0) or (dir == 2): # 상하로 이동한 경우
    pos = min([y, y + DIR[dir][1]])
    if (pos < 0) or (y + DIR[dir][1] > H):
      return 0 
    if left_l[pos] & (1 << x) > 0:
      return 0 
    left_l[pos] |= (1 << x)        # 세로 선을 사용 완료로 함
  else:                             # 좌우로 이동한 경우
    pos = min([x, x + DIR[dir][0]])
    if (pos < 0) or (x + DIR[dir][0] > W):
      return 0 
    if bottom_l[pos] & (1 << y) > 0:
      return 0 
    bottom_l[pos] |= (1 << y)      # 가로 선을 사용 완료로 함
  next_x, next_y = x + DIR[dir][0], y + DIR[dir][1]
  if (next_x == W) and (next_y == H):
    return 1   # B에 도달하면 종료

  cnt = 0
  # 직진
  cnt += search(next_x, next_y, dir, left_l, bottom_l)
  # 좌회전
  dir = (dir + 1) % len(DIR)
  cnt += search(next_x, next_y, dir, left_l, bottom_l)
  return cnt
  
# 시작점으로부터 오른쪽으로 시작
print(search(0, 0, 3, left, bottom))