# 반전할 마스크를 설정
mask = [None] * 16
for row in range(0, 4):
  for col in range(0, 4):
    mask[row * 4 + col] = (0b1111 << (row * 4)) | (0b1000100010001 << col)

max_value = 0
# 단계 수를 저장하는 배열
steps = [-1] * (1 << 16)
# 모두 백에서 시작
steps[0] = 0
# 조사 대상의 배열
scanner = [0]
while len(scanner) > 0:
  check = scanner.pop(0)
  next_steps = steps[check] + 1
  for i in range(0, 16):
    n = check ^ mask[i]
    # 확인하지 않은 경우, 다시 조사한다
    if steps[n] == -1:
      steps[n] = next_steps
      scanner.append(n)
      if max_value < next_steps:
        max_value = next_steps 
    
print(max_value) # 최대 단계 수
print("{:b}".format(steps.index(max_value))) # 초기 상태의 칸:모두 흑
print([i for i in steps if i == -1]) # 백이 되지 않는 초기 상태는 없음

