# 4��
PAIR = 4

# ���۰� ���Ḧ ����
start = list(range(1, PAIR * 2)) + [0]
goal = [0] + list(range(2, PAIR * 2)) + [1]

# ���� �� �ִ� ����� ���
def throwable(balls):
  result = []
  for ball in balls:
    c = ball.index(0)                     # �޴� ���� ��ġ�� ���
    p = (c + PAIR) % (PAIR * 2)           # �޴� ���� ������ ���
    for d in [-1, 0, 1]:                  # ����� �¿�
      if (p + d) // PAIR == p // PAIR:
        ball[c], ball[p + d] = ball[p + d], ball[c]
        result.append(ball.copy())        # ���� ����� ����
        ball[c], ball[p + d] = ball[p + d], ball[c]
  return result

# �ʱ� ���¸� ����
balls = [start]
log = [tuple(start)]
cnt = 0
#�ʺ� �켱 Ž���� ����
while goal not in balls:
  next_balls = throwable(balls)  # ���� �ܰ踦 ���
  # ���ſ� ��Ÿ���� ���� ���� ����
  balls = [b for b in next_balls if tuple(b) not in log]
  log.append(tuple(next_balls))         # ���� ����� �߰�
  cnt += 1

print(cnt)