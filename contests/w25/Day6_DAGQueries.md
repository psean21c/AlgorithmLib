#

## Solution by author

```cpp
#include <bits/stdc++.h>
using namespace std;
#define sz(x) ((int) (x).size())
#define forn(i,n) for (int i = 0; i < int(n); ++i)
typedef long long ll;
typedef long long i64;
typedef long double ld;
typedef pair<int, int> pii;
const int inf = int(1e9) + int(1e5);
const ll infl = ll(2e18) + ll(1e10);

#define tm suka

const int maxc = 1e9;

//const int maxn = 1001;
const int maxn = 100100;
vector<int> g[maxn];

int tm[maxn];

int qt[maxn];
int qu[maxn];
int qx[maxn];
int qans[maxn];

//const int sn = 1;
const int sn = 600;
const int sn2 = 1000;
const int block = maxn / 3 + 2;
bitset<block> bs[maxn];
bool used[maxn];
int L, R;
int n;

vector<int> ord;

void pre(int u) {
    used[u] = true;
    for (int v: g[u])
        if (!used[v])
            pre(v);
    ord.push_back(u);
}

void uin(int &a, int b) {
    a = min(a, b);
}

void uax(int &a, int b) {
    a = max(a, b);
}

int a[maxn / sn + 2][maxn];

int upd[maxn];
vector<pii> o;
void put1(int u, int x) {
    o.emplace_back(u, x);
    if (sz(o) < sn2)
        return;
    forn (i, n)
        upd[i] = -1;
    for (auto p: o)
        uax(upd[p.first], p.second);
    o.clear();
    for (int ii = n - 1; ii >= 0; --ii) {
        int u = ord[ii];
        tm[u] = max(tm[u], upd[u]);
        for (int v: g[u])
            uax(upd[v], upd[u]);
    }
}

int get1(int u) {
    int res = tm[u];
    for (auto op: o)
        if (bs[op.first][u - L])
            uax(res, op.second);
    return res;
}

vector<int> q2;

void calc2(int l, int r) {
    int k = l / sn;
    forn (i, n)
        a[k][i] = maxc;
    for (int i = l; i < r; ++i) {
        int id = q2[i];
        uin(a[k][qu[id]], qx[id]);
    }
    for (int ii = n - 1; ii >= 0; --ii) {
        int u = ord[ii];
        for (int v: g[u])
            uin(a[k][v], a[k][u]);
    }
}

int get2(int u, int l, int r) {
    l = lower_bound(q2.begin(), q2.end(), l) - q2.begin();
    r = lower_bound(q2.begin(), q2.end(), r) - q2.begin();
    int res = maxc;
    int l2 = ((l + sn - 1) / sn) * sn;
    int r2 = (r / sn) * sn;
    if (l2 > r2) {
        for (int i = l; i < r; ++i) {
            int id = q2[i];
            int v = qu[id];
            if (bs[v][u - L])
                uin(res, qx[id]);
        }
    } else {
        for (int i = l; i < l2; ++i) {
            int id = q2[i];
            int v = qu[id];
            if (bs[v][u - L])
                uin(res, qx[id]);
        }
        for (int i = r2; i < r; ++i) {
            int id = q2[i];
            int v = qu[id];
            if (bs[v][u - L])
                uin(res, qx[id]);
        }
        l2 /= sn, r2 /= sn;
        for (int i = l2; i < r2; ++i)
            uin(res, a[i][u]);
    }
    return res;
}

int main() {
    #ifdef LOCAL
    assert(freopen("test.in", "r", stdin));
    #endif
    int m, q;
    cin >> n >> m >> q;
    forn (i, m) {
        int u, v;
        scanf("%d%d", &u, &v);
        --u, --v;
        g[u].push_back(v);
    }
    forn (i, n)
        if (!used[i])
            pre(i);
    forn (i, q) {
        int t, u, x = -1;
        scanf("%d%d", &t, &u);
        --u;
        if (t != 3)
            scanf("%d", &x);
        qt[i] = t, qu[i] = u, qx[i] = x;
    }

    forn (i, q) {
        if (qt[i] != 2)
            continue;
        q2.push_back(i);
    }
    for (int i = 0; i + sn <= sz(q2); i += sn)
        calc2(i, i + sn);

    for (L = 0; L < n; L += block) {
        R = min(n, L + block);
        forn (i, n) {
            bs[i].reset();
            tm[i] = -1;
        }
        o.clear();

        forn (i, n) {
            int u = ord[i];
            if (L <= u && u < R)
                bs[u][u - L] = true;
            for (int v: g[u])
                bs[u] |= bs[v];
        }

        forn (id, q) {
            if (qt[id] == 3) {
                int u = qu[id];
                if (u < L || u >= R)
                    continue;
                int lb = get1(u);
                int val = lb >= 0 ? qx[lb] : 0;
                uin(val, get2(u, lb, id));
                qans[id] = val;
            }
            if (qt[id] == 1)
                put1(qu[id], id);
        }
    }
    forn (i, q) {
        if (qt[i] == 3)
            cout << qans[i] << '\n';
    }
}

```

###

