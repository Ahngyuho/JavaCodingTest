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
  i = 0
  while True:
    card = shuffle(card)
    i += 1
    if card == init:
      break 
  if i == 2 * (n - 1):
    count += 1 

print(count)