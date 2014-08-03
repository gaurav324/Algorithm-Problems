/*
 * This is not that neat solution, better look at LargestIncreasing.java in Arrays folder.
 */

#include<iostream>
#include<vector>

#define INT_MAX 999999

using namespace std;

int main() {
    vector<int64_t> sequence{5, 2, 8, 6, 3, 6, 9, 7, 8};

    vector<int64_t> len(sequence.size());
    vector<int64_t> prev(sequence.size());

    cout << "Initialize lengths to zero." << endl;
    for (int64_t i=0; i < sequence.size(); ++i) {
        len[i] = 1;
        prev[i] = -1;
    }

    cout << "Dynamic logic starts." << endl;
    for (int64_t i=0; i < sequence.size(); ++i) {
        for (int64_t j=0; j < i; ++j) {
            if (sequence[j] < sequence[i]) {
                if (len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    prev[i] = j;
                }
            }
        }
    }

    int64_t max_index;
    int64_t max_value = len[0];
    cout << "Find the max SubSequence Length." << endl;
    for (int64_t i=0; i < sequence.size(); ++i) {
        if (len[i] > max_value) {
            max_value = len[i];
            max_index = i;
        }
    }

    cout << "Print in correct order." << endl;
    int* l_seq = new int[max_value];
    l_seq[0]=sequence[max_index];
    int j=1;
    int i=max_index;
    while(prev[i] != -1) {
        l_seq[j] = sequence[prev[i]];
        ++j; i = prev[i];
    }

    for (int64_t i=max_value-1; i >= 0; --i) {
        cout << l_seq[i] << " ";
    }
    cout << endl;
}
