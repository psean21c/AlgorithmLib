
[Original Question](https://www.hackerrank.com/contests/w27/challenges/zero-move-nim)


```cpp
#include <iostream>
#include <cstddef>
#include <vector>
using namespace std;

#define FOR(i,n) for(int i = 0; i < (n); ++i)
#define FOR1(i,n) for(int i = 1; i < (n); ++i)

typedef long long int llint;
typedef unsigned int uint;

long long int countOnes(unsigned long long int value) {
    int count;
    for (count = 0; value != 0; count++, value &= value-1);
    return count;
}

int main() {


	int g,n;
	cin >> g;

	FOR(i,g){
		cin >> n;

		vector<llint> arr(n);
		FOR(j,n) cin >> arr[j];


		llint p =arr[0];
		FOR1(j,n) p ^= arr[j];

		llint ones = countOnes(p);
		cout << "p=" << p << ", ones:" << ones << endl;
		string re;
		if(n ==1){
			re = "W";
		} else if(n ==2) {
			if(arr[0]==arr[1]) re = "L";
			else re = "W";
		} else if(n%2==0){
				if(ones%2 ==0) re ="L" ;
				else re ="W";
		} else {
				if(ones%2 ==0) re ="L" ;
				else re ="W";
		}
		cout << re << endl;
	}

	return 0;
}


```


```
4
3
1 2 3
3
1 1 1
10 
1073741824 966589325 682072281 600870280 957345769 791639467 1013267429 541537689 1014030873 875480275
10 
1073741824 966589325 682072281 600870280 957345769 791639467 1013267429 541537689 1014030873 996566795
=======================================================
W
W
W
L
```
