# Twins 

Count pairs of prime numbers having the difference of 2

[Original link in Hackerrank](https://www.hackerrank.com/contests/w26/challenges/twins)


Constraints
```
1 <= n <= m <= 1,000,000,000
m - n <= 1,000,000
```

input
```
3 13
```

output
```
3
```

Explanation
```
# 1) List of prime numbers in the range between 3 and 13
[3,5,7,11,13]

# 2) Find the pairs which have value of 2 for difference.
(3,5) (5,7) (11,13)

# 3) Answer
3

```

### Solution : Python version

```python
#Author: Simon Park
import sys
import math

N,M = input().strip().split(' ')
n,m = [int(N),int(M)]

#n,m = 2,100
#n,m = 10,1000000

#print(str(n) + " " + str(m))
primes = list([x for x in range(n, m+1) if all(x % y != 0 for y in range(2,math.ceil(math.sqrt(x)) + 1))]) 
 
# print(primes)
before = primes[0]

cnt = 0
for i in primes:
    if (i - before) == 2:
       cnt += 1 
    before = i
    
print(cnt)
```

### Solution : C++ version

```cpp
// Author: Simon Park
#include <iostream>
#include <algorithm>
using namespace std;

long n,m;

void solve(long n,long m) {
	int cnt = 0;

	int before = n;
    for (int i=n; i<m+1; i++){
        bool prime=true;

        for (int j=2; j*j<=i; j++) {
            if (i % j == 0) {
                prime=false;
                break;
            }
        }

        if(prime) {
        	if (i == (before+2)){
        		cnt++;
        	}
        	before = i;
        }
    }
    printf("%d",cnt);

}

int main() {
//	n = 3;
//	m = 1000000;
	cin >> n >> m;
	solve(n,m);
	return 0;
}


```
### Solution : C++ version 2

```cpp
#include <iostream>
using namespace std;

long n,m;

void solve(long n,long m) {

    int cnt = 0;
	int before = n;
	int prime_cnt = 0;
    
    for (int i=n; i<m+1; i++){
        bool prime=true;

        if(i == 1) prime=false;
        if((i%2==0) && (i!= 2)) prime=false;

        if(prime){
            for (int j=3; j*j<=i; j=j+2) {
                if (i % j == 0) {
                    prime=false;
                    break;
                }
            }
        }

        if(prime) {
        	if (prime_cnt ==0) {
        		before = i;
        		prime_cnt++;
        	}
        	if (i == (before+2)) cnt++;

        	before = i;
        }
    }
    printf("%d\n",cnt);

}

int main() {
	cin >> n >> m;
	solve(n,m);
    return 0;

}
```

Other Test Cases
```
	n = 999000000;
	m = 1000000000;
>> 3063	


	n = 1;
	m= 1000000;
>> 8169
	
	n=203;
	m=10001;
>> 190
	
```
