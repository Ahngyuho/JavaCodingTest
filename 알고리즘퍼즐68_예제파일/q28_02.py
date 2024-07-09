club = [[11000, 40], [8000, 30], [400, 24], [800, 20], [900, 14],
        [1800, 16], [1000, 15], [7000,40], [100, 10], [300, 12]]
N = 150

area = [None] * (len(club) + 1)
for i in range(0, len(area)):
  area[i] = [0] * (N + 1)

for i in range(len(club) - 1, -1, -1):
  for j in range(0, N + 1):
    if j < club[i][1]:
      area[i][j] = area[i + 1][j]
    else:
      area[i][j] = max([area[i + 1][j],\
                    area[i + 1][j - club[i][1]] + club[i][0]])

print(area[0][N])
