# Music on the Street

[Original question](https://www.hackerrank.com/contests/w26/challenges/street-parade-1)

Test cases
```
#1)
2
1 3
7 2 3
=> -2

#2)
5
12 16 21 25 27
17 1 5 
=> 11
```

Explain
```
m (margin) = h -(last - first) 
h1 =1
h2 =5

m 
0 : X
1 : X
2 : 
3
4
5
6
7
8
9
10

```

```cpp
#include <iostream>
#include <algorithm>
#include <time.h>
using namespace std;

void solve(int n,long ar[],int h,int h1,int h2){

	long first = ar[0];
	long last = ar[n-1];

	long mid = last - first;
	long margin = h - mid;

	long start = 0;
	if((margin == h1+h1) || (margin <h1+h2)) {start = first - h1;}
	else {start = first -h2;}

	cout << start << endl;

}

int main() {
	int n1 = 5;
	long ar[n1] = {12, 16, 21, 25, 27};
	solve(n1,ar,17,1,5); // 11

	int n2 = 5;
	long ar2[n2] = {1,3};
	solve(n2,ar2,7,2,3); // -2

	int n3 = 3;
	long ar3[n3] = {1,3,5};
	solve(n3,ar3,6,1,4);    // 0      (margin=2)

	int n4 = 3;
	long ar4[n4] = {1,3,5};
	solve(n4,ar4,7,1,4);   // -1,0    (margin=3)

	int n5 = 3;
	long ar5[n5] = {1,3,5};
	solve(n5,ar5,8,1,4);  // -2,-1,0 (margin=4)

	int n6 = 3;
	long ar6[n6] = {1,3,5};
	solve(n6,ar6,9,1,4);  //-3,-2,-1,0 (margin=5)

	int n7 = 3;
	long ar7[n7] = {1,3,5};
	solve(n7,ar7,10,1,4);  //-3,-2,-1 (margin=6)

	int n8 = 3;
	long ar8[n8] = {-1,1,3};
	solve(n8,ar8,6,1,4);    // -2 (margin=2)

	return 0;
}


```

result
```
11
-2
0
0
0
-3
-3
-2

```
