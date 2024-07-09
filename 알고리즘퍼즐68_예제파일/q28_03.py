club = [[11000, 40], [8000, 30], [400, 24], [800, 20], [900, 14],
        [1800, 16], [1000, 15], [7000,40], [100, 10], [300, 12]]

memo = {}
def search(club, remain):
  key = str([club, remain])
  if key in memo:
    return memo[key] 
  max_value = 0
  for c in club:
    # 동아리를 추가하는 부원 수의 여유가 있는 경우
    if remain - c[1] >= 0:
      next_club = club.copy()
      next_club.remove(c)
      max_value = max([c[0] + search(next_club, remain - c[1]), max_value])
  memo[key] = max_value
  return max_value

print(search(club, 150))
