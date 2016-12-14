# Hard Homework

https://www.hackerrank.com/contests/w26/challenges/hard-homework

What is the maximum value of 

  `sin(x) + sin(y) + sin(z)` where x,y, and z are positive integers and `x + y + z = n`



### C++ Solution

```cpp
// 1) Version-1
#include <iostream>
#include <cmath>
#include <time.h>
using namespace std;

void solve(int n){

	time_t t= clock();
	double max = 0;
	for(int i=1;i<=n-2;i++){
		for(int j=1;i+j<=n-1;j++){
			int k = n - i - j;
			double tmp = sin(i) + sin(j) + sin(k);
			if(tmp > max) {
				max = tmp;
			}
		}
	}

	printf("%.9f\n",max);


}

int main() {

	int n = 0;
	cin >> n;
	solve(n);

	return 0;
}

// 2) Version-2
// Divide the looping job based on the number of repetition.

#include <iostream>
#include <cmath>
#include <time.h>
using namespace std;

double max(double a,double b){
	if(a>b) return a;
	else return b;
}

double max(double a,double b,double c){
	double max = a;
	if(max< b) max = b;
	if(max< c) max = c;
	return max;
}

double work(int n,int start,int end){

	double max = 0;
	for(int i=start;i<=end;i++){
		for(int j=1;i+j<=n-1;j++){
			int k = n - i - j;
			//printf("x=[%d],y=[%d],z=[%d]\n",i,j,k);
			double tmp = sin(i) + sin(j) + sin(k);
			if(tmp > max) {
				//printf("x=[%d],y=[%d],z=[%d],new[%.9f],old[%.9f]\n",i,j,k,tmp,max);
				max = tmp;
			}
		}
	}
	return max;
}

void solve(int n){

	time_t t= clock();

	double sinMax = 0;
	if(n <100){
		sinMax = work(n,1,n-2);
	} else if (n >=100 && n < 6000){
		int mid = n/3;
		sinMax = max(work(n,1,mid),work(n,mid+1,n-2));
	} else {
		int mid1 = n/5;
		int mid2 = n/3;
		sinMax = max(work(n,1,mid1),work(n,mid1+1,mid2),work(n,mid2+1,n-2));
	}
	printf("N[%d]\t%.9f\t",n,sinMax);
	cout << (double)(clock()-t)/CLOCKS_PER_SEC<< " sec" << endl;

}

int main() {

	solve(3);
	solve(10);
	solve(20);
	solve(100);
	solve(1000);
	solve(2000);
	solve(3000);
	solve(4000);
	solve(4000);
	solve(5000);
	solve(6000);
	solve(7000);
	solve(8000);
	solve(9000);
	solve(10000);
	solve(16700);
//	solve(400000);
//	solve(3000000);

	return 0;
}

}
```

