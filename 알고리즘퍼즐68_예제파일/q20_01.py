from itertools import combinations

# 마방진을 배열로 설정
magic_square = [1, 14, 14, 4, 11, 7, 6, 9,
                8, 10, 10, 5, 13, 2, 3, 15]

# 집계용 해시
memo = {}
for i in range(1, len(magic_square) + 1):
  # 조합 전체 탐색
  for comb in combinations(magic_square, i):
    # 조합 합계를 해시로 저장
    key = sum(comb)
    if key not in memo:
      memo[key] = 0
    memo[key] += 1
  

# 합계가 최대인 것을 출력
max_key = 0
max_value = 0
for key, value in memo.items():
  if max_value < value:
    max_key = key
    max_value = value
print(max_key, max_value)
