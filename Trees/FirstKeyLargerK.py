#  Write a function which returns first key larger than K in a BST.

# Solution:- Keep a flag which determines whether a solution has been found till now.
#            That would make the solution very easy. Nothing special in this program.:

class node(object):
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def getSuccessor(n):
    if n is None:
        return None
    elif n.left is None:
        return n
    else:
        return getSuccessor(n.left)

flag = False
def firstKeyLargerK(n, v):
    global flag
    if n is None:
        return None
    if n.val == v:
        flag = True
        if n.right is None:
            return None
        else:
            return getSuccessor(n.right)
    elif v < n.val:
        ans = firstKeyLargerK(n.left, v)
        if flag and ans:
            return ans
        if flag: # and not ans
            return n
    elif v > n.val:
        ans = firstKeyLargerK(n.right, v)
        if flag and ans:
            return ans
        else:
            return None

def main():
    global flag
    n1 = node(19)
    n2 = node(7)
    n1.left = n2

    n3 = node(43)
    n1.right = n3

    n4 = node(3)
    n2.left = n4
    n5 = node(11)
    n2.right = n5

    n6 = node(23)
    n7 = node(47)
    n3.left = n6
    n3.right = n7

    n8 = node(2)
    n9 = node(5)
    n4.left = n8
    n4.right = n9

    n10 = node(17)
    n5.right = n10

    n11 = node(13)
    n10.left = n11

    n12 = node(37)
    n6.right = n12

    n13 = node(53)
    n7.right = n13

    n14 = node(29)
    n15 = node(41)

    n12.left = n14
    n12.right = n15

    n16 = node(31)
    n14.right = n16

    flag = False
    import sys
    x = firstKeyLargerK(n1, int(sys.argv[1]))
    if x is None:
        print "null"
    else:
        print x.val

main()
