# Given two sorted arrays A and B, merge B into A.

def Merge(a, b):
    i1 = len(a) - 1 
    i2 = len(b) - 1
    
    a = a + [-1] * len(b)
    n = len(a) - 1
    while n >= 0:
        if i1 >= 0 and i2 >=0:
            if a[i1] > b[i2]:
                a[n] = a[i1]
                i1 -= 1
            else:
                a[n] = b[i2]
                i2 -= 1
        elif i1 >= 0:
            a[n] = a[i1]
            i1 -= 1
        else:
            a[n] = b[i2]
            i2 -= 1
        n -= 1 
    print a

def main():
    a = [2, 57, 4, 87, 96, 25, 97, 24, 66]
    b = [72, 5, 7, 6, 46, 86, 123, 539, 3]
    
    a = sorted(a)
    b = sorted(b)
    Merge(a, b)

main()
