from itertools import permutations

count = 0
for ary in permutations(range(1, 7 + 1)):
  ary = list(ary)
  for i in range(0, len(ary)):
    j = ary.index(i + 1)
    if i != j:
      ary[i], ary[j] = ary[j], ary[i]
      count += 1
    
print(count)
