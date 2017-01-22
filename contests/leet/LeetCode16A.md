
Input
```
DIDD
```

Output
```
2 1 5 4 3 
```

Explain
```
1) String s = 'DIDD'
D : Decrease
I : Increase
2) length of s = 4
3) make new list or array for length n(=s + 1)  (5 = 4 + 1) with number (1 ... n)
  [1,2,3,4,5]
4) find the smallest lexigraphical permutation
Both are fine because it follows the instruction : DIDD
3,1,5,4,2 (D: 3->1, I: 1->5, D: 5->4, D: 4->2)
2,1,5,4,3 (D: 2->1, I: 1->5, D: 5->4, D: 4->3)

5) However,
2,1,5,4,3 is the smallest permutation
```
One coder used Fenwick algorithm to solve this problem..

[AlgoSpot question](https://algospot.com/forum/read/1955/#c9436)



```cpp
// Author: rrrl8523690
class Solution {
public:
    vector<int> findPermutation(string s) {
        priority_queue<int, vector<int>, greater<int>> q;
        int n = s.size() + 1;
        vector<vector<int>> adj(n);
        vector<int> ind(n);
        for (int i = 0; i + 1 < n; i++) {
            if (s[i] == 'D') {
                adj[i + 1].push_back(i);
                ind[i]++;
            } else {
                adj[i].push_back(i + 1);
                ind[i + 1]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!ind[i]) {
                q.push(i);
            }
        }
        vector<int> ans(n);
        int k = 0;
        while (!q.empty()) {
            int s = q.top();
            ans[s] = ++k;
            q.pop();
            for (auto it : adj[s]) {
                if (!--ind[it]) {
                    q.push(it);
                }
            }
        }
        return ans;
    }
};

```

```cpp
// Author: maskray

#include <iostream>
#include <cstddef>
#include <cmath>
#include <vector>
#include <algorithm>
#include <time.h>

using namespace std;

#define FOR(i,n) for(unsigned int i = 0; i < (n); ++i)
#define FOR1(i,n) for(int i = 1; i < (n); ++i)

class Solution {
	int n;
	vector<int> fenwick;
	void add(int x, int d) {
		for (int i = 0; x < n; x |= x + 1) {
			fenwick[x] += d;
//			cout << x << "|" << (x + 1) << " = " << (x | (x+1)) << endl;
		}
	}

	int select(int k) {
		int r = -1, c = 0;
		int z = __builtin_clz(n);
		for (int i = 1 << (31 - z) ; i; i >>= 1){
			if (r + i < n && c + fenwick[r + i] <= k) {
				c += fenwick[r += i];
			}
		}
		add(r + 1, -1);
		return r + 1;
	}
	void printFenwick(){
	    for(unsigned int i=0;i<fenwick.size();i++){
	        cout << fenwick[i] << " ";
	    }
		cout << endl;
	}

public:
	vector<int> findPermutation(string s) {
		n = s.size() + 1;
		fenwick.assign(n, 0);

//	    for(unsigned int i=0;i<fenwick.size();i++){
//	        cout << i << " ";
//	    }
//
//		cout <<endl <<  "--------------------" <<endl;
		for (int i = 0; i < n; i++){
			add(i, 1);
//			printFenwick();
		}

		vector<int> r;
		for (unsigned int i = 0; i < s.size();){
			if (s[i] == 'I') {
				r.push_back(select(0) + 1);
				i++;
			} else {
				unsigned int j = i;
				while (j < s.size() && s[j] == 'D')
					j++;
				for (int k = j - i; k; k--)
					r.push_back(select(k) + 1);
				i = j;
			}
		}
		r.push_back(select(0) + 1);
		return r;
	}
};

int main() {

	time_t timer = clock();

	string s;
	cin >> s;
//	string s = "DID";

	Solution * sol = new Solution;
	vector<int> v = sol->findPermutation(s);

	cout << "===========================" <<endl;
    for(unsigned int i=0;i<v.size();i++){
        cout << v[i] << " ";
    }

	delete sol;


	cout << endl<< "timed out: " << (double) (clock() - timer) / CLOCKS_PER_SEC << endl;
	return 0;
}

```

