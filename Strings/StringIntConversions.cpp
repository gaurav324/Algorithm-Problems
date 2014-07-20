/**
 * Basic conversions from String to Int and vice versa. 
 * Looks simple but one has to be careful.
 */

#include <iostream>
#include <string>
#include <stdexcept>
#include <math.h>

using namespace std;

string intToString(int n) {
    int divisor = 0;
    while(n/(int)pow(10, ++divisor) != 0) {}

    if (n < 0) {++divisor;}

    char* ans = new char[divisor];
    if (n < 0) { ans[0] = '-'; n *= -1;}

    int mod = 10;
    do {
        ans[--divisor] = 48 + n % mod;
        n = n / 10;
    } while(n != 0);

    return string(ans);
}

int stringToInt(string s) {
    int result = 0;
    for (int i = s.length() - 1; i >= 0; --i) {
        if (i == 0 && s[i] == '-') {
            if (s.length() == 1) {
                throw invalid_argument(s);
            }
            result *= -1;
            continue;
        } 

        if ((s[i] - 48) > 9 || (s[i] - 48) < 0) {
            throw invalid_argument(s);
        } 
        result += (s[i] - 48) * pow(10, s.length() - i - 1);
    }
    return result;
}

int main() {
    cout << stringToInt("100") << endl;
    cout << stringToInt("1234560") << endl;
    cout << stringToInt("-35100") << endl;

    cout << intToString(100) << endl;
    cout << intToString(1234560) << endl;
    cout << intToString(-35100) << endl;
    return 0;
}
