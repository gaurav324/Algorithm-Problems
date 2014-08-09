# Find the largest interger whose square is less than or equal to K.

def main(k):
    l = 0;
    r = k

    while(True):
        m = l + ((r - l) >> 1);
        if m == l:
            break
        sqr = m * m
        if sqr < k:
            l = m
        elif sqr > k:
            r = m
        else:
            return m
    return m

import sys
print main(int(sys.argv[1]))
