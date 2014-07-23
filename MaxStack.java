/*
 * Write a stack which supports Max operation in O(1) time and O(n) space.
 *
 */

class MaxStack {
    public static int MAX_CAPACITY = 10;

    int[] arr;
    int[] max;
    int index;

    MaxStack() {
        arr = new int[MAX_CAPACITY];
        max = new int[MAX_CAPACITY];
        index = 0;
    }

    void push(int v) throws Exception {
        if (index >= MAX_CAPACITY) {
            throw new Exception("SizeOveFlow");
        } else {
            arr[index] = v;
            max[index] = index > 0 ? Math.max(max[index - 1], v) : v;
            index += 1;
        }
    }

    int max() throws Exception {
        if (index > 0) { return max[index - 1]; }
        else { throw new Exception("NotEnoughElements"); }
    }

    int pop() throws Exception {
        if (index == 0) {
            throw new Exception("NotEnoughElements");
        }

        return arr[--index];
    }

    public static void main(String[] args) {
        MaxStack ms = new MaxStack();
        
            try {
            ms.push(10);
            ms.push(13);
            ms.push(12);
            ms.push(26);
    
            System.out.println("Max is: " + ms.max());
            System.out.println("Popped: " + ms.pop());
            System.out.println("Max is: " + ms.max());
            System.out.println("Popped: " + ms.pop());
            System.out.println("Max is: " + ms.max());
            System.out.println("Popped: " + ms.pop());
            System.out.println("Max is: " + ms.max());
            System.out.println("Popped: " + ms.pop());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
