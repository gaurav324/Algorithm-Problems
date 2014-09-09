/**
 * Peter and his friends are on holiday, so they have decided to make a trip by car to know the north of Spain. They are seven people and they think that two cars are enough for their luggage.
 
It’s time to leave… and a heap of suitcases are awaiting out of the cars. The drivers disagree about which suitcase must be put into each boot, because nobody wants one boot to carry more weight than the other one. Is it possible that the two boots load with the same weight? (Obviously without unpacking the suitcases!)
Consider m sets of numbers representing suitcases weights, you must decide for each one, if it is possible to distribute the suitcases into the boots, and the two boots weigh the same.

Input 

The first line of the input contains an integer, m, indicating the number of test cases. For each test case, there is a line containing n integers (1£  n £ 20) separated by single spaces. These integers are the weights of each suitcase. The total sum of the weights of all the suitcases is less or equal to 200 kilograms.
Output 

The output consists of m lines. The i-th line corresponds with the i-th set of suitcases weight and contains the string “YES” or “NO”, depending on the possibility that the two boots load with the same weight for the respective test case.
*/


#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;
int main() {
    string input_line;
    getline(cin, input_line);
    int cases;
    istringstream ss(input_line);
    ss >> cases;
    while(cases && getline(cin, input_line)) {
        cases -= 1;
        vector<int> v;
        std::istringstream ss(input_line);
        int ti;
        while(ss >> ti) 
            v.push_back(ti);
        
        int sum = 0;
        for (int e : v) { sum += e; }
        if (sum % 2 != 0) {
            cout << "NO" << endl;
            continue;
        }

        int half = sum / 2;
        int k[half + 1][v.size() + 1];
        for (int i=0; i <=half; ++i) {
            for (int j=0; j <= v.size(); ++j) {
                k[i][j] = 0;
            }
        }
        
        for (int j=1; j<=v.size(); ++j) {
            for (int w=1; w <= half; ++w) {
                k[w][j] = k[w][j-1];
                if (w - v[j-1] >= 0) {
                    k[w][j] = max(k[w][j], k[w-v[j-1]][j-1] + v[j-1]);
                }
            }
        }

        if (k[half][v.size()] == half) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }

    return 0;
}
