def cutbar(m, n, current): # current는 현재 막대의 개수
  if current >= n:
    return 0 # 잘라내기 완료
  elif current < m:
    return 1 + cutbar(m, n, current * 2) # 다음은 현재의 2배가 된다
  else:
    return 1 + cutbar(m, n, current + m) # 가위 수만큼 추가

print(cutbar(3, 20, 1))
print(cutbar(5, 100, 1))