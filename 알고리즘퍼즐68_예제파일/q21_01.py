count = 0     # ‘0’이 출현한 횟수
line = 1      # 현재의 행 수
row = [1]     # 현재의 행의 값

while count < 2014:
  next_row = [1]
  # 앞의 행에서 배타적 논리합으로 다음 행을 설정
  for i in range(0, len(row) - 1):
    cell = row[i] ^ row[i + 1]
    next_row.append(cell)
    if cell == 0:     # ‘0’인 경우에 카운트
      count += 1 
  next_row.append(1)
  line += 1           # 행 수를 늘려 다음의 행으로
  row = next_row

print(line)           # 2,014개 카운트한 행을 출력
