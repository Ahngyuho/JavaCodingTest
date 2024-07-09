memo = {}
def cut_cake(w, h, diff):
  # 세로 쪽이 긴 경우는 가로 길이로 치환한다
  if w < h:
    w, h = h, w 
  # 메모에 존재하는 경우는 메모를 사용한다
  key = str([w, h, diff])
  if key in memo:
    return memo[key]
  # 맨 마지막까지 탐색한 경우, 차이가 1인 경우 이외에는 무한대로 한다
  if w == 1 and h == 1:
    temp = 0 if diff == 1 else float("inf")
    memo[key] = temp
    return temp

  # 가지치기(차이가 케이크의 반을 넘으면 무한대로 한다)
  if w * h // 2 < diff:
    return float("inf") 

  # 세로와 가로로 잘라본다
  sero = list(map(lambda i:
    h + cut_cake(w - i, h, i * h - diff)
  , list(range(1, (w // 2) + 1))))
  garo = list(map(lambda i:
    w + cut_cake(w, h - i, w * i - diff)
  , list(range(1, (h // 2) + 1))))

  # 세로와 가로로 자르는 방법 중, 최소인 것을 되돌려준다
  temp = min(sero + garo)
  memo[key] = temp
  return temp

print(cut_cake(16, 12, 0))

