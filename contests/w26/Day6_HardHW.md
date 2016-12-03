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

```

---
