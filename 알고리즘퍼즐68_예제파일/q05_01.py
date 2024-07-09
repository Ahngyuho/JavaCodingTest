cnt = 0

for coin_500 in range(0, 2 + 1):
  for coin_100 in range(0, 10 + 1):
    for coin_50 in range(0, 15 + 1):
      for coin_10 in range(0, 15 + 1):
        if coin_500 + coin_100 + coin_50 + coin_10 <= 15:
          if coin_500 * 500 + coin_100 * 100 \
            + coin_50 * 50 + coin_10 * 10 == 1000:
            cnt += 1

print(cnt)
