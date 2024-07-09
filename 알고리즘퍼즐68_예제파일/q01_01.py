# 11부터 탐색 개시
num = 11

while True:
  # 진법에 따른 변수를 선언합니다.
  num_10 = str(num)
  num_8 = oct(num).replace("0o", "")
  num_2 = bin(num).replace("0b", "")

  # 앞뒤가 같은지 확인합니다.
  if num_10 == num_10[::-1]\
    and num_8 == num_8[::-1]\
    and num_2 == num_2[::-1]:
    print(num)
    break

  # 홀수만 탐색하므로 2씩 늘림
  num += 2