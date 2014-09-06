#include<iostream>

using namespace std;
int main()  {

    int arr[1000];

    for(int i=0;i<1000;++i) {arr[i] = 0;}

    long total = 5;
    arr[1] = 1; arr[4] = 1;

    int min_index = 1;
    long n = 2;

    while (n != 1000000000) {
        total += 5 + min_index;
        
        arr[min_index] -= 1;
        arr[min_index + 1] += 1;
        arr[min_index + 4] += 1;

        while(arr[min_index] == 0) {
            min_index += 1;
        }

        n += 1;
    }

    cout << total << endl;
}
