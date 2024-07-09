N = 16
def graycode(value):
  # N 진수를 각 자리의 배열로 분해
  digits = []
  while value > 0:
    digits.append(value % N)
    value //= N

  # 각 자리를 그레이 코드로 변환
  for i in range(0, len(digits) - 1):
    digits[i] = (digits[i] - digits[i + 1]) % N
  # 배열을 수치로 변환
  result = 0
  for i, d in enumerate(digits):
    result += d * (N**i)
  return result

# 맨 처음으로 되돌아올 때까지 탐색
def search(value):
  check = graycode(value)
  cnt = 1
  while check != value:
    check = graycode(check)
    cnt += 1
  return cnt

print(search(0x808080))
print(search(0xabcdef))
