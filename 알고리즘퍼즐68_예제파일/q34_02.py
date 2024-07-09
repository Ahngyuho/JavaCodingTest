n = range(1, 51) # 1~50까지를 요소로 갖는 범위
n = filter(lambda i: i % 2 > 0 or i % 5 > 0, n)
n = list(n) # 리스트로 변환

answer = []
k = 1

while len(n) > 0:
  x = int("{0:b}".format(k)) * 7
  for i in n:
    if x % i == 0:
      if str(x) == str(x)[::-1]:
        answer.append(i)
      n.remove(i)
  k += 1
  
answer.sort()
print(answer)