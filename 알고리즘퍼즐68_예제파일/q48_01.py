W, H = 6, 5          # 가로와 세로의 칸 수
USABLE = 2           # 사용 가능한 횟수
max_value = 0        # 최장 길이
h = [0] * (H + 1)    # 수평 방향의 선을 사용한 횟수를 저장
v = [0] * (W + 1)    # 수직 방향의 선을 사용한 횟수를 저장

def search(x, y):
  global max_value
  if x == W and y == H: # B에 도착하면 최대치를 확인하고 종료
    max_value = max(sum(h) + sum(v), max_value)
    return
  if h[y] < USABLE:     # 수평 방향으로 이동 가능할 때
    if x > 0:           # 왼쪽으로 이동
      h[y] += 1
      search(x - 1, y)
      h[y] -= 1
    if x < W:           # 오른쪽으로 이동
      h[y] += 1
      search(x + 1, y)
      h[y] -= 1

  if v[x] < USABLE:     # 수직 방향으로 이동 가능할 때
    if y > 0:           # 위로 이동
      v[x] += 1
      search(x, y - 1)
      v[x] -= 1
    if y < H:           # 아래에 이동
      v[x] += 1
      search(x, y + 1)
      v[x] -= 1

search(0, 0)            # A의 위치에서 스타트
print(max_value)
