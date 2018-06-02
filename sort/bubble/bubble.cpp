#include <iostream>
#include <vector>

/***
input/output
3
3 2 1
--------------
Array is sorted in 3 swaps.
First Element: 1
Last Element: 3
***/

using namespace std;

class MySort {
    public:
    int firstElement, lastElement, numSwaps;
    
    void bubbleSort(vector<int> &arr) {
        numSwaps = 0;
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = 0; j < arr.size()-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr[j], arr[j+1]);
                    numSwaps++;
                }
            }
        }
        firstElement = arr[0];
        lastElement = arr[arr.size()-1];
    }
};

int main(){
    int n;
    cin >> n;
    vector<int> a(n);
    for(int a_i = 0;a_i < n;a_i++){
       cin >> a[a_i];
    }
    
    MySort *mySort = new MySort;
    mySort->bubbleSort(a);
    
    printf("Array is sorted in %d swaps.\n", mySort->numSwaps);
    printf("First Element: %d\n", mySort->firstElement);
    printf("Last Element: %d\n", mySort->lastElement);
    
    return 0;
}
