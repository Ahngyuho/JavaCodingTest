def shuffle(card):
  left = card[:len(card)//2]
  right = card[len(card)//2:]
  result = []
  for i in range(0, len(left)):
    result.append(left[i])
    result.append(right[i])
  return result

count = 0

for n in range(1, 100 + 1):
  init = list(range(1, 2 * n + 1))
  card = init.copy()
  for i in range(0, 2 * (n - 1)):
    card = shuffle(card)
  if card == init:
    count += 1 

print(count)