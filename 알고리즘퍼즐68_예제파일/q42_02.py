from math import gcd

cnt = 0
for a in range(10, 100 + 1, 2):
  for c in range(1, a // 2):
    b = a - c
    if gcd(b, c) == 1:
      cnt += 1 

print(cnt)