from itertools import combinations
 
MAX = 500
answer = []
for c in range(1, MAX // 4 + 1):      # 정사각형의 한 변
  edge = map(lambda x: x * (2 * c - x), range(1, c))
  for a, b in combinations(edge, 2):
    if a + b == c * c:
      answer.append([1, b / a, c * c / a])
 
# 중복 제거
print(len(list(map(tuple, answer)))) # 정수배 제외
