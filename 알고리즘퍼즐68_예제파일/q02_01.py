import re

op = ["*", ""]
for i in range(1000, 10000):
  c = str(i)
  for j in range(0, len(op)):
    for k in range(0, len(op)):
      for l in range(0, len(op)):
        val = c[3] + op[j] + c[2] + op[k] + c[1] + op[l] + c[0]
        
        # 0으로 시작하는 숫자가 있는지 확인하고
        # 있는 경우 제거합니다.
        val = re.sub(r"0(\d+)", r"\1")

        # 연산자를 하나는 넣는 경우
        if len(val) > 4:
          print(val)
          if i == eval(val):
            print(val, "=", i)

for i in range(0, 100):
  print("")