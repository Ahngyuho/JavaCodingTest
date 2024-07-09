from itertools import combinations
from math import gcd
 
MAX = 500
cnt = 0
for c in range(1, MAX // 4 + 1):      # 정사각형의 한 변
  for a, b in combinations(range(1, c), 2):
    if a * a + b * b == c * c:
      if gcd(a, b) == 1: 
        cnt += 1
 
print(cnt)

