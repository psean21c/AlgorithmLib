# Music on the Street

[Original question](https://www.hackerrank.com/contests/w26/challenges/street-parade-1)

Test cases
```
#1)
2
1 3
7 2 3
=> -2

#2)
5
12 16 21 25 27
17 1 5 
=> 11
```

Explain
```
m (margin) = h -(last - first) 
h1 =1
h2 =4

m (margin)
0 : X
1 : X
2 :  
3 :
4 :
5 :
6 :
7 :
8 :
9 : X


```
![parade](https://cloud.githubusercontent.com/assets/5623445/20814898/99fd72f8-b7e9-11e6-969d-c14e26292f5c.PNG)

```cpp
#include <iostream>
#include <algorithm>
#include <time.h>
using namespace std;

void solve(int n,long ar[],int h,int h1,int h2){

	long first = ar[0];
	long last = ar[n-1];

	long mid = last - first;
	long margin = h - mid;

	long start = 0;
	if((margin == h1+h1) || (margin <h1+h2)) {start = first - h1;}
	else {start = first -h2;}

	cout << start << endl;

}

int main() {
	int n1 = 5;
	long ar[n1] = {12, 16, 21, 25, 27};
	solve(n1,ar,17,1,5); // 11

	int n2 = 5;
	long ar2[n2] = {1,3};
	solve(n2,ar2,7,2,3); // -2

	int n3 = 3;
	long ar3[n3] = {1,3,5};
	solve(n3,ar3,6,1,4);    // 0      (margin=2)

	int n4 = 3;
	long ar4[n4] = {1,3,5};
	solve(n4,ar4,7,1,4);   // -1,0    (margin=3)

	int n5 = 3;
	long ar5[n5] = {1,3,5};
	solve(n5,ar5,8,1,4);  // -2,-1,0 (margin=4)

	int n6 = 3;
	long ar6[n6] = {1,3,5};
	solve(n6,ar6,9,1,4);  //-3,-2,-1,0 (margin=5)

	int n7 = 3;
	long ar7[n7] = {1,3,5};
	solve(n7,ar7,10,1,4);  //-3,-2,-1 (margin=6)

	int n8 = 3;
	long ar8[n8] = {-1,1,3};
	solve(n8,ar8,6,1,4);    // -2 (margin=2)

	return 0;
}


```

result
```
11
-2
0
0
0
-3
-3
-2

```

input: Test Case 6: Failed
```
100
-949799661 -884696350 -771778290 -750979139 -692580014 -653348024 -639794045 -620540617 -597992159 -589982585 -583180475 -548918671 -530589504 -396945152 -389301514 -346340080 -284914439 -273078437 -265981192 -153202264 -133488444 -4979 -4793 -4703 -4337 -4331 -4268 -4175 -3716 -3503 -3455 -3452 -3332 -3107 -2981 -2857 -2813 -2625 -2597 -2595 -2489 -2464 -2440 -2400 -2343 -2269 -1951 -1846 -1783 -1577 -1448 -1335 -1210 -1207 -934 -604 -541 -526 -508 -392 -386 -299 -220 -206 97 485 658 736 836 955 1182 1204 1405 1461 1595 1614 1798 2480 2582 10529236 85659071 145322147 238707616 347063135 348212159 361651802 387287498 404698744 586524071 619234513 642064558 708547265 711333893 738281597 754472030 777490544 793514915 867995669 968276905 991322826
8249 2 682
```

output
```
-5661
```


## Solution

###
```cpp
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cassert>

using namespace std;

const int MAXN = 1E6 + 100;

int leftMin[MAXN];
int leftMax[MAXN];
int rightMin[MAXN];
int rightMax[MAXN];
int saw[MAXN];
int n, leftSaw, rightSaw;

pair<int, bool> check(int len, int l, int r) {
    int left = len - (saw[r] - saw[l]);
    if (left == 0) {
        return make_pair(saw[l], true);
    }
    if (left >= leftMin[l] && left <= leftMax[l]) {
        return make_pair(saw[l] - left, true);
    }
    if (left >= rightMin[r] && left <= rightMax[r]) {
        return make_pair(saw[l], true);
    }
    if (left >= leftMin[l] + rightMin[r]
            && left <= leftMax[l] + rightMax[r]) {
        return make_pair(saw[l] - max(leftMin[l], left - rightMax[r]), true);
    }
    return make_pair(0, false);
}

int main() {
cin >> n;

for (int i = 0; i < n; i++) {
    cin >> saw[i];
}
sort(saw, saw + n);
int l, a, b;
cin >> l >> a >> b;

for (int i = 0; i < n; i++) {
    if (i == 0) {
        leftMax[i] = b;
        leftMin[i] = a;
    } else {
        int leftDist = saw[i] - saw[i - 1];
        if (leftDist < a) {
            leftMax[i] = 0;
            leftMin[i] = 0;
        } else {
            leftMax[i] = min(b, leftDist);
            leftMin[i] = a;
        }
    }
    if (i == n - 1) {
        rightMax[i] = b;
        rightMin[i] = a;
    } else {
        int rightDist = saw[i + 1] - saw[i];
        if (rightDist < a) {
            rightMax[i] = 0;
            rightMin[i] = 0;
        } else {
            rightMax[i] = min(b, rightDist);
            rightMin[i] = a;
        }
    }
}
rightSaw = 0;
leftSaw = 0;

while (leftSaw < n) {
    if (rightSaw < leftSaw)
        rightSaw = leftSaw;
    while (leftSaw < n && rightSaw < n
            && leftMax[leftSaw] + (saw[rightSaw] - saw[leftSaw]) + rightMax[rightSaw] < l) {
            if (rightMax[rightSaw] == 0
                || (rightSaw < n - 1 && saw[rightSaw + 1]
                    - saw[rightSaw] > b)) {
                leftSaw = rightSaw + 1;
                rightSaw = leftSaw;
            } else
                rightSaw++;

        }
        if (leftSaw >= n || rightSaw >= n) {
            break;
        }
        pair<int, bool> ans = check(l, leftSaw, rightSaw);
        if (ans.second) {
            cout << ans.first << endl;
            return 0;
        }
        leftSaw++;
    }

    assert(false);
    return 0;
}
```

### Solution 

```cpp
#include <iostream>
#include <cassert>
#include <algorithm>
#include <cassert>

using namespace std;

const int INF = 2000000000 + 1000;
const int MAXN = 1000000 + 2000;

int n;
long long a[MAXN];
int f[MAXN];
int l, r, s;
long long opt, optPos;

void check (long long k) {
    if (k < -INF)
        return ;
    if (k + s > INF)
        return ;
    int pStart = lower_bound(a + 1, a + n + 1, k) - a;
    int pFinish = lower_bound(a + 1, a + n + 1, k + s) - a;
    if (a[pFinish] > k + s)
        --pFinish;
    if (pStart <= pFinish) {
        if (f[pFinish] - f[pStart] != pFinish - pStart)
            return ;
    }
    int tAns = pFinish - pStart + 1;
    if (a[pStart] != k) {
        long long gap = a[pStart] - k;
        if (gap < l || gap > r)
            return ;
        ++tAns;
    }
    if (a[pFinish] != k + s) {
        long long gap = k + s - a[pFinish];
        if (gap < l || gap > r)
            return ;
        ++tAns;
    }
    if (tAns > opt || (tAns == opt && optPos > k)) {
        opt = tAns;
        optPos = k;
    }
}

int main(int argc, const char * argv[]) {

    ios_base::sync_with_stdio(false);

    cin >> n;
    assert(1 <= n && n <= 1000000);
    for(int i = 1; i <= n; i++) {
        cin >> a[i];
        assert(-1000000000 <= a[i] && a[i] <= 1000000000);
        if (i > 1)
            assert(a[i] >= a[i - 1]);
    }
    a[++n] = -INF;
    a[++n] = INF;
    sort(a + 1, a + n + 1);
    cin >> s >> l >> r;
    assert(1 <= l && l <= r && r <= 1000000000);
    assert(1 <= s && s <= 1000000000);

    for(int i = 2; i <= n; i++) {
        f[i] = f[i - 1];
        if (l <= a[i] - a[i - 1] && a[i] - a[i - 1] <= r)
            ++f[i];
    }

    for(int i = 2; i <= n; i++) {
        check(a[i] - l);
        check(a[i] - r);
        check(a[i]);
    }

    cout << optPos << endl;

    return 0;
}
```