[Original](http://www.voidcn.com/blog/ta201314/)


[Chinese guy](http://softgoorm.tistory.com/78)


```cpp
#include <cstdio>
#include <cstdlib>
#include <cmath>
#include <algorithm>
#include <vector>
#include <stack>
#include <queue>
#include <functional>
#include <cstring>
#include <string>
#include <map>
#include <set>
#include <iostream>
#include <sstream>
#include <complex>
#include <cassert>
#include <bitset>
 
#define enp     puts("**chkchkchkchkchk**")
#define A       first
#define B       second
#define MP      make_pair
 
using namespace std;
 
typedef long long ll;
typedef unsigned int uint;
 
const int INF = 0x60000000;
const int MINF = -1000000000;
const int mod = 1000000007;
const int cons = 100001;
const double pi = 3.141592653589793;
const int sqrtMax = 500;
const int blocks = 25001;
 
vector < vector <int> > adj;
int qu[cons][3];
int q2[cons];
int q2n;
vector <int> tord;
bool visited[cons];
int a[sqrtMax][cons];
int L, R;
int sq;
bitset <blocks> bs[cons];
vector < pair <int, int=""> > tmp;
int prevId[cons];
int n, m, q;
int ans[cons];
bool chk[1001];
 
void dfs(int u)
{
    if (visited[u])return;
    visited[u] = true;
    for (auto v : adj[u])dfs(v);
    tord.push_back(u);
}
 
void put1(int u, int id)
{
    tmp.emplace_back(u, id);
    if (tmp.size() < sq)return;
    for (auto it : tmp)prevId[it.A] = max(prevId[it.A], it.B);
    tmp.clear();
 
    for (int i = n - 1; i >= 0; i--)
    {
        int u = tord[i];
 
        for (auto v : adj[u])
        {
            prevId[v] = max(prevId[u], prevId[v]);
        }
    }
}
 
int get1(int u)
{
    int ret = prevId[u];
 
    for (auto it : tmp)
    {
        if (bs[it.A][u - L])ret = max(ret, it.B);
    }
 
    return ret;
}
 
int get2(int u, int l, int r)
{
    if (q2n == 0)return 1e9;
    int ret = 1e9;
 
    l = lower_bound(q2, q2 + q2n, l) - q2;
    r = lower_bound(q2, q2 + q2n, r) - q2 - 1;
 
    if (l / sq < r / sq)
    {
        int lim = ((l + sq) / sq)*sq;
 
        for (int i = l; i < lim; i++)
        {
            int id = q2[i];
            int v = qu[id][1];
            if (bs[v][u - L])ret = min(ret, qu[id][2]);
        }
 
        l = lim;
        while (l / sq < r / sq)
        {
            int cur = l / sq;
            ret = min(ret, a[cur][u]);
            l += sq;
        }
        l = (l / sq)*sq;
    }
 
    for (int i = l; i <= r; i++)
    {
        int id = q2[i];
        int v = qu[id][1];
        if (bs[v][u - L])ret = min(ret, qu[id][2]);
    }
 
    return ret;
}
 
int main()
{
    scanf("%d%d%d", &n, &m, &q);
 
    sq = sqrtMax;
    adj.resize(n + 1);
 
    for (int i = 0; i < m; i++)
    {
        int u, v;
        scanf("%d%d", &u, &v);
        u--;
        v--;
        adj[u].push_back(v);
    }
 
    for (int i = 0; i < n; i++)
    {
        if (visited[i])continue;
        dfs(i);
    }
 
    for (int i = 0; i < q; i++)
    {
        int t, u, x = -1;
        scanf("%d%d", &t, &u);
        if (t != 3)scanf("%d", &x);
 
        u--;
        qu[i][0] = t;
        qu[i][1] = u;
        qu[i][2] = x;
 
        if (t == 2)q2[q2n++] = i;
    }
 
    for (int i = 0; i < q2n; i++)
    {
        int id = q2[i];
        int u = qu[id][1];
        int x = qu[id][2];
 
        if (!chk[i / sq])
        {
            chk[i / sq] = true;
            for (int j = 0; j < n; j++)
            {
                a[i / sq][j] = 1e9;
            }
        }
 
        a[i / sq][u] = min(a[i / sq][u], x);
    }
 
    for (int i = n - 1; i >= 0; i--)
    {
        int u = tord[i];
 
        for (auto v : adj[u])
        {
            for (int j = 0; j < (q2n/sq) + 1; j++)
            {
                a[j][v] = min(a[j][v], a[j][u]);
            }
        }
    }
 
    for (L = 0; L < n; L += blocks)
    {
        R = min(n, L + blocks);
 
        tmp.clear();
        for (int i = 0; i < n; i++)
        {
            bs[i].reset();
            prevId[i] = -1;
        }
 
        for (int i = 0; i < n; i++)
        {
            int u = tord[i];
            if (u >= L && u < R)bs[u][u - L] = true;
            for (auto v : adj[u])bs[u] |= bs[v];
        }
 
        for (int i = 0; i < q; i++)
        {
            if (qu[i][0] == 3)
            {
                int u = qu[i][1];
                if (u < L || u >= R)continue;
 
                int l = get1(u);
                int res = 0;
                if (l != -1)res = qu[l][2];
                res = min(res, get2(u, l, i));
                ans[i] = res;
            }
            else if (qu[i][0] == 1)
            {
                put1(qu[i][1], i);
            }
        }
    }
 
    for (int i = 0; i < q; i++)
    {
        if (qu[i][0] == 3)printf("%d\n", ans[i]);
    }
 
    return 0;
}
```
