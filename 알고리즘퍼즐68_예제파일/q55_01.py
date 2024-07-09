from itertools import permutations

# 세로 선과 가로 선
v, h = 7, 10
total = 0

# ‘아래 수’의 위치에 대해, 교환할 필요가 있는 수를 카운트
for final in permutations(range(0, v)):
  cnt = 0
  for i in range(0, v):
    temp = []
    for j in final:
      temp.append(j)
      if j != i:
        break
    print(temp)  
    temp = [x for x in temp if x > i]
    cnt += len(temp)
  if cnt == h:
    total += 1 

print(total)