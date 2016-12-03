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
i = 1                2            8      9 10
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
```

---
