from itertools import permutations

# 0~9를 나타내는 비트를 정의
bit = [0b1111110, 0b0110000, 0b1101101, 0b1111001, 0b0110011,
      0b1011011, 0b1011111, 0b1110000, 0b1111111, 0b1111011]

# 매번 모든 비트를 반전시킨 값을 초깃값으로 한다
min_value = 63
# 0~9의 순열에 대해 보다 전환 횟수가 적은 것을 탐색한다
for seq in permutations(range(0, 9 + 1)):
  sum_value = 0
  for j in range(0, len(seq) - 1):
    # 배타적 논리합을 계산하고, 1이 있는 비트 수를 카운트
    sum_value += "{:b}".format(bit[seq[j]]^bit[seq[j+1]]).count("1")
    if min_value <= sum_value:
      break 
  if min_value > sum_value:
    min_value = sum_value 

print(min_value)