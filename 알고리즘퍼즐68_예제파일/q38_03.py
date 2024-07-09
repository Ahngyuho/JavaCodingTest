from itertools import permutations

N = 9
max_value = 0
max_list = {}

def solve(cards, init, depth):
  global max_value
  for i in range(1, len(cards)):
    if i + 1 == cards[i]:
      solve(list(reversed(cards[0:i+1])) + cards[i+1:N+1], init, depth + 1)
  if max_value < depth:
    max_value = depth
    max_list.clear()
  if max_value == depth:
    key = tuple(cards)
    max_list[key] = init

for i in permutations(range(2, N + 1)):
  i = list(i)
  solve([1] + i, [1] + i, 0)

print(max_value)
for key, value in max_list.items():
  print(key, value)