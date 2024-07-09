W, H = 6, 5
# 눈금의 초기화
puzzle = [[0 for i in range(H + 2)] for j in range(W + 2)]
for w in range(0, W + 2):
  for h in range(0, H + 2):
    if (w==0) or (w==W+1) or (h==0) or (h==H + 1):
      puzzle[w][h] = -1
      
def fill(x, y, current, to):        # 연속 확인용으로 채워 나간다
  if puzzle[x][y] == current:
    puzzle[x][y] = to
    fill(x - 1, y, current, to)
    fill(x + 1, y, current, to)
    fill(x, y - 1, current, to)
    fill(x, y + 1, current, to)

def check():
  x, y = 1, 1
  if puzzle[x][y] == 1:
    x += 1 
  fill(x, y, 0, 2)              # 하얀 칸을 더미로 채운다
  # 특이한 형태이지만 List Flatten 과정입니다.
  result = (sum(puzzle, []).count(0) == 0)
  fill(x, y, 2, 0)              # 더미를 하얀 칸으로 되돌린다
  return result

def search(x, y):
  if x == W + 1:
    x, y = 1, y + 1         # 오른쪽 끝에 도달하면 다음 행
  if y == H + 1:
    return 1                # 맨 마지막까지 탐색할 수 있으면 성공
  cnt = search(x + 1, y)    # 하얀 칸을 설정하고 다음을 탐색
  # 왼쪽이나 위쪽이 검은 칸 이외인 경우, 검은 칸을 설정하고 다음을 탐색
  if (puzzle[x - 1][y] != 1) and (puzzle[x][y - 1] != 1):
    puzzle[x][y] = 1      # 검은 칸을 설정
    if check():
      cnt += search(x + 1, y)
    puzzle[x][y] = 0      # 검은 칸을 되돌린다
  return cnt

print(search(1, 1))       # 왼쪽 위로부터 개시