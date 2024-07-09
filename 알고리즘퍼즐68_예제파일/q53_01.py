from itertools import permutations

# 원래의 수에 가산한 경우에 이동하는 양을 되돌려준다
def move(base, add):
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

# 이동하는 리스트에 대해 이동량을 합계
def count(ary):
  cnt = total = 0
  for i in ary:
    cnt += move(total, i)
    total += i
  return cnt

# 1~10의 순열에 대해 최소 이동량을 구한다
min_value = 100
for s in permutations(range(1, 10 + 1), 10):
  min_value = min(min_value, count(s))
print(min_value)
