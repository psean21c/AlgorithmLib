

```cpp

#include <bits/stdc++.h>
using namespace std;

#define FOR(i,n) for(int i = 0; i < (n); ++i)

string ls = "~QNBRP";
enum { QUEEN = 1, KNIGHT, BISHOP, ROOK, PAWN = 5 };

const int dy[6][8] = {
	{},
	{ 1, 1, 1, 0, 0, -1, -1, -1 },
	{ 1, 2, 2, 1, -1, -2, -2, -1 },
	{ 1, 1, -1, -1 },
	{ 1, 0, -1, 0 },
	{ 0, 1, -1},
};

const int dx[6][8] = {
	{},
	{ 1, 0, -1, 1, -1, 1, 0, -1 },
	{ 2, 1, -1, -2, -2, -1, 1, 2 },
	{ 1, -1, 1, -1 },
	{ 0, 1, 0, -1 },
	{ 1, 1, 1},
};

const int dn[6] = { -1, 8, 8, 4, 4, 3 };

const int N = 4;
int g[N][N];
map<uint64_t, bool> dp[20];
int idx = 0;

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
		cout << endl;
}

bool dfs(int move, int turn) {
	if (move == 0) return turn;
	//cout << "=====\t" << move << "=====\t" << turn << "=====\t" << idx++<< endl;


	FOR(i,N*N) g[i / N][i % N] *= -1;
	bool isAny = false;
	FOR(i,N){
		FOR(j,N){
			int graph = g[i][j];
			if (graph >= 0) continue;
			bool isPawn = false;
			if (graph == -5) isPawn = true;
			for (int k = 0; k < dn[-graph]; k++) {
				int y = i;
				int x = j;
				while (true) {
					if (isPawn && k==0) break;
					if(isPawn && turn==1){
						y += dy[-graph][k];
						x += (-1* dx[-graph][k]);
					} else{
						y += dy[-graph][k];
						x += dx[-graph][k];
					}
					if (y < 0 || x < 0 || y >= N || x >= N) break;
					if (g[y][x] < 0) break;
					if (g[y][x] == QUEEN) {
						isAny = true;
						goto loopend;
					}
					if (g[y][x] != 0) break;
					if (isPawn) break;
				}
			}
		}
	}
	//cout << "Before attack" << endl;
	//printGraph();

	FOR(i,N){
		FOR(j,N){
			int graph = g[i][j];
			if (graph >= 0) continue;
			bool isPawn = false;
			if (graph == -5) isPawn = true;
			for (int k = 0; k < dn[-graph]; k++) {
				int y = i;
				int x = j;
				while (true) {
					if (isPawn && k > 0) break;
					if(isPawn && turn==1){
						y += dy[-graph][k];
						x += (-1* dx[-graph][k]);
					} else{
						y += dy[-graph][k];
						x += dx[-graph][k];
					}
					if (y < 0 || x < 0 || y >= N || x >= N) break;
					if (g[y][x] < 0) break;
					int prev = g[y][x];
					int prev2 = graph;
					g[i][j] = 0;
					//int nextTurn = turn ^ 1;
					//cout << turn << ",next turn=" << nextTurn << endl;
					if((isPawn && g[y][x] ==0)&& ((turn==0 && x == N-1) || (turn==1 && x == 0))){
						g[y][x] = -2;
						isAny |= !dfs(move - 1, turn ^ 1);
						g[y][x] = -3;
						isAny |= !dfs(move - 1, turn ^ 1);
						g[y][x] = -4;
						isAny |= !dfs(move - 1, turn ^ 1);
					} else {
						g[y][x] = graph;
						isAny |= !dfs(move - 1, turn ^ 1);
					}
					g[y][x] = prev;
					g[i][j] = prev2;
					if (isAny) goto loopend;
					if (g[y][x] != 0) break;
					if (isPawn) break;
				}
			}
		}
	}
loopend:;
	FOR(i,N*N) g[i / N][i % N] *= -1;
	return isAny;
}

void solve() {
	memset(g, 0, sizeof(g));

	int w, b, m;
	cin >> w >> b >> m;

	for (int i = 0; i < w; i++) {
		string s, t;
		int x;
		cin >> s >> t >> x;
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
