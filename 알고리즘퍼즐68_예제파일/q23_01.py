memo = {}

def game(coin, depth):
  key = (coin, depth)
  if key in memo:
    return memo[key]
  if coin == 0:
    return 0 
  if depth == 0:
    return 1 
  
  win = game(coin + 1, depth - 1)  # 이길 때
  lose = game(coin - 1, depth - 1) # 질 때
  
  memo[key] = win + lose
  return memo[key]

print(game(10, 24))
