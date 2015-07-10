a, b = 0, 1
s = 0

while a < 4000000:
    a = a + b
    b = b + a
    if a % 2 == 0:
        s = s + a
    if b % 2 == 0:
        s = s + b
print(s)
