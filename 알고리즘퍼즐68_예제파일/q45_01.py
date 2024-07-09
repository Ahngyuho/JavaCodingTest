from itertools import product

N = 4
count = {}

def search():
  # 각 행을 수치로 설정
  for rows in product(range(0, 2 ** N), repeat=N):
    # 각 열의 ○의 수를 카운트
    col_count = [0] * N
    for c in range(0, N):
      for r in rows:
        if r & (1 << c) > 0:
          col_count[c] += 1 
    #각 행의 ○의 수를 카운트
    row_count = list(map(lambda r: "{:b}".format(r).count("1") , rows))
    # 해시에 행과 열의 카운트로 집계
    key = tuple(row_count + col_count)
    if key not in count:
      count[key] = 0
    count[key] += 1

search()
# 한 가지로 배치할 수 있는 것을 출력
result = [k for k, v in count.items() if v == 1]
print(len(result))