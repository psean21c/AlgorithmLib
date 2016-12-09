#

[Minimize MaxMin](https://www.hackerrank.com/contests/101hack43/challenges/max-min-difference)

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
