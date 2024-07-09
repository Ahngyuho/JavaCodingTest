def cutbar(m, n):
  count = 0
  current = 1 # current는 현재의 길이
  while n > current:
    current += current if current < m else m
    count += 1
  print(count)

cutbar(3, 20)
cutbar(5, 100)