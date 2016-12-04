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

// Version-4
#include <iostream>
using namespace std;

void solve(int n){
    int mid = n / 2;
    int cnt = 0;

    for(int a=1;a<=mid;a++){
        for(int b=a+1; a+b<=n ; b++){
            bool isContinue = true;
            for(int x=1; x<n and a*x <n and isContinue; x++){
            	int y = n-a*x;
            	if(y%b==0 and y/b >0) {
            		cnt++;
            		isContinue = false;
            	}
            }
        }
    }
    cout << cnt << endl;

}

int main() {

	int n = 0;
	cin >> n;
	solve(n);

	return 0;
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
	

================================================================
# CPP Version-4
For a given number N[8] # of counts = 10	[0]
For a given number N[11] # of counts = 18	[0]
For a given number N[30] # of counts = 93	[0]
For a given number N[100] # of counts = 566	[0]
For a given number N[150] # of counts = 1027	[0.001]
For a given number N[1000] # of counts = 12817	[0.035]
For a given number N[10000] # of counts = 235955	[2.841]
For a given number N[100000] # of counts = 3825502	[366.63]

// In order to have valid answer of y (based on x), ax + by = n (a,b,x,y are all positive integer)
// (n-a*x)%b == 0 and (n-a*x)/b > 0 Need to be satisfied.. 
// 1*x + 2*y = 5, 
// 2*y = 5 - 1*x
// y = (5 - 1*x) / 2
// y = (5 - 1*1) / 2 = 4/2 = 2, when x = 1

    for(int a=1 ...){
        for(int b=a+1  ...){
            for(int x=1 ...){
	    
            	int y = n-a*x;
            	if(y%b==0 and y/b >0) {
            		cnt++;
            		isContinue = false;
            	}
            }
        }
    }
    
    
    
```

```data
(a,b)=(1,2)
	 (x,y)=(2,3)
(a,b)=(1,3)
	 (x,y)=(2,2)
(a,b)=(1,4)
	 (x,y)=(4,1)
(a,b)=(1,5)
	 (x,y)=(3,1)
(a,b)=(1,6)
	 (x,y)=(2,1)
(a,b)=(1,7)
	 (x,y)=(1,1)
(a,b)=(2,3)
	 (x,y)=(1,2)
(a,b)=(2,4)
	 (x,y)=(2,1)
(a,b)=(2,5)
(a,b)=(2,6)
	 (x,y)=(1,1)
(a,b)=(3,4)
(a,b)=(3,5)
	 (x,y)=(1,1)
For a given number N[8] # of counts = 10	[0]

(a,b)=(1,2)
	 (x,y)=(1,5)
(a,b)=(1,3)
	 (x,y)=(2,3)
(a,b)=(1,4)
	 (x,y)=(3,2)
(a,b)=(1,5)
	 (x,y)=(1,2)
(a,b)=(1,6)
	 (x,y)=(5,1)
(a,b)=(1,7)
	 (x,y)=(4,1)
(a,b)=(1,8)
	 (x,y)=(3,1)
(a,b)=(1,9)
	 (x,y)=(2,1)
(a,b)=(1,10)
	 (x,y)=(1,1)
(a,b)=(2,3)
	 (x,y)=(1,3)
(a,b)=(2,4)
(a,b)=(2,5)
	 (x,y)=(3,1)
(a,b)=(2,6)
(a,b)=(2,7)
	 (x,y)=(2,1)
(a,b)=(2,8)
(a,b)=(2,9)
	 (x,y)=(1,1)
(a,b)=(3,4)
	 (x,y)=(1,2)
(a,b)=(3,5)
	 (x,y)=(2,1)
(a,b)=(3,6)
(a,b)=(3,7)
(a,b)=(3,8)
	 (x,y)=(1,1)
(a,b)=(4,5)
(a,b)=(4,6)
(a,b)=(4,7)
	 (x,y)=(1,1)
(a,b)=(5,6)
	 (x,y)=(1,1)
For a given number N[11] # of counts = 18	[0.014]

(a,b)=(1,2)
	 (x,y)=(2,14)
(a,b)=(1,3)
	 (x,y)=(3,9)
(a,b)=(1,4)
	 (x,y)=(2,7)
(a,b)=(1,5)
	 (x,y)=(5,5)
(a,b)=(1,6)
	 (x,y)=(6,4)
(a,b)=(1,7)
	 (x,y)=(2,4)
(a,b)=(1,8)
	 (x,y)=(6,3)
(a,b)=(1,9)
	 (x,y)=(3,3)
(a,b)=(1,10)
	 (x,y)=(10,2)
(a,b)=(1,11)
	 (x,y)=(8,2)
(a,b)=(1,12)
	 (x,y)=(6,2)
(a,b)=(1,13)
	 (x,y)=(4,2)
(a,b)=(1,14)
	 (x,y)=(2,2)
(a,b)=(1,15)
	 (x,y)=(15,1)
(a,b)=(1,16)
	 (x,y)=(14,1)
(a,b)=(1,17)
	 (x,y)=(13,1)
(a,b)=(1,18)
	 (x,y)=(12,1)
(a,b)=(1,19)
	 (x,y)=(11,1)
(a,b)=(1,20)
	 (x,y)=(10,1)
(a,b)=(1,21)
	 (x,y)=(9,1)
(a,b)=(1,22)
	 (x,y)=(8,1)
(a,b)=(1,23)
	 (x,y)=(7,1)
(a,b)=(1,24)
	 (x,y)=(6,1)
(a,b)=(1,25)
	 (x,y)=(5,1)
(a,b)=(1,26)
	 (x,y)=(4,1)
(a,b)=(1,27)
	 (x,y)=(3,1)
(a,b)=(1,28)
	 (x,y)=(2,1)
(a,b)=(1,29)
	 (x,y)=(1,1)
(a,b)=(2,3)
	 (x,y)=(3,8)
(a,b)=(2,4)
	 (x,y)=(1,7)
(a,b)=(2,5)
	 (x,y)=(5,4)
(a,b)=(2,6)
	 (x,y)=(3,4)
(a,b)=(2,7)
	 (x,y)=(1,4)
(a,b)=(2,8)
	 (x,y)=(3,3)
(a,b)=(2,9)
	 (x,y)=(6,2)
(a,b)=(2,10)
	 (x,y)=(5,2)
(a,b)=(2,11)
	 (x,y)=(4,2)
(a,b)=(2,12)
	 (x,y)=(3,2)
(a,b)=(2,13)
	 (x,y)=(2,2)
(a,b)=(2,14)
	 (x,y)=(1,2)
(a,b)=(2,15)
(a,b)=(2,16)
	 (x,y)=(7,1)
(a,b)=(2,17)
(a,b)=(2,18)
	 (x,y)=(6,1)
(a,b)=(2,19)
(a,b)=(2,20)
	 (x,y)=(5,1)
(a,b)=(2,21)
(a,b)=(2,22)
	 (x,y)=(4,1)
(a,b)=(2,23)
(a,b)=(2,24)
	 (x,y)=(3,1)
(a,b)=(2,25)
(a,b)=(2,26)
	 (x,y)=(2,1)
(a,b)=(2,27)
(a,b)=(2,28)
	 (x,y)=(1,1)
(a,b)=(3,4)
	 (x,y)=(2,6)
(a,b)=(3,5)
	 (x,y)=(5,3)
(a,b)=(3,6)
	 (x,y)=(2,4)
(a,b)=(3,7)
	 (x,y)=(3,3)
(a,b)=(3,8)
	 (x,y)=(2,3)
(a,b)=(3,9)
	 (x,y)=(1,3)
(a,b)=(3,10)
(a,b)=(3,11)
(a,b)=(3,12)
	 (x,y)=(2,2)
(a,b)=(3,13)
(a,b)=(3,14)
(a,b)=(3,15)
	 (x,y)=(5,1)
(a,b)=(3,16)
(a,b)=(3,17)
(a,b)=(3,18)
	 (x,y)=(4,1)
(a,b)=(3,19)
(a,b)=(3,20)
(a,b)=(3,21)
	 (x,y)=(3,1)
(a,b)=(3,22)
(a,b)=(3,23)
(a,b)=(3,24)
	 (x,y)=(2,1)
(a,b)=(3,25)
(a,b)=(3,26)
(a,b)=(3,27)
	 (x,y)=(1,1)
(a,b)=(4,5)
	 (x,y)=(5,2)
(a,b)=(4,6)
	 (x,y)=(3,3)
(a,b)=(4,7)
	 (x,y)=(4,2)
(a,b)=(4,8)
(a,b)=(4,9)
	 (x,y)=(3,2)
(a,b)=(4,10)
	 (x,y)=(5,1)
(a,b)=(4,11)
	 (x,y)=(2,2)
(a,b)=(4,12)
(a,b)=(4,13)
	 (x,y)=(1,2)
(a,b)=(4,14)
	 (x,y)=(4,1)
(a,b)=(4,15)
(a,b)=(4,16)
(a,b)=(4,17)
(a,b)=(4,18)
	 (x,y)=(3,1)
(a,b)=(4,19)
(a,b)=(4,20)
(a,b)=(4,21)
(a,b)=(4,22)
	 (x,y)=(2,1)
(a,b)=(4,23)
(a,b)=(4,24)
(a,b)=(4,25)
(a,b)=(4,26)
	 (x,y)=(1,1)
(a,b)=(5,6)
(a,b)=(5,7)
(a,b)=(5,8)
(a,b)=(5,9)
(a,b)=(5,10)
	 (x,y)=(2,2)
(a,b)=(5,11)
(a,b)=(5,12)
(a,b)=(5,13)
(a,b)=(5,14)
(a,b)=(5,15)
	 (x,y)=(3,1)
(a,b)=(5,16)
(a,b)=(5,17)
(a,b)=(5,18)
(a,b)=(5,19)
(a,b)=(5,20)
	 (x,y)=(2,1)
(a,b)=(5,21)
(a,b)=(5,22)
(a,b)=(5,23)
(a,b)=(5,24)
(a,b)=(5,25)
	 (x,y)=(1,1)
(a,b)=(6,7)
(a,b)=(6,8)
	 (x,y)=(1,3)
(a,b)=(6,9)
	 (x,y)=(2,2)
(a,b)=(6,10)
(a,b)=(6,11)
(a,b)=(6,12)
	 (x,y)=(1,2)
(a,b)=(6,13)
(a,b)=(6,14)
(a,b)=(6,15)
(a,b)=(6,16)
(a,b)=(6,17)
(a,b)=(6,18)
	 (x,y)=(2,1)
(a,b)=(6,19)
(a,b)=(6,20)
(a,b)=(6,21)
(a,b)=(6,22)
(a,b)=(6,23)
(a,b)=(6,24)
	 (x,y)=(1,1)
(a,b)=(7,8)
	 (x,y)=(2,2)
(a,b)=(7,9)
	 (x,y)=(3,1)
(a,b)=(7,10)
(a,b)=(7,11)
(a,b)=(7,12)
(a,b)=(7,13)
(a,b)=(7,14)
(a,b)=(7,15)
(a,b)=(7,16)
	 (x,y)=(2,1)
(a,b)=(7,17)
(a,b)=(7,18)
(a,b)=(7,19)
(a,b)=(7,20)
(a,b)=(7,21)
(a,b)=(7,22)
(a,b)=(7,23)
	 (x,y)=(1,1)
(a,b)=(8,9)
(a,b)=(8,10)
(a,b)=(8,11)
	 (x,y)=(1,2)
(a,b)=(8,12)
(a,b)=(8,13)
(a,b)=(8,14)
	 (x,y)=(2,1)
(a,b)=(8,15)
(a,b)=(8,16)
(a,b)=(8,17)
(a,b)=(8,18)
(a,b)=(8,19)
(a,b)=(8,20)
(a,b)=(8,21)
(a,b)=(8,22)
	 (x,y)=(1,1)
(a,b)=(9,10)
(a,b)=(9,11)
(a,b)=(9,12)
	 (x,y)=(2,1)
(a,b)=(9,13)
(a,b)=(9,14)
(a,b)=(9,15)
(a,b)=(9,16)
(a,b)=(9,17)
(a,b)=(9,18)
(a,b)=(9,19)
(a,b)=(9,20)
(a,b)=(9,21)
	 (x,y)=(1,1)
(a,b)=(10,11)
(a,b)=(10,12)
(a,b)=(10,13)
(a,b)=(10,14)
(a,b)=(10,15)
(a,b)=(10,16)
(a,b)=(10,17)
(a,b)=(10,18)
(a,b)=(10,19)
(a,b)=(10,20)
	 (x,y)=(1,1)
(a,b)=(11,12)
(a,b)=(11,13)
(a,b)=(11,14)
(a,b)=(11,15)
(a,b)=(11,16)
(a,b)=(11,17)
(a,b)=(11,18)
(a,b)=(11,19)
	 (x,y)=(1,1)
(a,b)=(12,13)
(a,b)=(12,14)
(a,b)=(12,15)
(a,b)=(12,16)
(a,b)=(12,17)
(a,b)=(12,18)
	 (x,y)=(1,1)
(a,b)=(13,14)
(a,b)=(13,15)
(a,b)=(13,16)
(a,b)=(13,17)
	 (x,y)=(1,1)
(a,b)=(14,15)
(a,b)=(14,16)
	 (x,y)=(1,1)
For a given number N[30] # of counts = 93	[0.033]

```
---
[Explain Diophantime Equation](http://math.stackexchange.com/questions/20717/how-to-find-solutions-of-linear-diophantine-ax-by-c)
