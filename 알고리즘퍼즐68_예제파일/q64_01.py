# 패널의 수를 설정
W, H = 4, 3

# 비트 반전용 값
XOR_ROW = (1 << (W + 1)) - 1
# 행 단위로 탐색
def search(up, y, odds):
  # 위의 행까지 홀수의 수가 두 개보다 많은 경우는 대상 외
  if 2 < odds:
    return 0 
  row = 1 << W | 1    # 초깃값 설정
  # 맨 처음과 맨 마지막 행은 반전
  if (y == 0) or (y == H):
    row = XOR_ROW ^ row 

  # 맨 마지막 행인 경우는 확인하고 종료
  if y == H:
    odds += "{:b}".format(row ^ up).count("1")  # 홀수의 수를 카운트
    if (odds == 0) or (odds == 2):  
      return 1 # 0이나 2개라면 대상
    return 0
  
  cnt = 0
  for a in range(0, 1 << W):  # 패널의 내용（왼쪽 위로부터 오른쪽 아래의 직선 유무）
    for b in range(0, 1 << W):  # 패널의 내용（왼쪽 아래로부터 오른쪽 위의 직선 유무）
      cnt += search(a ^ b << 1, \
                    y + 1, \
                    odds + "{:b}".format(row ^ up ^ a << 1 ^ b).count("1"))
  return cnt

print(search(0, 0, 0))