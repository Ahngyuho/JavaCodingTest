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
fw = [start]
fw_log = [start]
bw = [goal]
bw_log = [goal]
cnt = 0

# �ֹ��⿡���� �ʺ� �켱 Ž���� ����
while True:
  next_fw = throwable(fw)      # ���������� ���� ������ ���
  # ���ſ� ��Ÿ���� ���� ���� ����
  fw = [f for f in next_fw if f not in fw_log]
  fw_log.append(next_fw)       # ���� ����� �߰�
  cnt += 1
  if len([f for f in fw if f in bw]) > 0:
    break  # ��ġ�� ����

  next_bw = throwable(bw)      # ���������� ���� ������ ���
  # ���ſ� ��Ÿ���� ���� ���� ����
  bw = [b for b in next_bw if b not in bw_log]
  bw_log.append(next_bw)       # ���� ����� �߰�
  cnt += 1
  if len([f for f in fw if f in bw]) > 0:
    break  # ��ġ�� ����

print(cnt)
