# 2개 뚫기의 가능성이 있는 방법을 설정
board = [[1, 2], [2, 3], [7, 8], [8, 9],
         [1, 4], [3, 6], [4, 7], [6, 9]]
# 1개씩 뚫는 방법을 추가
for i in range(1, 9 + 1):
  board.append([i])

memo = {"[]": 1}
def strike(board):
  # 이미 탐색 완료된 경우는 그 값을 사용
  key = str(board)
  if key in memo:
    return memo[key]
  cnt = 0
  for b in board:
    # 뚫은 과녁에 포함되는 숫자가 있는 뚫기 방법은 제외
    next_board = filter( \
      lambda i: \
        # 교집합이 없는 경우만 찾습니다.
        len(set(b).intersection(set(i))) == 0 \
    , board)
    next_board = list(next_board)
    cnt += strike(next_board)
  
  memo[key] = cnt
  return cnt

print(strike(board))
