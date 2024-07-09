N = 11
memo = {}

def search(cards, num):
  global count
  if num == 0:
    return 1 
  if cards in memo:
    return memo[cards]

  # 비트 연산에서 사이에 두는 위치를 설정
  mask = (1 << (num + 1)) + 1
  count = 0
  while mask < (1 << (N * 2)):
    # 배치 가능하다면 재귀적으로 탐색
    if cards & mask == 0:
      count += search(cards | mask, num - 1) 
    # 사이에 두는 위치를 한 자리 이동
    mask <<= 1
  memo[cards] = count
  return count

print(search(0, N))
