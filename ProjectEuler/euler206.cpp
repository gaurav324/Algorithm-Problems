// STUPID SOLUTION

#include <iostream>
#include <math.h>

using namespace std;
int main() {

    for (long i1=0; i1<=9; ++i1)
    for (long i2=0; i2<=9; ++i2)
    for (long i3=0; i3<=9; ++i3)
    for (long i4=0; i4<=9; ++i4)
    for (long i5=0; i5<=9; ++i5)
    for (long i6=0; i6<=9; ++i6)
    for (long i7=0; i7<=9; ++i7)
    for (long i8=0; i8<=9; ++i8)
        {
        long long no =  i1 * 1000000000000000 + i2 * 10000000000000 +
            i3 * 100000000000 + i4 * 1000000000 + i5 * 10000000 + i6 * 100000 + i7 * 1000 + 
            i8 * 10 + 9 + 800 + 70000 + 6000000 + 500000000 + 40000000000 + 3000000000000 + 200000000000000 + 10000000000000000;
        double sq = sqrt(no);
        long sql = sq;

        if (sql * sql == no) {
            cout << no << " " << sq << " " << sql << endl;
            cout << sql << endl;
            return 0;
        }
        }
}
