from datetime import datetime
from calendar import monthrange
from itertools import product

WEEKS, DAYS = 6, 7

# 휴일 파일 읽어오기
with open("q61.txt", "r") as f:
  holiday = [tuple(map(int, l.split("/"))) for l in f]

# 달력을 채우는 최대 직사각형의 면적을 산출
def max_rectangle(cal):
  rect = 0
  for sr in range(WEEKS):               # 시작점의 행
    for sc in range(DAYS):              # 시작점의 열
      for er in range(sr, WEEKS + 1):   # 끝점의 행
        for ec in range(sc, DAYS + 1):  # 끝점의 열
          is_weekday = True  # 시작점과 끝점의 내부에 평일 이외의 날이 있는지?
          for r in range(sr, er + 1):
            for c in range(sc, ec + 1):
              temp = c + r * DAYS
              if temp < (WEEKS * DAYS) and cal[temp] == 0:
                is_weekday = False
          if is_weekday:
            rect = max(rect, (er - sr + 1) * (ec - sc + 1))
  return rect

# 연월을 지정하고 면적을 얻는다
def calc(y, m):
  cal = [0] * (WEEKS * DAYS)
  first = wday = datetime(y, m, 1).weekday()  # 1일의 요일을 취득
  
  # monthrange()는 (<첫 날의 요일>, <날짜 수>) 형태의 튜플을 리턴합니다.
  # 그 월의 일 수만큼 반복
  for d in range(monthrange(y, m)[1]):  
    # 파이썬은 월요일(0)~일요일(6)으로 나타냅니다.
    # 다른 언어와 크게 다른 부분이므로 주의해주세요.
    if 0 <= wday and wday <= 4 and (y, m, d + 1) not in holiday:
      cal[first + d] = 1
    wday = (wday + 1) % DAYS
  return max_rectangle(cal)

yyyymm = product(range(2006, 2015 + 1), range(1, 12 + 1))
answer = sum([calc(y, m) for y, m in yyyymm])
print(answer)