primes = {}
primeSquareds = {}
primes[1] = 2
primeSquareds[1] = 4
numPrimes = 1
candidate = 3
total = 0
displayCheck = 0
while candidate < 2000000:
    good = True
    for i in range(2, numPrimes + 1):
        if candidate % primes[i] == 0:
            good = False
            break
        if primeSquareds[i] > candidate:
            break
    if good:
        numPrimes += 1
        primes[numPrimes] = candidate
        primeSquareds[numPrimes] = candidate * candidate
        total += candidate
        displayCheck += 1
        if displayCheck > 1000:
            displayCheck = 0
            print(candidate)
    candidate += 2
print(total)  # then add 2
