# Compute pow(x, y) in O(n), where n is the number of bits in y.
import sys
x, y = float(sys.argv[1]), int(sys.argv[2])

if y < 0:
    x = 1/x
    y = -1 * y
misc = []
while (y > 1):
    if y % 2 != 0:
        misc.append(x)
    x = x * x
    y = y / 2

for y in misc:
    x = x * y

print x
