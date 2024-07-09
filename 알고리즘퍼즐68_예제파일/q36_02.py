from itertools import permutations

# 0~9를 나타내는 비트를 정의
bit = [0b1111110, 0b0110000, 0b1101101, 0b1111001, 0b0110011,
      0b1011011, 0b1011111, 0b1110000, 0b1111111, 0b1111011]

# 배타적 논리합의 결과를 먼저 산출
flip = [None] * 10
for i in range(0, 10):
  flip[i] = [None] * 10
  for j in range(0, 10):
    flip[i][j] = "{:b}".format(bit[i]^bit[j]).count("1")

# 매번 전체 비트를 반전시킨 값을 초깃값으로 한다
min_value = 63
for seq in permutations(range(0, 10)):
  sum_value = 0
  for j in range(0, len(seq) - 1):
    # 저장해 둔 값을 취득
    sum_value += flip[seq[j]][seq[j+1]]
    if min_value <= sum_value:
      break 
  if sum_value < min_value:
    min_value = sum_value 
print(min_value)