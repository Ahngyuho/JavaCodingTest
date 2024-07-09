from itertools import product

N = 5
# 우수법의 이동 방향(우, 상, 좌, 하의 순서)
dx = [[1, 0], [0, -1], [-1, 0], [0, 1]]

# maze:벽의 배치
# p1, d1: 첫 번째 사람의 경로, 이동 방향
# p2, d2: 두 번째 사람의 경로, 이동 방향
def search(maze, p1, d1, p2, d2):
  if len(p1) == len(p2): # 두 사람이 함께 이동한 경우
    # 두 사람이 만난 경우는 성공
    if p1[-1][0:2] == p2[-1][0:2]:
      return True 
    # 첫 번째 사람이 오른쪽 아래에 도달한 경우는 실패
    if p1[-1][0:2] == [N - 1, N - 1]:
      return False 
    # 두 번째 사람이 왼쪽 위에 도달한 경우도 실패
    if p2[-1][0:2] == [0, 0]:
      return False 
  # 같은 방향에서 이동해 온 경우는 루프이므로 실패
  if p1.count(p1[-1]) > 1:
    return False

  pre = p1[-1]
  for i in range(0, len(dx)): # 우수법으로 움직일 수 있는 방향을 탐색
    d = (d1 - 1 + i) % len(dx)
    px = pre[0] + dx[d][0]
    py = pre[1] + dx[d][1]
    # 이동처가 벽이 되어 있지 않은지 확인
    if (px >= 0) and (px < N) and (py >= 0) and (py < N) and \
       (maze[px + N * py] == 0):
      return search(maze, p2, d2, p1 + [[px, py, d]], d)
  return False

a = [[0, 0, -1]]    # A: 왼쪽 위(X 좌표, Y 좌표, 이전 이동 방향)
b = [[N - 1, N - 1, -1]]  # B: 오른쪽 아래(X 좌표, Y 좌표, 이전 이동 방향)
cnt = 0
for maze in product([0, 1], repeat=N*N-2):
  # 두 사람의 시작 위치는 반드시 통로로서 탐색
  # A는 아래로 이동(dx[3]), B는 위로 이동(dx[1])
  maze = list(maze)
  if search([0] + maze + [0], a, 3, b, 1):
    cnt += 1
print(cnt)