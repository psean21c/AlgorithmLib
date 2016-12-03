# Satisfactory Pairs

https://www.hackerrank.com/contests/w26/challenges/pairs-again

Given a positive integer n, 

find out the number of pairs of positive integers (a,b) where a < b,

that exist such that `x*a + y*b = n` (where x and y are positive integers)

4 <= n <= (300,000 = 3*10^5)

### Python Solution
```python

# 1)
n = int(input())
mid = n//2
m = set([(a,b) for a in range(1,n+1) for b in range(1,n+1) for x in range(1,n) for y in range(1,n) if (a*x + b*y == n) and ((a > 0 and b >0) and (a !=b) and (x > 0 and y >0) )])
#print(m)
print(len(m)//2)

# 2) 
n = int(input())
mid = n//2
m = set([(a,b) for a in range(1,n+1) for b in range(a+1,n+1) for x in range(1,n) for y in range(1,n) if (a*x + b*y == n) and ((a > 0 and b >0) and (a !=b) and (x > 0 and y >0) )])
#print(m)
print(len(m))

```

### C++ Solution

```cpp
// 1) Version-1
#include <iostream>
using namespace std;


void solve(int n){

	int mid = n / 2;
	int cnt = 0;
    
	for(int a=1;a<=mid;a++){
		for(int b=a+1;a+b<=n;b++){
			int a1,b1;
			for(int x=1;x<n;x++){
				for(int y=1;y<n;y++){
					if((a*x+b*y) == n) {
						if(a1==a && b1 ==b){

						} else {
							cnt++;
						}
						a1 = a;
						b1 = b;
					}
				}
			}
		}
	}


	cout << cnt <<  endl;
}

int main() {

	int n = 0;
	cin >> n;
	solve(n);
	return 0;
}

// 2) Version-2
//#include <time.h>

void solve(int n){
	//time_t t= clock();
	int mid = n / 2;

	int cnt = 0;
	for(int a=1;a<=mid;a++){
		for(int b=a+1;a+b<=n;b++){
			bool isContinue = true;
			for(int x=1;x<n and a*x <n and isContinue;x++){
				for(int y=1;y<n and a*x + b*y <=n and isContinue;y++){
					if((a*x+b*y) == n) {
						cnt++;
						isContinue = false;
					}
				}
			}
		}
	}
	cout << cnt << endl;
	//cout << "For a given number N[" << n << "] # of counts = " << cnt <<"\t[" << (double)(clock()-t)/CLOCKS_PER_SEC  <<"]"<<  endl;

}

// 3) Version-3
int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

void solve(int n){
	int mid = n / 2;

	int cnt = 0;
	for(int a=1;a<=mid;a++){
		for(int b=a+1;a+b<=n;b++){
			bool isContinue = true;
			if(n%gcd(a,b) !=0) isContinue = false;

			for(int x=1;x<n and a*x <n and isContinue;x++){
				for(int y=1;y<n and a*x + b*y <=n and isContinue;y++){
					if((a*x+b*y) == n) {
						cnt++;
						isContinue = false;
					}
				}
			}
		}
	}
	cout << cnt << endl;

}
```

Test cases
```
N => Count
4 => 2
11 => 18
30 => 93
100 => 566
150 => 1,027
1000 => 12,817
10000 =>  235,955
100000 => 3,825,502

==============================
N = 5  => Count = 4
(a,b)=(1,2),(x,y)=(1,2)
(a,b)=(1,2),(x,y)=(3,1)
(a,b)=(1,3),(x,y)=(2,1)
(a,b)=(1,4),(x,y)=(1,1)
(a,b)=(2,3),(x,y)=(1,1)

There are duplicate (1,2) for (a,b) 

```

Different performace based on different implementation
```
# Python Version
For a given number N[4] # of counts = 2		[0]
For a given number N[11] # of counts = 18	[0]
For a given number N[30] # of counts = 93	[0]
For a given number N[100] # of counts = 566	[0.072]
For a given number N[150] # of counts = 1027	[0.291]
For a given number N[1000] # of counts = 12817	[584.798]
================================================================
# CPP Version-1
For a given number N[8] # of counts = 10	[0]
For a given number N[11] # of counts = 18	[0]
For a given number N[30] # of counts = 93	[0]
For a given number N[100] # of counts = 566	[0]
For a given number N[150] # of counts = 1027	[0.001]
For a given number N[1000] # of counts = 12817	[0.062]
For a given number N[10000] # of counts = 235955	[7.523]
================================================================
# CPP Version-2
For a given number N[8] # of counts = 10	[0]
For a given number N[11] # of counts = 18	[0]
For a given number N[30] # of counts = 93	[0]
For a given number N[100] # of counts = 566	[0.001]
For a given number N[150] # of counts = 1027	[0]
For a given number N[1000] # of counts = 12817	[0.039]
For a given number N[10000] # of counts = 235955	[4.456]
For a given number N[100000] # of counts = 3825502	[751.499]

================================================================
# CPP Version-3
For a given number N[8] # of counts = 10	[0]
For a given number N[11] # of counts = 18	[0]
For a given number N[30] # of counts = 93	[0]
For a given number N[100] # of counts = 566	[0]
For a given number N[150] # of counts = 1027	[0.001]
For a given number N[1000] # of counts = 12817	[0.059]
For a given number N[10000] # of counts = 235955	[6.113]
For a given number N[100000] # of counts = 3825502	[879.826]

	if(n%gcd(a,b) !=0) isContinue = false;
	a*x + b*y = N
	if N is not divisible by gcd(a,b), there is no answer (x,y) satisfying equation.
	
	i.e. 3x + 6y = 10
	There are no answer (x,y) which satisfy the above equation.
	3(1) + 6(1) = 9 != 10
	3(-1) + 6(2) = 9 != 10
	
	Take another example, 	2x + 4y = 5
	Intuitively no matter what values you take for x and y, the value of left will be even number.
	
	According to the Theory, Let d be the greatest common divisor; d = gcd(a,b)
	Also N is not divisible by d, there are no answer for (x,y)
	
	So it skipped. However it doesn't improve performance more than expected.
	On the contrary, it reduced performance because it has to call gcd(a,b) everytime when it doesn't have to do it.
	

```

---
[Explain Diophantime Equation](http://math.stackexchange.com/questions/20717/how-to-find-solutions-of-linear-diophantine-ax-by-c)
