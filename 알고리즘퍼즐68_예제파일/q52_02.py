N = 11
cards = [0] * N * 2 
count = 0

def search(cards, num):
  global count
  if num == 0:  #맨 마지막의 판정을0으로 변경
    count += 1
  else:
    for i in range(0, 2 * N - 1 - num):
      if cards[i] == 0 and cards[i + num + 1] == 0:
        cards[i], cards[i + num + 1] = num, num
        search(cards, num - 1)  # 큰 쪽부터이므로 줄임
        cards[i], cards[i + num + 1] = 0, 0

search(cards, N)  # 맨 처음은 최대의 카드를 배치
print(count)
