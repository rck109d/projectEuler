def isPal(num):
    s = str(num)
    return (s == s[::-1])


low = 100
high = 999
m = 0

for a in range(high, low, -1):
    for b in range(high, low, -1):
        p = a * b
        if isPal(p):
            m = max(m, p)
print(m)
