# 카드의 초기화
N = 100
cards = [False] * N

# 2~N까지 뒤집음
for i in range(2, N + 1):
  j = i - 1
  while j < len(cards):
    cards[j] = not cards[j]
    j += i

#뒷면이 위를 향한 카드를 출력
for i in range(0, N):
  if not cards[i]:
    print(i + 1)
