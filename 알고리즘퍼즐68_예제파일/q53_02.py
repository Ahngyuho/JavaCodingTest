N = 10

# 원래의 수에 가산한 경우에 이동하는 양을 되돌려준다
def move(bit, add):
  base = 0
  for i in range(0, N):
    if (bit & (1 << i)) > 0:
      base += i + 1
  
  # 10의 자리의5의 알 위치를 확인
  a0, a1 = divmod(base + add, 50)
  b0, b1 = divmod(base, 50)

  # 10의 자리의1의 알 위치를 확인
  a2, a3 = divmod(a1, 10)
  b2, b3 = divmod(b1, 10)

  # 1의 자리의 알 위치를 확인
  a4, a5 = divmod(a3, 5)
  b4, b5 = divmod(b3, 5)

  # 모든 위치의 차이로 옮기는 양을 가산
  return abs(a0 - b0) + abs(a2 - b2) + abs(a4 - b4) + abs(a5 - b5)

memo = {}
memo[(1 << N) - 1] = 0

# 10까지 더했을 때의 이동량이 최소가 될 때를 구한다
def search(bit):
  if bit in memo:
    return memo[bit]
  min_value = 100
  for i in range(0, N):
    if bit & (1 << i) == 0:
      min_value = min(min_value, move(bit, i + 1) + search(bit | (1 << i)))
  memo[bit] = min_value
  return min_value

print(search(0))
