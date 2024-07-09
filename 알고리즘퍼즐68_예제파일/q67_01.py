from itertools import combinations

# 좌석에 1~30의 번호를 부여
seats = set(range(1, 30 + 1))

# 조건을 만족하지 않는 배치는 제외 대상
ng = list(map(set, [
  (1, 2, 7), (5, 6, 12), (19, 25, 26), (24, 29, 30),
  (1, 2, 3, 8), (2, 3, 4, 9), (3, 4, 5, 10),
  (4, 5, 6, 11), (1, 7, 8, 13), (7, 13, 14, 19),
  (13, 19, 20, 25), (6, 11, 12, 18), (12, 17, 18, 24),
  (18, 23, 24, 30), (20, 25, 26, 27), (21, 26, 27, 28),
  (22, 27, 28, 29), (23, 28, 29, 30),
  (2, 7, 8, 9, 14), (3, 8, 9, 10, 15), (4, 9, 10, 11, 16),
  (5, 10, 11, 12, 17), (8, 13, 14, 15, 20), (9, 14, 15, 16, 21),
  (10, 15, 16, 17, 22), (11, 16, 17, 18, 23),
  (14, 19, 20, 21, 26), (15, 20, 21, 22, 27),
  (16, 21, 22, 23, 28), (17, 22, 23, 24, 29)]))

cnt = 0
i = 0
for boy in combinations(seats, 15): # 남자의 배치 조합
  boy = set(boy)
  girl = seats - boy           # 여자의 배치 조합
  if len([n for n in ng if boy & n != n]) == len(ng) and \
    len([n for n in ng if girl & n != n]) == len(ng):
    cnt += 1
  if cnt != 0:
    print(cnt, i)
    exit()
  i += 1
print(cnt)