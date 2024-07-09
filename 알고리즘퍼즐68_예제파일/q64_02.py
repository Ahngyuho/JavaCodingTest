# 패널의 수를 설정
W, H = 4, 3
row = [0] + [1] * (W - 1) + [0]
# edge = row + row.map{|r| 1 - r} * (H - 1) + row
edge = row + [1 - r for r in row] * (H - 1) + row

def search(panel, odds):
  # 맨 마지막의 패널을 설정했을 때에 홀수 점이 2개를 넘는가?
  if panel >= (W + 1) * H:
    return 0 if (sum(edge) > 2) else 1 
  # 도중에 홀수 점이 2개를 넘으면 한붓그리기 불가능
  if odds > 2:
    return 0 
  cnt = 0
  if panel % (W + 1) < W:   # 행의 오른쪽 끝 이외
    # 패널 내에 사선이 없는 경우를 탐색
    cnt += search(panel + 1, odds + edge[panel])
    # 패널의 왼쪽 위로부터 오른쪽 아래로의 선
    edge[panel] = 1 - edge[panel]
    edge[panel + W + 2] = 1 - edge[panel + W + 2]
    cnt += search(panel + 1, odds + edge[panel])
    # 패널을 교차하는 선
    edge[panel + 1] = 1 - edge[panel + 1]
    edge[panel + W + 1] = 1 - edge[panel + W + 1]
    cnt += search(panel + 1, odds + edge[panel])
    # 패널의 오른쪽 위로부터 왼쪽 아래로의 선
    edge[panel] = 1 - edge[panel]
    edge[panel + W + 2] = 1 - edge[panel + W + 2]
    cnt += search(panel + 1, odds + edge[panel])
    # 사선을 원래대로 되돌린다
    edge[panel + 1] = 1 - edge[panel + 1]
    edge[panel + W + 1] = 1 - edge[panel + W + 1]
  else:               # 행의 오른쪽 끝인 경우, 다음 행으로 
    cnt += search(panel + 1, odds + edge[panel])
  return cnt
  
print(search(0, 0))