# Satisfactory Pairs

https://www.hackerrank.com/contests/w26/challenges/pairs-again

Given a positive integer n, find out the number of pairs of positive integers (a,b) where a < b,
that exist such that `x*a + y*b = n` (where x and y are positive integers)

4 <= n <= 3*10^5

```python

n = int(input())
mid = n//2
m = set([(a,b) for a in range(1,n+1) for b in range(1,n+1) for x in range(1,n) for y in range(1,n) if (a*x + b*y == n) and ((a > 0 and b >0) and (a !=b) and (x > 0 and y >0) )])
#print(m)
print(len(m)//2)
```
```cpp
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

```

Test cases
```
4 => 2
11 => 18
30 => 93
100 => 566

1000 => 12817

```
