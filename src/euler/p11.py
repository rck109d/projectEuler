import operator
import functools

with open('p11_data', 'r') as f:
    data = [[int(s) for s in x.split()] for x in f.readlines()]
f.closed
print(max([
              max([
                  functools.reduce(operator.mul, [data[y][x + z] for z in range(0, 4)]),
                  functools.reduce(operator.mul, [data[y + z][x + z] for z in range(0, 4)]),
                  functools.reduce(operator.mul, [data[y + z][x] for z in range(0, 4)]),
                  functools.reduce(operator.mul, [data[y + 3 - z][x + z] for z in range(0, 4)])
              ])
              for x in range(0, len(data[0]) - 3) for y in range(0, len(data) - 3)
              ])
      )
