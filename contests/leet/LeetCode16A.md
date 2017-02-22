
### Find Permutation

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

### Solution -1
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


### Solution -2

One coder used Fenwick algorithm to solve this problem..

[My GitHub](https://github.com/psean21c/Algorithm/blob/master/DataStructure/fenwick/FindPermutationLeet16A.md)



