n = 14
# 초기 상태의 사람 수를 설정(a, b, c의 사람 수 + 선생님이 전화한 횟수)
status = [[n, 0, 0, 0]]
step = 0 # 경과 시간

while len([s for s in status if s[1] == n]) == 0:
  # 연락이 불필요한 학생(b)이 전원이 될 때까지 다음을 반복한다
  next_status = []
  for s in status:
    for b in range(0, s[1] + 1):
      # 연락이 불필요한 학생이 다른 학생에게 연락하는 사람 수
      for c in range(0, s[2] + 1):
        # 연락이 필요한 학생이 연락하는 사람 수
        if s[2] > 0: # 발신할 수 있는 학생이 있을 때
          # 학생으로부터 선생님 있음
          if s[0]-b-c+1 >= 0:
            next_status.append([s[0]-b-c+1, s[1]+c, s[2]+b-1, s[3]+1])
        # 선생님 없음
        if s[0]-b-c >= 0:
          next_status.append([s[0]-b-c, s[1]+c, s[2]+b, s[3]])
        # 선생님으로부터 학생 있음
        if s[0]-b-c-1 >= 0:
          next_status.append([s[0]-b-c-1, s[1]+c+1, s[2]+b, s[3]+1])
  status = list(set(next_status) - set(status))
  print(status)
  step += 1
# 경과 시간을 표시
print(step)
# 최단인 것 중에서 선생님이 전화하는 횟수가 최소인 것을 표시
# print(status.select{|s| s[1] == n}.min{|a, b| a[3] <=> b[3]})