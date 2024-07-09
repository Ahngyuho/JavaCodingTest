from itertools import combinations

val = []

for i in range(0, 256):
  # 0~255에서 반전
  rev = "{:08b}".format(i)[::-1]
  rev = int(rev, 2)
  if i < rev:
    s = str(i) + str(rev)
    # 0~9가 중복되지 않는 숫자라면 대상으로 한다
    if len(set(s)) == len(s):
      val.append([i, rev])
  
ip = []
for a, b in combinations(val, 2):
  # 0~9를 한 번씩 사용하고 있으면 짝으로 한다
  if len(set("".join(map(str, a + b)))) == 10:
    ip.append([a, b]) 

# 짝의 조합 수를 출력
print(len(ip) * 8)