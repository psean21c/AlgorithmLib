

```cpp
#include <bits/stdc++.h>

using namespace std;

int N;
int A[1000];

int main()
{
    scanf("%d", &N);
    for(int i=0; i<N; i++)
    {
        int a;
        scanf("%d", &a);
        A[a]++;
    }
    int ans=0;
    for(int i=1; i<1000; i++)
        ans=max(ans, A[i-1]+A[i]);
    printf("%d\n", ans);
    return 0;
}

```

// https://www.hackerrank.com/contests/101hack44/challenges/picking-numbers/
// solutioned by pekempey
```cpp
#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    int ans = 0;
    for (int i = 0; i < 100; i++) {
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            if (a[j] == i || a[j] == i + 1) {
                cnt++;
            }
        }
        ans = max(ans, cnt);
    }
    cout << ans << endl;
}
```

