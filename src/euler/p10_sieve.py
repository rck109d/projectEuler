big = 2000000                           # B = the number below which primes are summed
p = [True] * big                        # P = whether a number is prime, all are initially true and will later be falsified

print("running sieve...")
s = 0                                   # S = the sum of primes less than big which begins as 0
for a in range(2, big):                 # loop A over all divisors less than BIG
    if p[a]:                            # if A is prime
        s += a                          #     then add A to S
        for b in range(a * a, big, a):  #     loop over multiples of A from A*A (first relatively prime) less than BIG, inc. by A
            p[b] = False                #        the multiple isn't prime 

print(s)
