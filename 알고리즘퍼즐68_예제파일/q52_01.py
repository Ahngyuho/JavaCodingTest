N = 11
cards = [0] * N * 2 # 카드의 초깃값
count = 0

def search(cards, num):
  global count
  if num == N + 1:  # 맨 마지막까지 놓을 수 있으면 성공
    count += 1
  else:
    # 놓을 수 있는지를 확인하면서 순서대로 배치
    for i in range(0, 2 * N - 1 - num):
      if cards[i] == 0 and cards[i + num + 1] == 0:
        # 놓을 수 있는 경우는 카드를 배치하고 재귀적으로 탐색
        cards[i], cards[i + num + 1] = num, num
        search(cards, num + 1)
        cards[i], cards[i + num + 1] = 0, 0

search(cards, 1)  # 맨 처음은 ‘1’의 카드를 배치
print(count)
