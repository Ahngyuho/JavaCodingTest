found = False

# 정수 나눗셈을 할 수 있게
# 나눗셈을 //로 지정했습니다.
op = ['+', '-', '*', '//', '']

def check(n, expr, num):
  global found
  if n == 0:
    if eval(expr) == 1234:
      print(expr)
      found = True
  else:
    for i in op:
      check(n - 1, "{}{}{}".format(expr, i, num), num)

length = 1
while not found:
  for num in range(1, 9 + 1):
    check(length, num, num)
  length += 1