from itertools import combinations

club = [[11000, 40], [8000, 30], [400, 24], [800, 20], [900, 14],
        [1800, 16], [1000, 15], [7000,40], [100, 10], [300, 12]]
N = 150

max_value = 0
# 선택하는 동아리 수를 순서대로 시험
for i in range(1, len(club) + 1):
  for ary in combinations(club, i):
    # 선택한 동아리로 부원 수의 합이 조건을 만족할 때
    sum_value_1 = sum(map(lambda x: x[1], ary))
    if sum_value_1 <= N:
      sum_value_2 = sum(map(lambda x: x[0], ary))
      max_value = max([sum_value_2, max_value])

print(max_value)