Test cases
```
Let's say N = 10
i = 1                2    ..      8      9...  10
-------------       ---------     ----   ------
j= 1,2,3,.. 8        1,2,..7       1
k =8,7,6,.. 1        7,6,..1       1

At each statement, "i + j + k = 10" needs to be satisfied, So you need to run O(N*N)

	for(int i=1;i<=n-2;i++){
		for(int j=1;i+j<=n-1;j++){
			int k = n - i - j; // (n = i + j + k)
			sin(i) + sin(j) + sin(k);
		}
	}



# result on Version-2
N[3]	2.524412954		0 sec
N[10]	2.672300216		0 sec
N[20]	1.733534397		0 sec
N[100]	2.816728008		0.001 sec
N[1000]	1.984134549		0.089 sec
N[2000]	1.813212081		0.303 sec
N[3000]	2.480638622		0.68 sec
N[4000]	2.889079452		1.206 sec
N[4000]	2.889079452		1.218 sec
N[5000]	2.995956441		1.894 sec
N[6000]	2.790118513		2.734 sec
N[7000]	2.292985105		3.718 sec
N[8000]	1.556514568		4.966 sec
N[9000]	2.206093817		6.131 sec
N[10000]	2.739180081	7.594 sec
N[16700]	2.876370614	21.146 sec

N[4000000]	2.666609898	infinite sec ???

# result 
N[10]	2.672300216	(x,y,z)=(1,1,8)				0.001 sec
N[20]	1.733534397	(x,y,z)=(9,9,2)				0 sec
N[30]	2.969323849	(x,y,z)=(8,8,14)			0 sec
N[40]	2.076531648	(x,y,z)=(7,7,26)			0 sec
N[50]	2.720383201	(x,y,z)=(2,46,2)			0 sec
N[60]	2.738835752	(x,y,z)=(20,20,20)			0.001 sec
N[70]	2.045688841	(x,y,z)=(15,15,40)			0 sec
N[80]	2.990431076	(x,y,z)=(14,33,33)			0.001 sec
N[90]	1.880080834	(x,y,z)=(7,7,76)			0.001 sec
N[100]	2.816728008	(x,y,z)=(2,27,71)			0.001 sec
N[200]	2.956842930	(x,y,z)=(52,96,52)			0.004 sec
N[300]	2.998640411	(x,y,z)=(33,33,234)			0.009 sec
N[400]	2.947443846	(x,y,z)=(14,171,215)			0.016 sec
N[500]	2.806171103	(x,y,z)=(152,152,196)			0.026 sec
N[600]	2.575674398	(x,y,z)=(89,89,422)				0.031 sec
N[700]	2.264513914	(x,y,z)=(315,359,26)			0.038 sec
N[800]	1.882785673	(x,y,z)=(252,252,296)			0.049 sec
N[900]	1.557029020	(x,y,z)=(78,411,411)			0.061 sec
N[1000]	1.984134549	(x,y,z)=(304,348,348)			0.075 sec
N[2000]	1.813212081	(x,y,z)=(208,541,1251)			0.302 sec
N[3000]	2.480638622	(x,y,z)=(1000,1000,1000)		0.689 sec
N[4000]	2.889079452	(x,y,z)=(39,39,3922)			1.216 sec
N[5000]	2.995956441	(x,y,z)=(498,2251,2251)			1.893 sec
N[6000]	2.790118513	(x,y,z)=(2000,2000,2000)		2.733 sec
N[7000]	2.292985105	(x,y,z)=(329,329,6342)			3.72 sec
N[8000]	1.556514568	(x,y,z)=(78,3961,3961)			4.859 sec
N[9000]	2.206093817	(x,y,z)=(648,3821,4531)			6.157 sec
N[10000]2.739180081	(x,y,z)=(2860,3570,3570)		7.602 sec


```

해답을 보고 나니..  

삼각함수에서 sin(x+y) = sin(x)cos(y) + cos(x)sin(y) 와 같은 성격이 있다는 것을 이용할 시도조차 해보지 못했다는 것을 알았다.

---


```cpp

// by Author
#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

int main() {
int s;
cin >> s;
double ans = -1E9;
double mxeven = -1E9, mxodd = -1E9;
for (double i = 2; i < s; i += 2) {
    mxeven = max(mxeven, cos( (i - 2) / 2 ));
    ans = max(ans, 
        2. * sin(i/2) * mxeven + sin(s - i));
}
for (double i = 3; i < s; i += 2) {
    mxodd = max(mxodd, cos( (i - 2) / 2 ));
    ans = max(ans, 
        2. * sin(i/2) * mxodd + sin(s - i));
}
cout << fixed << setprecision(9) << ans << endl;
return 0;
}


// by zxqfd555

#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cassert>
#include <cmath>
#include <iomanip>

using namespace std;

const int MAXN = 3000000 + 10;

double f[MAXN], hMin[MAXN], hMax[MAXN];
int n;

int main(int argc, const char * argv[]) {

    cin >> n;
    assert(3 <= n && n <= 3000000);

    hMin[0] = hMax[0] = cos(0);
    hMin[1] = hMax[1] = cos(1);
    for(int i = 2; i <= n; i++) {
        hMin[i] = min(hMin[i - 2], cos(i / 2.0));
        hMax[i] = max(hMax[i - 2], cos(i / 2.0));
    }

    f[2] = sin(1) + sin(1);
    for(int i = 3; i <= n; i++)
        f[i] = max(2.0 * sin(i / 2.0) * hMin[i - 2], 2.0 * sin(i / 2.0) * hMax[i - 2]);

    double ret = -10.0;

    for(int i = 1; i <= n - 2; i++)
        ret = max(ret, sin(i) + f[n - i]);

    cout << fixed << setprecision(9);
    cout << ret << endl;

    return 0;
}
```
