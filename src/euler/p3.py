def isPrime(num):
    if num <= 1:
        return False
    i = 2
    while i < num / 2 + 1:
        if num % i == 0:
            return False
        i += 1
    return True


big = 600851475143
test = 1
while test < big:
    test += 1
    if big % test == 0:
        print(test, ' divides evenly')
        div = big / test
        print('candidate ', div)
        if isPrime(div):
            print('found ', div)
            break
