/**
 * There are two important largest increasing sequence find type algorithm problems.
 *
 * 1. Longest increasing Subsequence. (Standard DP, like store in array and look it up)
 * 2. Largest sum contiguous subsequence. (Different styled DP, more about logic).
 */

class LargestIncreasing {

    public void increasingSubsequence(int[] arr) {
        /**
         * This one is simple DP problem, where at every step 
         * one woudld look back at all the entries and find
         * which one has the longest subsequence till now.
         */
        int[] result = new int[arr.length];
        int [] backp = new int[arr.length];
        for (int i=0; i < arr.length; ++i) {
            result[i] = 1;
            backp[i] = 0;
        }
    
        int max_length = 0;
        int end_index = 0;
        for (int i=1; i < arr.length; ++i) {
            for (int j=0; j < i; ++j) {
                if (arr[j] < arr[i] && result[j] + 1 > result[i]) {
                    result[i] = result[j] + 1;
                    backp[i] = j;
                    if (result[i] > max_length) {
                        max_length = result[i];
                        end_index = i;
                    }
                }
            }
        }

        while(max_length > 0) {
            System.out.println(arr[end_index]);
            end_index = backp[end_index];
            --max_length;
        }
    }
    
    public void sumContiguousSubsequence(int[] arr) {
        // Idea here is very smart. Any portion of array 
        // could be a part of subArray given that it has
        // some positive sum. The moment sum becomes
        // negative, there is no point in keep that
        // subarray in further computations.
        int maxSum = 0;
        boolean anyPositive = false;

        int sum = 0;
        int neg_max = -999999;
        for (int i=0; i < arr.length; ++i) {
            sum += arr[i];
            if (sum > maxSum) {
                anyPositive = true;
                maxSum = sum;
            } 
            if (sum < 0) {
               sum = 0;
            }
            
            // If number is negative and greater than min.
            if (arr[i] < 0 && arr[i] > neg_max) {
                neg_max = arr[i];
            }
 
        }
        
        if (anyPositive) {
            System.out.println("Max contiguous subsequence sum: " + maxSum);
        } else {
            System.out.println("Max contiguous subsequence sum: " + neg_max);
        }
    }

    public static void main(String[] args) {
        int arr1[] = {2, 3, -4, 5, -8, 16, 1, 5, -9, -2, 3, 4, 7, -9, 11, 12};
        
        LargestIncreasing inst = new LargestIncreasing();
        inst.increasingSubsequence(arr1);
        inst.sumContiguousSubsequence(arr1);

        int arr2[] = {-27, -5, -4, -7, -72, -8, -92, -13};
        inst.increasingSubsequence(arr2);
        inst.sumContiguousSubsequence(arr2);


    }
}
