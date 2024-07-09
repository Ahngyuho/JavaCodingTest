# 다음 점을 취득한다
def next_dice(dice):
  top = dice // 6**5
  left, right = divmod(dice, 6**(5 - top))
  return (right + 1) * (6**(top + 1)) - (left + 1)

# 탐색한 값을 기록한다 (0:미 탐색, 1:루프 이외, 2:루프)
all_dice = [0] * (6 ** 6)
for i in range(0, 6 ** 6):
  if all_dice[i] == 0:
    check = []
    while (all_dice[i] == 0) and (i not in check):
      check.append(i)
      i = next_dice(i)
    
    try: # 루프했을 때 그 위치 이전은 루프 이외
      index = check.index(i)
      for j in range(0, len(check)):
        if j < index:
          all_dice[check[j]] = 1
        else:
          all_dice[check[j]] = 2
    except ValueError: # 이미 확인 완료된 값에 해당했을 때는 루프 이외
      for j in check:
        all_dice[j] = 1

print(len(all_dice))
print(all_dice.count(1))