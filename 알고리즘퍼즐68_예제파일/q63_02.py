# 4쌍
PAIR = 4

# 시작과 종료를 설정
start = list(range(1, PAIR * 2)) + [0]
goal = [0] + list(range(2, PAIR * 2)) + [1]

# 던질 수 있는 목록을 취득
def throwable(balls):
  result = []
  for ball in balls:
    c = ball.index(0)                     # 받는 쪽의 위치를 취득
    p = (c + PAIR) % (PAIR * 2)           # 받는 쪽의 정면을 계산
    for d in [-1, 0, 1]:                  # 정면과 좌우
      if (p + d) // PAIR == p // PAIR:
        ball[c], ball[p + d] = ball[p + d], ball[c]
        result.append(ball.copy())        # 던진 결과를 설정
        ball[c], ball[p + d] = ball[p + d], ball[c]
  return result

# 초기 상태를 설정
fw = [start]
fw_log = [start]
bw = [goal]
bw_log = [goal]
cnt = 0

# 쌍방향에서의 너비 우선 탐색을 실행
while True:
  next_fw = throwable(fw)      # 순방향으로 다음 스텝을 취득
  # 과거에 나타나지 않은 것을 선택
  fw = [f for f in next_fw if f not in fw_log]
  fw_log.append(next_fw)       # 던진 결과를 추가
  cnt += 1
  if len([f for f in fw if f in bw]) > 0:
    break  # 겹치면 종료

  next_bw = throwable(bw)      # 역방향으로 다음 스텝을 취득
  # 과거에 나타나지 않은 것을 선택
  bw = [b for b in next_bw if b not in bw_log]
  bw_log.append(next_bw)       # 던진 결과를 추가
  cnt += 1
  if len([f for f in fw if f in bw]) > 0:
    break  # 겹치면 종료

print(cnt)
