/**
 * A double-ended queue or deque (pronounced "deck") is a generalization of a stack 
 * and a queue that supports inserting and removing items from either the front or 
 * the back of the data structure.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    
    private class Node<Item> {
        public Item it;
        public Node next;
        public Node prev;

        Node(Item i) {
            it = i;
            next = null;
        }
    }

    private class DequeIterator<Item> implements Iterator<Item> {
        Deque<Item> _queue;
        Node<Item> _ptr;

        DequeIterator(Deque<Item> queue) {
            this._queue = queue;
            this._ptr = queue.head;
        }

        public boolean hasNext() {
            if (_ptr == null) {
                return false;
            } else {
                return true;
            }
        }

        public Item next() {
            if (this.hasNext()) {
                Node<Item> result = _ptr;
                _ptr = _ptr.next;
                return result.it;
            } else {
                throw new java.util.NoSuchElementException("No next");
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Not Supported");
        }
    }

    private Node head;
    private Node tail;
    private int N = 0;

    public Deque() {
        head = null;
        tail = null;
    }
    
    public boolean isEmpty() {
        // is the deque empty?
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        // return the number of items on the deque
        return N;
    }

    public void addFirst(Item item) {
        // insert the item at the front
        if (item == null) {
            throw new NullPointerException("Null pointer.");
        }
        Node n = new Node(item);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        N += 1;
    }
    
    public void addLast(Item item) {
        // insert the item at the end
        if (item == null) {
            throw new NullPointerException("Null pointer.");
        }
        Node n = new Node(item);
        if (tail == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = tail.next;
        }
        N += 1;
    }

    public Item removeFirst() {
        // delete and return the item at the front
        if (head == null) {
            throw new java.util.NoSuchElementException("Empty");
        } else {
            Node<Item> temp = head;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            if (head == null) {
                tail = null;
            }
            N -= 1;
            return temp.it;
        }
    }

    public Item removeLast() {
        // delete and return the item at the end
        if (tail == null) {
            throw new java.util.NoSuchElementException("Empty");
        } else {
            Node<Item> temp = tail;
            if (tail.prev != null) {
                tail.prev.next = null;
            }
            tail = tail.prev;
            if (tail == null) {
                head = null;
            }
            N -= 1;
            return temp.it;
        }
    }

    public Iterator<Item> iterator() {
        // return an iterator over items in order from front to end
        return new DequeIterator<Item>(this);
    }

    public static void main(String[] args) {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(20);
        d.addFirst(10);
        d.addLast(30);

        System.out.println("Remove First: " + d.removeFirst());
        System.out.println("Remove Last: " + d.removeLast());
        System.out.println("Remove Last: " + d.removeLast());

        d.addLast(100);
        d.addLast(200);

        System.out.println("Remove First: " + d.removeFirst());
        System.out.println("Remove First: " + d.removeFirst());
    }
}
