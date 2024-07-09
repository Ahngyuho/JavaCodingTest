N = 4

def search(rows):
  # 모든 행을 탐색하면 종료
  if len(rows) == N:
    return 1

  count = 0
  for row in range(0, 2 ** N):
    #네 모서리에○과×가 교대로 되어 있는지 확인
    cross = filter(lambda r: (row & ~r) > 0 and (~row & r) > 0, rows)
    cross = list(cross)
    if len(cross) == 0:
      count += search(rows + [row]) 
  return count

print(search([]))
