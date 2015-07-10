def works(num):
    for p in range(2, 20, 1):
        if num % p != 0:
            return False
    return True


s = 1
for p in range(1, 20, 1):
    s *= p
print(s)
for p in range(2, 20, 1):
    while works(s / p):
        print('div', p)
        s /= p
print(s)
