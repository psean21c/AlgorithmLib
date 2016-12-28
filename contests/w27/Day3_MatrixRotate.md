
### Day3

TestCase
```
# Case -1
>> input
4 3
90
180
270

>> output
10
6
10

# Case -2
>> input
1400 3
90
180
270

>> output
960000
1200000
960000

# Case -3
>> input
2000 3
90
180
270

>> output
1960244 
2449304 
1960244


```

패턴을 분석해서 무식한 계산을 최소화해도.. 배열 사용에 따른 최적화도 쉽지 않다.

```cpp
# Version-1
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

#define FOR(i,n) for(int i = 0; i < (n); ++i)
#define FOR1(i,n) for(int i = 1; i < (n); ++i)

int main() {
	int n;
	int q;
	cin >> n >> q;

	// 1) Initialize
	int m = n + 1;
	int ar[m][m] = { };
	FOR1(i,m){
		FOR1(j,m){
			int x = (i * j) % 7;
			if (x == 6 or x == 1 or x == 0) {
				ar[i][j] = 1;
			}
		}
	}

	// 2) Count for 90/180/270 degrees
	int cnt90, cnt180, cnt270;
	FOR1(i,m){
		FOR1(j,m){
			if (ar[i][j] != ar[m - j][i]) cnt90++;
			if (ar[i][j] != ar[m - i][m - j]) cnt180++;
			if (ar[i][j] != ar[m - i][j]) cnt270++;
		}
	}

	// 3) Handle the problems
	for (int i = 0; i < q; i++) {
		int angle;
		cin >> angle;
		int rotator = (angle / 90) % 4;
		int cnt = 0;
		if (rotator == 1) cnt = cnt90;
		else if (rotator == 2)	cnt = cnt180;
		else if (rotator == 3)	cnt = cnt270;
		else cnt = 0;

		cout << cnt << endl;
	}

	return 0;
}

```

```cpp
# Version-2
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <time.h>
using namespace std;

#define FOR(i,n) for(int i = 0; i < (n); ++i)
#define FOR1(i,n) for(int i = 1; i < (n); ++i)

int cnt90, cnt180;

int rotateCnt(int angle){

	int cnt;
	int rotator = (angle / 90) % 4;

	if (rotator == 1 or rotator == 3) cnt = cnt90;
	else if (rotator == 2)	cnt = cnt180;
	else cnt = 0;

	return cnt;

}
int main() {

	int n;
	int q;
	cin >> n >> q;

	// 1) Initialize
	bool ar[n][n] = {};

	FOR(i,n){
		FOR(j,n){
			int x = ((i+1) * (j+1)) % 7;
			if (x == 6 or x == 1 or x == 0) {
				ar[i][j] = 1;
			}
		}
	}

	// 2) Count for 90/180/270 degrees
	FOR(i,n){
		FOR(j,n){
			if (ar[i][j] != ar[n - j - 1][i]) cnt90++;
			if (ar[i][j] != ar[n - i - 1][n - j - 1]) cnt180++;
		}
	}

	// 3) Handle the problems
	for (int i = 0; i < q; i++) {
		int angle;
		cin >> angle;
		cout <<rotateCnt(angle) << endl;
	}


	return 0;
}

```

2D array[n][n]는 2000 X 2000 인 경우 (대략 n=1450 일 경우) 메모리 한계를 넘어간다.

```
int arr[2000][2000] = {}
```
vector 사용이 그 한계를 극복했다.
```
vector<vector<int>> array2D;
```


```cpp
#Version-3
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <time.h>
using namespace std;

#define FOR(i,n) for(int i = 0; i < (n); ++i)
#define FOR1(i,n) for(int i = 1; i < (n); ++i)


int cnt90, cnt180;

int rotateCnt(int angle){

	int cnt;
	int rotator = (angle / 90) % 4;

	if (rotator == 1 or rotator == 3) cnt = cnt90;
	else if (rotator == 2)	cnt = cnt180;
	else cnt = 0;

	return cnt;
}

int main() {

	int n;
	int q;
	cin >> n >> q;

	// 1) Initialize
	vector<vector<int>> array2D;
	array2D.resize(n);
	for (int i = 0; i < n; ++i){
		array2D[i].resize(n);
	}

	FOR(i,n){
		FOR(j,n) {
			long x = ((i+1) * (j+1)) % 7;
			if (x == 6 or x == 1 or x == 0) {
				array2D[i][j] = 1;
			}
		}
	}

	// 2) Count for 90/180/270 degrees
	FOR(i,n){
		FOR(j,n) {
			if (array2D[i][j] != array2D[n - j - 1][i]) cnt90++;
			if (array2D[i][j] != array2D[n - i - 1][n - j - 1]) cnt180++;
		}
	}

	// 3) Handle the problems
	for (int i = 0; i < q; i++) {
		int angle;
		cin >> angle;
		cout <<rotateCnt(angle) << endl;
	}

	return 0;
}

```
