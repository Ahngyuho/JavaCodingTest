import sys
sys.setrecursionlimit(4000)

N = 5
MASK = (1 << (N * N)) - 1
move = [lambda m: (m >> 1) & 0b0111101111011110111101111,
        lambda m: (m << N) & MASK,
        lambda m: (m << 1) & 0b1111011110111101111011110,
        lambda m: m >> N]

def enable(maze):
  man = (1 << (N * N - 1)) & (MASK - maze)
  while True:
    next_man = man
    for m in move:
      next_man |= m(man)   
    next_man &= (MASK - maze)     
    if next_man & 1 == 1:         
      return True 
    if man == next_man:
      break 
    man = next_man
  return False

def search(maze, p1, d1, p2, d2, turn):
  if turn:
    if p1 == p2:
      return True 
    if (p1 == 1) or (p2 == 1 << (N * N - 1)):
      return False 
  for i in range(0, len(move)):
    d = (d1 - 1 + i) % len(move)
    if move[d](p1) & (MASK - maze) > 0:
      return search(maze, p2, d2, move[d](p1), d, not turn)
  return False

cnt = 0
for maze in range(0, 1 << N * N):
  if enable(maze):
    man_a, man_b = 1 << (N * N - 1), 1
    if search(maze, man_a, 3, man_b, 1, True):
      cnt += 1 
print(cnt)