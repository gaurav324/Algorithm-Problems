/**
 * Given an sorted array, find the first instance of the element K.
 */

public class SearchFirstInstance {
    public static void search(int[] numbers, int n) {
        int l = 0;
        int r = numbers.length - 1;
        int m = (l + r) / 2;
        
        boolean found = false;
        while(l <= r) {
            if (numbers[m] == n) {
                found = true;
                while(m > 0 && numbers[m] == n) {
                    --m;
                }
                ++m;
                break;
            } else if (numbers[m] > n) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            m = (l + r) / 2;
        }
        System.out.println(n + " found at " + m);
    }

    public static void main(String[] args) {
        int[] numbers = {-1, 1, 2, 2, 3, 3, 3, 4, 6, 7, 7, 9};
        SearchFirstInstance.search(numbers, 2);
        SearchFirstInstance.search(numbers, 3);
        SearchFirstInstance.search(numbers, 6);
        SearchFirstInstance.search(numbers, 7);
    }

}
