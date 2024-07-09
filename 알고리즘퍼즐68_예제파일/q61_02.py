from datetime import datetime
from calendar import monthrange
from itertools import product

WEEKS, DAYS = 6, 7

# 휴일 파일 읽어오기
with open("q61.txt", "r") as f:
  holiday = [tuple(map(int, l.split("/"))) for l in f]

# 달력을 채우는 최대 직사각형의 면적을 산출
def max_rectangle(cal):
  s = 0
  for row in range(WEEKS):
    for left in range(DAYS):
      for right in range(left, DAYS):
        # 높이를 산출
        h = [cal[w + row * DAYS] for w in range(left, right + 1)]
        # 높이의 최솟값과 가로 폭으로 면적을 산출
        s = max(s, min(h) * (right - left + 1))
  return s

# 연월을 지정하고 면적을 얻는다
def calc(y, m):
  cal = [0] * (WEEKS * DAYS)
  first = wday = datetime(y, m, 1).weekday()
  for d in range(monthrange(y, m)[1]):  
    if 0 <= wday and wday <= 4 and (y, m, d + 1) not in holiday:
      cal[first + d] = cal[first + d - DAYS] + 1
    wday = (wday + 1) % DAYS
  return max_rectangle(cal)

yyyymm = product(range(2006, 2015 + 1), range(1, 12 + 1))
answer = sum([calc(y, m) for y, m in yyyymm])
print(answer)