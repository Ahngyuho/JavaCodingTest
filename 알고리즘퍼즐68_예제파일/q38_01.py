from itertools import permutations

N = 9
max_value = 0
max_list = {}

def solve(cards, init, depth):
  global max_value
  if cards[0] == 1:
    if max_value < depth:
      max_value = depth
      max_list.clear()
    if max_value == depth:
      key = tuple(init)
      max_list[key] = cards
  else:
    solve(
      list(reversed(cards[0:cards[0]]))
        + cards[cards[0]:N+1],
      init, depth + 1)

for i in permutations(range(1, N + 1)):
  i = list(i)
  solve(i, i, 0)

print(max_value)
for key, value in max_list.items():
  print(key)