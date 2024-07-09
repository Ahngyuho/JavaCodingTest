import re
from itertools import permutations
from collections import OrderedDict

count = 0
for (e, a, d, t, k, l) in permutations(range(0, 10), 6):
  if ((a + t == 8) or (a + t == 9) or (a + t == 10)) and\
     ((a + e == 8) or (a + e == 9) or (a + e == 10)) and\
     ((d + e + k) % 10 == l) and\
     (((a + t + l) * 10 + d + e + k) % 100 == l * 11):
    temp = [list(range(0, 10)) for item in x if item not in [k, e, d, l, t, a]]
    for (i, r, s, w) in permutations(temp, 4):
      if ((r != 0) and (w != 0) and (t != 0)) and\
         ((s == w + 1) or (s == w + 2)):
        read = r * 1000 + e * 100 + a * 10 + d
        write = w * 10000 + r * 1000 + i * 100 + t * 10 + e
        talk = t * 1000 + a * 100 + l * 10 + k
        skill = s * 10000 + k * 1000 + i * 100 + l * 10 + l
        if read + write + talk == skill:
          print("{} + {} + {} = {}".format(read, write, talk, skill))
          count += 1

print(count)


expression = "READ+WRITE+TALK==SKILL"
nums = re.split(r"[^a-zA-Z]", expression)
# 순서 있게 중복을 제거해야 하므로 
chars = list(OrderedDict.fromkeys(list("".join(nums))))

nums = filter(None, nums)
head = map(lambda num: num[0], nums)

count = 0

  is_zero_first = False
  if 0 in seq:
    is_zero_first = chars[seq.index(0)] in head
  if not is_zero_first:
    # 변환 처리 : translate() 함수 사용
    e = expression.translate(str.maketrans("".join(chars), "".join(map(str, seq))))
    # 0으로 시작하는 숫자 제거
    e = re.sub(r"0(\d+)", r"\1", e)
    if eval(e):
      print(e)
      count += 1

print(count)