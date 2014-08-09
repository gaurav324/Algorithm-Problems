# Given a file having distance of stars from earth. Find the closest K stars.

import functools
import math
import Queue

@functools.total_ordering
class star(object):
    def __init__(self, id, x, y, z):
        self.idd = id
        self.distance = math.sqrt(x*x + y*y + z*z)

    def __lt__(self, other):
        return self.distance > other.distance

    def __eq__(self, other):
        return self.distance == other.distance

def main(k):
    with open("stars.txt", 'r') as f:
        q = Queue.PriorityQueue(k)
        for line in f:
            idd, x, y, z = line.strip().split(" ")
            s = star(idd, int(x), int(y), int(z))
            if not q.full():
                q.put(s)
            else:
                top = q.get()
                if top.distance > s.distance:
                    top = s
                q.put(top)
    while not q.empty():
        ele = q.get()
        print ele.idd, ele.distance

main(5)
