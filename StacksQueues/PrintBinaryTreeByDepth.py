# Print a tree in the increasing order of its depth.

import Queue

class Node(object):
    def __init__(self, n):
        self.n = n
        self.left = None
        self.right = None

def printOrder(n):
    q = Queue.Queue()
    q.put(n)

    i1 = 0
    i2 = 1
    while (not q.empty()):
        d = i2 - i1
        i1 = i2
        printList = []
        while(d != 0):
            ele = q.get()
            printList.append(str(ele.n))
            if ele.left != None:
                q.put(ele.left)
                i2 += 1
            if ele.right != None:
                q.put(ele.right)
                i2 += 1
            d -= 1
        print " ".join(printList)

def main():
    n1 = Node(1)
    n2 = Node(2)
    n3 = Node(3)
    n4 = Node(4)
    n5 = Node(5)
    n6 = Node(6)
    n7 = Node(7)
    n1.left = n2
    n1.right = n3

    n2.left = n4

    n3.right = n5

    n5.left = n6
    n5.right = n7

    printOrder(n1)

main()
