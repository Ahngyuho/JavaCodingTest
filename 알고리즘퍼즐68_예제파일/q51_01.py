M, N = 6, 5  # ‘과자의 포장지’와‘안에 든 과자’의 수를 설정
memo = {}    # 메모화하기 위한 해시

def search(candy, color):
  # 과자를 모두 포장했다.
  if candy == [0] * N:
    return 1
  # 메모했던 것이 있다면 그것을 사용
  key = tuple(candy + [color])
  if key in memo:
    return memo[key]

  # 포장지와 내용물이 일치하지 않는 것을 카운트
  cnt = 0
  for i in range(0, len(candy)):
    if i != (color % len(candy)):       # 일치하지 않는 경우
      if candy[i] > 0:                  # 과자가 남아 있는 경우
        candy[i] -= 1
        cnt += search(candy, color + 1) # 다음을 탐색
        candy[i] += 1

  memo[str(candy + [color])] = cnt   # 과자의 수와 색을 메모에 저장
  return cnt

print(search([M] * N, 0))
