from itertools import combinations

N = 7
checked = {
  tuple(range(1, N + 1)): 0 # 확인 완료의 딕셔너리
}                         
check = [list(range(1, N + 1))] # 확인 대상
depth = 0                 # 교환 횟수
while len(check) > 0:     # 확인 대상이 존재하는 사이, 반복
  next_check = []
  for i, j in combinations(range(0, N), 2): # 2군데 선택하여 교환
    for c in check:
      d = c.copy()
      d[i], d[j] = d[j], d[i]
      key = tuple(d)
      if key not in checked:
        checked[key] = depth + 1
        next_check.append(d)
  check = next_check
  depth += 1

print(sum(checked.values()))