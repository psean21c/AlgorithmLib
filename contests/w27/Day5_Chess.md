

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


```cpp
// smileyyoungman
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <memory.h>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <unordered_map>

using namespace std;

typedef long long I64;
typedef unsigned long long U64;

#define P_Q     'Q'
#define P_R     'R'
#define P_N     'N'
#define P_B     'B'
#define P_P     'P'

struct Piece {
    int type;
    int row;
    int col;
};

struct Move {
    int idx;
    int row;
    int col;
};

struct Board {
    bool isWhite;
    int bd[4][4];

    int n;
    Piece p[8];

    Board() {
        memset(this, 0, sizeof(Board));
    }

    Board(const Board& r) {
        memcpy(this, &r, sizeof(Board));
    }

    Board& operator =(const Board& r) {
        if (this != &r)
            memcpy(this, &r, sizeof(Board));
        return *this;
    }
};

void movePiece(Board& mb, int index, int newR, int newC) {
    if (index < 0 || index >= mb.n)
        return;

    int curR = mb.p[index].row;
    int curC = mb.p[index].col;

    swap(mb.bd[curR][curC], mb.bd[newR][newC]);

    mb.p[index].row = newR;
    mb.p[index].col = newC;
}

void erasePiece(Board& eb, int index) {
    if (index < 0 || index >= eb.n)
        return;

    int r = eb.p[index].row;
    int c = eb.p[index].col;

    eb.bd[r][c] = 0;
    eb.n--;
    for (int i = index; i < eb.n; i++)
        eb.p[i] = eb.p[i + 1];
    eb.p[eb.n] = Piece{ 0, 0, 0 };
}

static bool getMovable_Straight(const Board& mb, const Board& eb, int row, int col, int dx, int dy, int index, vector<Move>& out) {
    for (int i = 1; i < 4; i++) {
        int cc = col + dx * i;
        int rr = row + dy * i;
        if (cc < 0 || cc >= 4 || rr < 0 || rr >= 4)
            break;

        if (mb.bd[rr][cc])
            break;

        if (eb.bd[rr][cc]) {
            if (eb.bd[rr][cc] == P_Q)
                return true;
            out.insert(out.begin(), Move{ index, rr, cc });
            break;
        }
        out.push_back(Move{ index, rr, cc });
    }
    return false;
}

bool getMovable_Queen(const Board& mb, const Board& eb, int row, int col, int index, vector<Move>& out) {
    static int off[][2] = { { -1, -1 },{ -1, 0 },{ -1, 1 },{ 0, -1 },{ 0, 1 },{ 1, -1 },{ 1, 0 },{ 1, 1 } };
    for (int i = 0; i < 8; i++) {
        if (getMovable_Straight(mb, eb, row, col, off[i][0], off[i][1], index, out))
            return true;
    }
    return false;
}

bool getMovable_Rook(const Board& mb, const Board& eb, int row, int col, int index, vector<Move>& out) {
    static int off[][2] = { { -1, 0 },{ 1, 0 },{ 0, -1 },{ 0, 1 } };
    for (int i = 0; i < 4; i++) {
        if (getMovable_Straight(mb, eb, row, col, off[i][0], off[i][1], index, out))
            return true;
    }
    return false;
}

bool getMovable_Bishop(const Board& mb, const Board& eb, int row, int col, int index, vector<Move>& out) {
    static int off[][2] = { { -1, -1 },{ -1, 1 },{ 1, -1 },{ 1, 1 } };
    for (int i = 0; i < 4; i++) {
        if (getMovable_Straight(mb, eb, row, col, off[i][0], off[i][1], index, out))
            return true;
    }
    return false;
}

bool getMovable_Knight(const Board& mb, const Board& eb, int row, int col, int index, vector<Move>& out) {
    static int off[][2] = { { -2, -1 },{ -2, 1 },{ 2, -1 },{ 2, 1 },{ -1, -2 },{ 1, -2 },{ -1,  2 },{ 1,  2 } };

    for (int i = 0; i < 8; i++) {
        int cc = col + off[i][0];
        int rr = row + off[i][1];
        if (cc < 0 || cc >= 4 || rr < 0 || rr >= 4)
            continue;

        if (mb.bd[rr][cc])
            continue;

        if (eb.bd[rr][cc]) {
            if (eb.bd[rr][cc] == P_Q)
                return true;
            out.insert(out.begin(), Move{ index, rr, cc });
        } else {
            out.push_back(Move{ index, rr, cc });
        }
    }
    return false;
}

bool getMovable_Pawn(const Board& mb, const Board& eb, int row, int col, int index, vector<Move>& out) {
    int dy = mb.isWhite ? 1 : -1;

    static int off[] = { -1, 1, 0 };
    for (int i = 0; i < 3; i++) {
        int cc = col + off[i];
        int rr = row + dy;
        if (cc < 0 || cc >= 4 || rr < 0 || rr >= 4)
            continue;

        if (mb.bd[rr][cc])
            continue;

        if (off[i] != 0) {
            if (eb.bd[rr][cc]) {
                if (eb.bd[rr][cc] == P_Q)
                    return true;
                out.insert(out.begin(), Move{ index, rr, cc });
            }
        } else {
            if (eb.bd[rr][cc])
                continue;
            out.push_back(Move{ index, rr, cc });
        }
    }
    return false;
}

// (index, (row, col))
bool getAllMoves(const Board& mb, const Board& eb, vector<Move>& out) {
    for (int i = 0; i < mb.n; i++) {
        int r = mb.p[i].row;
        int c = mb.p[i].col;
        switch (mb.p[i].type) {
        case P_Q:
            if (getMovable_Queen(mb, eb, r, c, i, out))
                return true;
            break;
        case P_R:
            if (getMovable_Rook(mb, eb, r, c, i, out))
                return true;
            break;
        case P_B:
            if (getMovable_Bishop(mb, eb, r, c, i, out))
                return true;
            break;
        case P_N:
            if (getMovable_Knight(mb, eb, r, c, i, out))
                return true;
            break;
        case P_P:
            if (getMovable_Pawn(mb, eb, r, c, i, out))
                return true;
            break;
        }
    }
    return false;
}

bool play(Board& mb, Board& eb, int m, bool isWhite) {
    if (isWhite) {
        if (m <= 0)
            return false;

        vector<Move> moves;
        if (getAllMoves(mb, eb, moves))
            return true;

        for (auto& it : moves) {
            Board mb2 = mb;
            Board eb2 = eb;

            if (eb2.bd[it.row][it.col]) {
                for (int i = 0; i < eb2.n; i++) {
                    if (eb2.p[i].row == it.row && eb2.p[i].col == it.col) {
                        erasePiece(eb2, i);
                        break;
                    }
                }
            }
            movePiece(mb2, it.idx, it.row, it.col);

            if (mb2.p[it.idx].type == P_P && it.row == 3) {
                mb2.p[it.idx].type = P_B;
                mb2.bd[it.row][it.col] = P_B;
                if (play(eb2, mb2, m - 1, !isWhite))
                    return true;

                mb2.p[it.idx].type = P_R;
                mb2.bd[it.row][it.col] = P_R;
                if (play(eb2, mb2, m - 1, !isWhite))
                    return true;

                mb2.p[it.idx].type = P_N;
                mb2.bd[it.row][it.col] = P_N;
                if (play(eb2, mb2, m - 1, !isWhite))
                    return true;
            } else {
                if (play(eb2, mb2, m - 1, !isWhite))
                    return true;
            }
        }

        return false;
    } else {
        if (m <= 1)
            return false;

        vector<Move> moves;
        if (getAllMoves(mb, eb, moves))
            return false;

        for (auto& it : moves) {
            Board mb2 = mb;
            Board eb2 = eb;

            if (eb2.bd[it.row][it.col]) {
                for (int i = 0; i < eb2.n; i++) {
                    if (eb2.p[i].row == it.row && eb2.p[i].col == it.col) {
                        erasePiece(eb2, i);
                        break;
                    }
                }
            }
            movePiece(mb2, it.idx, it.row, it.col);

            if (mb2.p[it.idx].type == P_P && it.row == 0) {
                mb2.p[it.idx].type = P_B;
                mb2.bd[it.row][it.col] = P_B;
                if (!play(eb2, mb2, m - 1, !isWhite))
                    return false;

                mb2.p[it.idx].type = P_R;
                mb2.bd[it.row][it.col] = P_R;
                if (!play(eb2, mb2, m - 1, !isWhite))
                    return false;

                mb2.p[it.idx].type = P_N;
                mb2.bd[it.row][it.col] = P_N;
                if (!play(eb2, mb2, m - 1, !isWhite))
                    return false; 
            } else {
                if (!play(eb2, mb2, m - 1, !isWhite))
                    return false;
            }
        }

        return true;
    }
}

int main(void) {
    char s1[10], s2[10];

    int T;
    scanf("%d", &T);

    while (T-- > 0) {
        int W, B, M;
        Board wb, bb;
        //memset(&wb, 0, sizeof(wb));
        //memset(&bb, 0, sizeof(bb));

        scanf("%d %d %d", &W, &B, &M);

        wb.isWhite = true;
        wb.n = 1;
        for (int i = 0; i < W; i++) {
            int t, c, r;
            scanf("%s %s %d", s1, s2, &r);
            t = s1[0]; c = s2[0] - 'A'; r--;

            int idx = 0;
            if (t != P_Q)
                idx = wb.n++;
            wb.p[idx] = Piece{ t, r, c };
            wb.bd[r][c] = t;
        }

        bb.isWhite = false;
        bb.n = 1;
        for (int i = 0; i < B; i++) {
            int t, c, r;
            scanf("%s %s %d", s1, s2, &r);
            t = s1[0]; c = s2[0] - 'A'; r--;

            int idx = 0;
            if (t != P_Q)
                idx = bb.n++;
            bb.p[idx] = Piece{ t, r, c };
            bb.bd[r][c] = t;
        }

        printf("%s\n", play(wb, bb, M, true) ? "YES" : "NO");
    }

    return 0;
}
```
