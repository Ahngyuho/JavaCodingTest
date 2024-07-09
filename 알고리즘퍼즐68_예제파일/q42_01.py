from itertools import permutations
from math import gcd

def search(abc, depth, max_abc, log):
  if tuple(abc) in log:
    return False    # 탐색 완료
  if abc[0] == (max_abc[0] // 2):
    return True     # 종료 조건
  log[tuple(abc)] = depth
  for i, j in permutations([0, 1, 2], 2):
    # A, B, C 중 이동하는 두 개를 선택
    if (abc[i] > 0) or (abc[j] < max_abc[j]):
      next_abc = abc.copy()
      move = min(abc[i], max_abc[j] - abc[j])
      next_abc[i] -= move
      next_abc[j] += move
      if search(next_abc, depth + 1, max_abc, log):
        return True 
  return False

cnt = 0
for a in range(10, 100 + 1, 2):
  for c in range(1, a // 2):
    b = a - c
    if gcd(b, c) == 1: # 서로소인 경우는 최대공약수 = 1
      if search([a, 0, 0], 0, [a, b, c], {}):
        cnt += 1 

print(cnt)