# Chess Game

###

[Original Question](https://www.hackerrank.com/contests/w24/challenges/simplified-chess-engine)

```cpp

#include <bits/stdc++.h>
using namespace std;

#define FOR(i,n) for(int i = 0; i < (n); ++i)

string ls = "~QNBR";
enum { QUEEN = 1, KNIGHT, BISHOP, ROOK, };

const int dy[5][8] = {
	{},
	{ 1, 1, 1, 0, 0, -1, -1, -1 },
	{ 1, 2, 2, 1, -1, -2, -2, -1 },
	{ 1, 1, -1, -1 },
	{ 1, 0, -1, 0 },
};

const int dx[5][8] = {
	{},
	{ 1, 0, -1, 1, -1, 1, 0, -1 },
	{ 2, 1, -1, -2, -2, -1, 1, 2 },
	{ 1, -1, 1, -1 },
	{ 0, 1, 0, -1 },
};

const int dn[5] = { -1, 8, 8, 4, 4 };

const int N = 4;
int g[N][N];
map<uint64_t, bool> dp[20];

uint64_t get_mask() {
	uint64_t res = 0;
	for (int i = 0; i < N * N; i++) {
//		cout << "i(" << i << "): g[" << (i / N)  << "][" << (i % N) << "]=" << g[i / N][i % N] << "\t";
//		cout << uint64_t(g[i / N][i % N] + 4) <<  "<<" << (4LL * i) << "=" <<uint64_t(g[i / N][i % N] + 4) << (4LL * i) << "\t";
//		cout << res << " ";
		res |= uint64_t(g[i / N][i % N] + 4) << (4LL * i);
//		cout << res << " " << endl;
	}
	return res;
}

void printGraph(){
		FOR(i,N){
			FOR(j,N){
				cout << g[i][j] << " ";
			}
			cout << endl;
		}
}

bool dfs(int rem, int turn) {
	if (rem == 0) return turn;
//	auto key = get_mask();
//	if (dp[rem].count(key)) return dp[rem][key];
	printGraph();
	FOR(i,N*N){
		g[i / N][i % N] *= -1;
	}
	cout << "======after (-1)==========" << endl;
	printGraph();
	bool isAny = false;
	FOR(i,N){
		FOR(j,N){
			int graph = g[i][j];
			if (graph >= 0) continue;
			for (int k = 0; k < dn[-graph]; k++) {
				int y = i;
				int x = j;
				while (true) {
					y += dy[-graph][k];
					x += dx[-graph][k];
					if (y < 0 || x < 0 || y >= N || x >= N) break;
					if (g[y][x] < 0) break;
					if (g[y][x] == QUEEN) {
						isAny = true;
						goto loopend;
					}
					if (g[y][x] != 0) break;
				}
			}
		}
	}
	FOR(i,N){
		FOR(j,N){
			int graph = g[i][j];
			if (graph >= 0) continue;
			for (int k = 0; k < dn[-graph]; k++) {
				int y = i;
				int x = j;
				while (true) {
					y += dy[-graph][k];
					x += dx[-graph][k];
					if (y < 0 || x < 0 || y >= N || x >= N) break;
					if (g[y][x] < 0) break;
					int prev = g[y][x];
					int prev2 = graph;
					g[y][x] = graph;
					g[i][j] = 0;
					isAny |= !dfs(rem - 1, turn ^ 1);
					g[y][x] = prev;
					g[i][j] = prev2;
					if (isAny) goto loopend;
					if (g[y][x] != 0) break;
				}
			}
		}
	}
loopend:;
	for (int i = 0; i < N * N; i++) g[i / N][i % N] *= -1;
//	dp[rem][key] = isAny;
	return isAny;
}

void solve() {
	memset(g, 0, sizeof(g));

	for (int i = 0; i < 20; i++) {
		dp[i].clear();
	}

	int w, b, m;
	cin >> w >> b >> m;

	for (int i = 0; i < w; i++) {
		string s, t;
		int x;
		cin >> s >> t >> x;

		//cout << ( t[0] - 'A') << "," << (x-1) << "," << ls.find(s[0])<< endl;
		g[t[0] - 'A'][x - 1] = ls.find(s[0]);
	}
	for (int i = 0; i < b; i++) {
		string s, t;
		int x;
		cin >> s >> t >> x;
		g[t[0] - 'A'][x - 1] = -ls.find(s[0]);
	}



	puts(dfs(m, 0) ? "YES" : "NO");
}

int main() {
	int g;
	cin >> g;
	while (g--) solve();
}

```

```
10
4 5 4
R B 1
R C 2
B C 4
Q A 4
R B 2
N A 3
B D 3
R C 3
Q C 1
2 1 3
N B 1
Q A 3
Q D 3
5 5 6
B B 1
R C 4
B D 2
R A 4
Q B 4
B A 3
N A 1
R D 3
R C 3
Q D 1
2 1 4
R B 1
Q B 3
Q C 3
4 2 4
B C 4
B D 2
R B 2
Q A 1
B C 3
Q C 1
1 4 6
Q B 1
R C 2
N C 4
B B 2
Q C 1
5 4 1
R C 2
N C 4
N D 2
R A 4
Q B 4
R A 1
B C 3
B A 2
Q D 1
4 2 1
R B 1
N C 2
B C 4
Q D 2
N B 4
Q D 3
5 5 3
B B 1
R A 1
B C 1
R A 4
Q B 4
R B 3
R B 2
B A 3
B A 2
Q D 1
5 4 6
R B 1
B D 2
R D 4
B B 3
Q C 1
B D 3
B C 3
R A 2
Q B 2
```

output
```
YES
YES
NO
YES
YES
YES
NO
YES
NO
YES
```
