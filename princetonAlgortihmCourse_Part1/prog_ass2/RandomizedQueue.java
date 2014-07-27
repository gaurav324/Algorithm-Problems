/**
 * A randomized queue is similar to a stack or queue, except that the item 
 * removed is chosen uniformly at random from items in the data structure.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] arr;
    private int head = -1;
    private int tail = -1;
    private int N; // Total size of array.
    private Random rnd;

    public RandomizedQueue() {
        // construct an empty randomized queue 
        arr = (Item[]) new Object[1]; 
        N = 1;
        rnd = new Random();
    }

    public boolean isEmpty() {
        // is the queue empty?
        if (head == -1) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        // return the number of items on the queue
        if (this.isEmpty()) {
            return 0;
        } else {
            return tail - head + 1;
        }
    }

    public void enqueue(Item item) {
        // add the item
        if (item == null) {
            throw new NullPointerException("null pointer");
        }

        if (tail == N - 1) {
            Item[] new_arr = (Item[]) new Object[N * 2];
            for (int i=head; i<=tail; ++i) {
                new_arr[i] = arr[i];
            }
            arr = new_arr;
            new_arr = null;
            N = N * 2;

            tail = this.size() - 1;
            head = 0;
        }
        if (head == -1) {
            head += 1;
        }
        arr[++tail] = item;
    }

    public Item dequeue() {
        // delete and return a random item
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Empty");
        }

        int index = rnd.nextInt(this.size());
        Item temp = arr[head + index];
        arr[head + index] = arr[tail];
        arr[tail] = null;

        tail -= 1;
        if (tail + 1 == head) {
            head = -1;
            tail = -1;
            return temp;
        }

        if (this.size() < N/4) {
            Item[] new_arr = (Item[]) new Object[N / 2];
            for (int i=head; i<=tail; ++i) {
                new_arr[i] = arr[i];
            }
            arr = new_arr;
            new_arr = null;
            N = N / 2;
            tail = size() - 1;
            head = 0;
        }
        
        return temp;
    }
    
    public Item sample() {
        // return (but do not delete) a random item
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Empty");
        }

        int index = rnd.nextInt(this.size());
        return arr[head + index];
    }

    private class RandomizedIterator<Item> implements Iterator<Item> {
        Item arr[];
        int index;
        Random rnd;

        RandomizedIterator(RandomizedQueue<Item> queue) {
            if (queue.size() == 0) {
                index = -1;
                return;
            }
            arr = (Item[]) new Object[queue.size()];
            for (int i=queue.head; i <= queue.tail; ++i) {
                arr[i - queue.head] = queue.arr[i];
            } 

            this.index = queue.size() - 1;
            rnd = new Random();
        }

       public boolean hasNext() {
            if (this.index == -1) {
                return false;
            } else {
                return true;
            }
        }

        public Item next() {
            if (!this.hasNext()) {
                throw new java.util.NoSuchElementException("No next");
            }
            int rIndex = rnd.nextInt(index + 1);
            Item temp = arr[rIndex];
            arr[rIndex] = arr[index];
            arr[index] = null;
            --index;
            return temp;
        }

        public void remove() {
            throw new UnsupportedOperationException("Not Supported");
        }
    }

    public Iterator<Item> iterator() {
        // Return an independent iterator over items in random order.
        return new RandomizedIterator<Item>(this); 
    }

    public static void main(String[] args) {
        // unit testing
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
    }
}
