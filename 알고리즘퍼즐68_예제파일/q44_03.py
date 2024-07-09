def count_swap(n):
  if n == 1:
    return 0 
  multi = 1
  for i in range(1, n):
    multi *= i
  return (n - 1) * multi + n * count_swap(n - 1)

print(count_swap(7))