/**
 * We have to compute the parity of large number of 64bit non-negative intergers.
 * Parity is 1 for a sequence of bits, if the number of 1s in the sequence are odd, otherwise 0.
 */

#include <iostream>
#include <vector>

// Approach-1.
// Simply check all the bits and keep track of the parity. O(n), where n is number of bits. 
int64_t approach1(int64_t n) {
   int64_t parity = 0;
    while(n) {
        parity ^= n & 1;
        n >>= 1;
    }
    return parity;
}

// Approach two is very fast. Parity is computed very fast comparitively.
int64_t approach2(int64_t n) {
    n ^= n >> 32;
    n ^= n >> 16;
    n ^= n >> 8;
    n ^= n >> 4;
    n ^= n >> 2;
    n ^= n >> 1;

    return n & 1;
}

using namespace std;
int main() {
    vector<int> nos = {23, 54443, 64636, 63562, 747, 2432, 7467, 345435, 86382, 3462346, 23646, 7672, 88249, 8822, 9925733};
   
    for (int i=0; i < nos.size(); ++i) {
        cout << approach1(i) << " " << approach2(i) << endl;
    }
    return 0;
}
