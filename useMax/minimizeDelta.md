#

```
101 Hacker43 : 1st Question - Minimize MaxMin

WoC 18: 1st - Ghost


```
---


* [Minimize MaxMin](https://www.hackerrank.com/contests/101hack43/challenges/max-min-difference)

input
```
5
7 4 3 1 3
```
output
```
3
```

Expalin
```
1) sort
1 3 3 4 7

2) Case-1 : Delete 1
3 3 4 7
 * 7-3=4
 
3)  Case-2 : Delete 7
1 3 3 4
 * 4-1=3

4) Answer = 3 
```

input
```
10
5 4 0 8 3 8 4 1 1 8
```
output
```
7
```

Expalin
```
1) sort
0 1 1 3 4 4 5 8 8 8

2) Case-1 : Delete 0
1 1 3 4 4 5 8 8 8
 * 8-1=7
 
3)  Case-2 : Delete 8
0 1 1 3 4 4 5 8 8
 * 8-0=8

4) Answer = 7

```

* My Solution
It's not good solution . 내가 푼 방식은 쓸데 없이 돌아간 것 같다..

```python

N=int(input())
lst = [int(x) for x in input().strip().split()]

m1 = max(lst)
n1 = min(lst)
m2 = 0
n2 = m1

max_cnt = 0
min_cnt = 0

for i in lst:
    if i == m1:
        max_cnt = max_cnt + 1
    elif (i !=m1 and i > m2): 
        m2 = i
        
    if i == n1:
        min_cnt = min_cnt + 1
    elif (i !=n1 and i < n2):
        n2 = i


miniMax = 0
if max_cnt==1 and min_cnt==1:
    miniMax = min(m1-n2,m2-n1)
elif max_cnt==1 and min_cnt > 1:
    miniMax = m2-n1
elif max_cnt > 1 and min_cnt==1:
    miniMax = m1-n2

print(miniMax)
```


```cpp
#include <bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin>>n;
    vector <int> v(n);
    for (int i=0;i<n;i++)
        cin>>v[i];
    sort(v.begin(),v.end());
    cout<<min(v[n-2]-v[0],v[n-1]-v[1])<<endl;
}

```

---

* [Ghost](https://www.hackerrank.com/contests/w18/challenges/ghosts)
