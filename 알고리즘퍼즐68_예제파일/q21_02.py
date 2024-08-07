count = 0     # ‘0’이 출현한 횟수
line = 1      # 현재의 행 수
row = 1       # 현재의 행의 값(비트열)

while count < 2014:
  row ^= row << 1   # 앞의 행에서 배타적 논리합으로 다음 행을 설정
  count += "{0:b}".format(row).count("0")    # ‘0’의 수를 카운트
  line += 1

print(line)         # 2,014개 카운트한 행을 출력
