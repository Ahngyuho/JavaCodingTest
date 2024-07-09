# 루프하고 있는지 확인
def is_loop(n)
  # 맨 처음에는 3을 곱하고 1을 더함
  check = n * 3 + 1
  # 1이 될 때까지 숫자를 변화시키는 작업 반복
  while check != 1:
    check = check/2 check % 2 == 1 else check * 3 + 1
    if check == n:
    return True
  return False

# 2~10,000 범위의 짝수 확인하기
cnt = 0
for i in range(2, 10000 + 1, 2):
  if is_loop(i):
    cnt += 1
print(cnt)