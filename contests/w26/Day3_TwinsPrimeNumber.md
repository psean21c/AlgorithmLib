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
* The 1st version was timed out because it takes more time to validate prime numbers - It's not necessary to validate even numbers.
* The `int before = n` means that I asumed that first number of range(n,m) was prime number - which is not always necessary.

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
1)
	n = 999000000;
	m = 1000000000;
>> 3063	

2)
	n = 1;
	m= 1000000;
>> 8169
	
3)
	n=203;
	m=10001;
>> 190

4)
	n=900479287;
	m=901329639;
>> 2618

```

* Test Case 4 에 대해서 시간을 측정해 본 결과 : 나의 위 해답이 약 2.8 초 걸린 것에 비해서.. 아래의 해답은 약 1.76 초 걸리다. 1초 가량이 더 빠르다.



---


## Solution by author in Editorial

The simplest (but too slow) approach will be the following: iterate through integers from `N` to `M` and do the prime test for each of them. The prime test for `X` will be just iterating through integers from 1 to `X` and check whether X is divisible by any of them.

The first speed-up: it's not hard to see that it's enough to iterate only from 1 to sqrt(X) because if X is not a prime there is at least one prime divisor less than square root of X. But it's still too slow.

The second speed-up: now we can notice that there is sense to iterate only through prime integers from 1 to sqrt(N). So we can precompute with the previous test all the prime numbers less than sqrt(10^9) and then use only them when we check numbers from `N` to `M`. This should be fast enough to get AC. See the code for details.


### Solution :  by shef_2318

```cpp
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cassert>
using namespace std;


int main() {
    int n, m;
    cin >> n >> m;
    assert(m - n > 0 && m - n < 1E6);
    int lst = -1;
    int ans = 0;
    vector<int> primes;
    for (int i = 2; i*i <= 1E9; i++) {
        bool ok = true;
        for (int j = 2; j*j <= i; j++) {
            if (i % j == 0) {
                ok = false;
                break;
            }
        }
        if (ok && i > 1) {
            primes.push_back(i);
        }
    }

    for (int i = n; i <= m; i++) {
        bool ok = true;
        for (int j = 0; j < primes.size() && primes[j]*primes[j] <= i; j++) {
            if (i % primes[j] == 0) {
                ok = false;
                break;
            }
        }

        if (ok && i > 1) {
            ans += (lst == i - 2);
            lst = i;
        }
    }
    cout << ans << endl;
    return 0;
}
```

### Solution :  by zxqfd555

```cpp
#include <iostream>
#include <algorithm>
#include <cassert>

using namespace std;

const int MAXN = 1000000 + 100;

int l, r;
bool isPrime[MAXN];

int main(int argc, const char * argv[]) {
    cin >> l >> r;
    assert(1 <= l && l <= r && r <= 1000000000);
    assert(r - l <= 1000000);

    for(int i = 0; i <= r - l; i++)
        isPrime[i] = true;
    for(int i = 2; i * i <= r; i++) {
        int startPos = l / i * i;
        if (startPos < l)
            startPos += i;
        if (startPos == i)
            startPos += i;
        for(int j = startPos; j <= r; j += i)
            isPrime[j - l] = false;
    }

    int ret = 0;

    for(int i = 0 + (l == 1); i <= r - l - 2; i++)
        ret += isPrime[i] & isPrime[i + 2];

    cout << ret << endl;

    return 0;
}
```
