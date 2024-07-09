# 0~9를 나타내는 비트를 정의
bit = [0b1111110, 0b0110000, 0b1101101, 0b1111001, 0b0110011,
      0b1011011, 0b1011111, 0b1110000, 0b1111111, 0b1111011]

# 배타적 논리합의 결과를 먼저 산출
flip = [None] * 10
for i in range(0, 10):
  flip[i] = [None] * 10
  for j in range(0, 10):
    flip[i][j] = "{:b}".format(bit[i]^bit[j]).count("1")

# 매번 모든 비트를 반전시킨 값을 초깃값으로 한다
min_value = 63

# 재귀적으로 탐색한다
# is_used : 각 숫자가 사용 완료되었는지 아닌지
# sum : 사용한 숫자에서의 반전 수
# prev : 앞에서 사용한 숫자
def search(is_used, sum_value, prev):
  global min_value
  if is_used.count(False) == 0:
    min_value = sum_value
  else:
    for i in range(0, 10):
      if not is_used[i]:
        is_used[i] = True
        next_sum = 0
        if prev >= 0:
          next_sum = sum_value + flip[prev][i] 
        if min_value > next_sum:
          search(is_used, next_sum, i) 
        is_used[i] = False

search([False] * 10, 0, -1)
print(min_value)