#include<iostream>
#include<vector>

using namespace std;

int main() {
    // Vector of weights and values of each sack.
    vector<int> w{6, 3, 4, 2};
    vector<int> v{30, 14, 16, 9};
    
    // Max weight allowed.
    int W = 10;
    
    // We have to compute K(W). 
    // That is the largest worth of goods and repetitions of the goods are permitted.
    vector<int> K;
    for (int i=0; i <= W; ++i) {
        K.push_back(0);
    }

    // All the magic happens here.
    for (int i=1; i <= W; ++i) {
        for (int j=0; j < w.size(); ++j) {
            if (i-w[j] >= 0) {
                K[i] = std::max(K[i-w[j]] + v[j], K[i]);
            }
        }
    }

    // Print it out.
    for (int i=0; i <=W; ++i)
        cout << K[i] << " ";
    cout << endl;
}
