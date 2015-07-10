number = 600851475143
divisor = 2
while (number > 1):
    if (0 == (number % divisor)):
        number /= divisor
        divisor -= 1
    divisor += 1
print(divisor)
