from itertools import permutations

# a~f에 들어맞는 소수 6개
# 소수 6개 정도는 쉽게 예측할 수 있으므로 하드코딩 했습니다.
primes = [2, 3, 5, 7, 11, 13]
min_value = primes[-1] * primes[-1]  # 최대로 가장 큰 것의 제곱
min_friend = []
for prime in permutations(primes):  # 6개의 요소의 순열
  # 2개씩 선택하여 곱한다
  # friends = prime.each_cons(2).map{|x, y| x * y}
  friends = [prime[i]*prime[i+1] for i in range(len(prime) - 1)]
  # 맨 앞과 맨 끝은 같은 수의 제곱
  friends += [prime[0] ** 2, prime[-1] ** 2]
  if min_value > max(friends):    # 최소를 갱신한 경우
    min_value = max(friends)
    min_friend = friends
  
print(min_value)

min_friend.sort()
print(min_friend)