sumsq = 0
for i in range(1, 101, 1):
    sumsq += i * i
s = 0
for i in range(1, 101, 1):
    s += i
sqsum = s * s
print(sqsum - sumsq)
