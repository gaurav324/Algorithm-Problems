/**
 * Write a function that takes an array and an index i, such
 * that it rearranges elements in way that all less than
 * A[i] appear first, followed by equal to A[i], followed by
 * greater than A[i] in the end.
 *
 * DUTCH NATIONAL FLAG.
 **/ 
#include<iostream>
#define print(L) for (int x=0; x < L; ++x) { cout << a[x] << "\t"; } cout << "\n";

using namespace std;
void sort(int a[], int L, int i) {
    int pivot = a[i];

    int small = 0;
    int mid = 0;
    int large = L - 1;

    while(mid <= large) {
        if (a[mid] < pivot) {
            swap(a[mid], a[small]);
            mid += 1;
            small += 1;
        } else if (a[mid] == pivot) {
            mid += 1;
        } else {
            swap(a[large], a[mid]);
            large -= 1;
        }
    }

    print(L);
}

int main() {
    int a[] = {3, 6, 2, 6, 8, 7, 2, 1, 9, 6, 5, 2, 2, 7, 8, 3, 3, 8, 8, 1, 4};
    sort(a, 21, 5);
    sort(a, 21, 2);
    sort(a, 21, 6);
    return 0;
}
 

