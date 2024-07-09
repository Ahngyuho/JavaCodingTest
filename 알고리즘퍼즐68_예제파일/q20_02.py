# 마방진을 배열로 설정
magic_square = [1, 14, 14, 4, 11, 7, 6, 9,
                8, 10, 10, 5, 13, 2, 3, 15]
sum_all = sum(magic_square)

# 집계용 해시
ary = [0] * (sum_all + 1)

# 초깃값(아무것도 더하지 않을 때가 1개)
ary[0] = 1
for n in magic_square:
  # 큰 쪽부터 순서대로 가산
  for i in range(sum_all - n, -1, -1):
    ary[i + n] += ary[i]

# 합계가 최대인 것을 출력
print(ary.index(max(ary)))
