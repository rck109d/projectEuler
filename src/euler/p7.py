import math


def findNthPrime(n):
    primes = {}
    primes[1] = 2
    candidate = 3
    for which in range(2, n + 1, 1):
        invalid = True
        while invalid:
            invalid = False
            candidateSqrt = math.sqrt(candidate)
            for check in range(1, which, 1):
                if primes[check] > candidateSqrt:
                    break
                if candidate % primes[check] == 0:
                    invalid = True
                    break
            if not (invalid):
                primes[which] = candidate
            candidate += 2
    return primes[n]


print(findNthPrime(10001))
