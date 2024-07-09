# 고정적인 형태의 진법 변환 함수
def conv(number, base):
  T = "0123456789ABCDEF"
  i, j = divmod(number,base)
  if i == 0:
    return T[j]
  else:
    return conv(i,base) + T[j]
 
# 다음 눈을 취득한다
def next_dice(dice):
  right = dice.slice(0, int(dice[0]))
  right = str(right).translate(str.maketrans('123456', '654321'))
  dice += right
  return dice

count = 0
for i in range(0, 6 ** 6):
  # 6진수로 표현하여 ‘111111’을 더함으로써 1~6이 된다
  dice = str(int(conv(i, 6)) + 111111)
  check = {}
  j = 0
  # 루프할 때까지 다음의 주사위를 찾는다
  while dice in check:
    check[dice] = j
    dice = next_dice(dice)
    j += 1
  # 루프한 위치를 확인하고 루프 대상이 아니라면 카운트
  if dice in check and check[dice] > 0:
    count += 1 

print(count)