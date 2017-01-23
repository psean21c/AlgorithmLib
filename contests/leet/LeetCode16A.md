
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


### Similar Questions
[AlgoSpot question](https://algospot.com/forum/read/1955/#c9436)

https://www.acmicpc.net/problem/7578

```
이 문제는, 
먼저 기계의 식별 번호들을 단순화 시켜 순열(permutation)을 만든다.
예제에 나온 데이터로 예를 들자면, 
윗 줄에 132 392 311 351 231이 나와 있고, 
아래 줄에 392 351 132 311 231이 나와 있는데, 
윗줄의 132는 아랫줄의 3번째, 윗줄의 392는
아랫줄의 1번째 ... 와 같은 순서로 단순화시킬 수 있다.
예제로 나온 데이터에서의 순열은 3 1 4 2 5가 된다.
그다음 순열의 첫 번째부터 순서대로 보면서, 
이전 순열에서 현재 순열 값보다 큰 값이 나온 경우가 교차했다는 의미이므로, 
이전 순열에서 자기보다 큰 값이 나온 횟수를 세야한다.
이 과정에서 binary indexed tree를 구성하면 
O(nlogn) 시간에 이 횟수를 구할 수 있다.
그 다음 현재의 순열 값을 binary indexed tree에 누적시킨다. 
이 과정 역시 O(nlogn) 시간에 할 수 있다.
순열의 마지막까지 이 횟수들을 더해가면, 
O(nlogn)간 복잡도로 해를 구할 수 있다.
이 방법으로 해결할 경우 만점을 받도록 test case가 구성되어 있다


==========================
문제를 단순화하면 '1 2 3 4 5' 와 '3 1 4 2 5' 을 매칭되는 대로 그을 때 교차점의 개수를 세는 것이죠? 

A[] = {3, 1, 4, 2, 5} 로 가정하겠습니다. (여기서 A를 순열이라고 표현했습니다)

앞에서부터 차례대로 보면서, 각 A[i] 에 대해,
A1..i-1 중 A[i] 보다 큰 것의 개수를 센 뒤 이들을 모두 합하면 답이 됩니다 (왜그런지는 그림 그리면서 생각해보세요)

예를 들자면

[3] : 0
3 [1] : 1 (1보다 큰 것 이전에 한개)
3 1 [4] : 0 (4보다 큰 것 이전에 없음)
3 1 4 [2] : 2 (2보다 큰 것 3, 4 두개)
3 1 4 2 [5] : 0 (5보다 큰 것 없음)
이니까 답이 0+1+0+2+0 = 3 이 됩니다.

그러면 이 개수를 어떻게 세냐 하면, binary indexed tree 라는 자료구조를 사용한다는 것입니다. 이 자료구조의 연산은

add(x) : x를 집합에 추가
count(x) : 이미 집합에 들어있는 것 중 x 보다 큰 것의 개수
이며, O(log n)에 구현할 수 있습니다. 이 부분이 궁금하면 다시 코멘트 주세요~

```
