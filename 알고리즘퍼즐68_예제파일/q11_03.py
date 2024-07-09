memo = {}
def fib(n):
  if n in memo:
    return memo[n] 
  if (n == 0) or (n == 1):
    memo[n] = 1
  else:
    memo[n] = fib(n - 1) + fib(n - 2)
  return memo[n]


print(fib(5))