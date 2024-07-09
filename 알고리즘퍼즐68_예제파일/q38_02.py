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
      list(reversed(cards[0:cards[0]])) + cards[cards[0]:N+1],
        init, depth + 1)

def pattern(used, unused, index):
  if len(unused) == 0:
    solve(used, used, 0)
  else:    
    for i in [i for i in unused if index + 1 != i]:
      temp = [j for j in unused if j != i]
      pattern(used + [i], temp, index + 1)

pattern([], list(range(1, N + 1)), 0)
print(max_value)
for key, value in max_list.items():
  print(key)