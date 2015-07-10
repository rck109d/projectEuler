d = {1: 1}


def getCollatzCount(num):
    if num <= 1:
        return 1
    elif num in d:
        return d[num]
    elif num % 2 == 0:
        proj = num / 2
        d[proj] = getCollatzCount(proj) + 1
        return d[proj]
    else:
        proj = 3 * num + 1
        d[proj] = getCollatzCount(proj) + 1
        return d[proj]


maxCount = 0
argMaxCount = 0
x = 0
while x < 1000000:
    x += 1
    count = getCollatzCount(x)
    if count > maxCount:
        maxCount = count
        argMaxCount = x
    if x % 10000 == 0:
        print(x, len(d))
print(argMaxCount, maxCount)
