european = [0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, \
  11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, \
  22, 18, 29, 7, 28, 12, 35, 3, 26]
american = [0, 28, 9, 26, 30, 11, 7, 20, 32, 17, 5, 22, 34, 15, \
  3, 24, 36, 13, 1, 0, 27, 10, 25, 29, 12, 8, 19, 31, \
  18, 6, 21, 33, 16, 4, 23, 35, 14, 2]

def sum_max(roulette, n):
  ans = 0
  for i in range(0, len(roulette) + 1):
    tmp = 0
    if i + n <= len(roulette):
      # 배열의 양끝을 넘지 않는 경우
      tmp = sum(roulette[i:i + n + 1])
    else:
      # 배열의 양끝을 넘는 경우
      tmp = sum(roulette[0:((i + n) % len(roulette) + 1)])
      tmp += sum(roulette[i:-1])
    ans = max([ans, tmp])
  return ans

cnt = 0
for i in range(2, 36 + 1):
  if sum_max(european, i) < sum_max(american, i):
    cnt += 1
print(cnt)