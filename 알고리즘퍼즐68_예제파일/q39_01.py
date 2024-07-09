ip = []

for i in range(0, 1 << 16):
  # 16비트의 수를 반전한다
  j = "{:016b}".format(i)[::-1]
  j = int(j, 2)

  # 10진수의 온점(.) 구분 문자열을 생성
  s = "{}.{}.{}.{}".format(i >> 8, i & 0xff, j >> 8, j & 0xff)
  # 10개의 숫자와 온점뿐인 경우, 배열에 추가
  if len(set(s)) == 11:
    ip.append(s)

print(len(ip))
print(ip)