

Misère Nim

[Original Question](https://www.hackerrank.com/challenges/misere-nim-1)

```
10
90
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
32
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
31
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
100
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
24
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
69
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
64
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
10
1 1 1 1 1 1 1 1 1 1
32
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1
1

```
answer
```
First
First
Second
First
First
Second
First
First
First
Second
```

```cpp
//https://www.hackerrank.com/challenges/misere-nim-1
//#include <bits/stdc++.h>
#include <iostream>
using namespace std;

#define FOR(i,n) for(long i = 0; i < (n); ++i)

typedef long long ll;
typedef unsigned long long ull;


int main()
{
	long T,n;
	cin >> T;
	while (T-->0)
	{
		long res=0,cnt=0,x;
		cin >> n;

		FOR(i,n){
			cin >> x;
			if (x==1) ++cnt;
			//cout << res << " " << x << "=";
			res^=x;
			//cout << res << endl;
		}

		if (cnt==n) puts((cnt&1)?"Second":"First");
		else puts((res>0)?"First":"Second");

	}
}

```
