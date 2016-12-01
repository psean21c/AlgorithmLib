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

def sum_digits(n):
    s = 0
    while n:
        s += n % 10
        n //= 10
    return s

#n = int(input().strip())
n = 100000

B = [i for i in range(1, n+1) if n%i ==0]
# B = [1, 2, 3, 4, 6, 12]
# B = [1,13,31,52]
print(B)
 
best = B[0]
greatest_sum = 0
 
for i in B:
    next_digit = i
    if i >= 10:
        next_digit = sum_digits(i)
    
    if next_digit > greatest_sum:
        best = i
        greatest_sum = next_digit

 
print(best)
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

	
	

