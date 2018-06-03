
[Original Question](https://www.hackerrank.com/challenges/ctci-array-left-rotation)

input / output
```
5 4
1 2 3 4 5
==========
5 1 2 3 4

```
Explain
```
d=4 (4 left rotation)
0[1 2 3 4 5]
1[2 3 4 5 1]
2[3 4 5 1 2]
3[4 5 1 2 3]
4[5 1 2 3 4]

```


```cpp
#include <vector>
#include <iostream>

using namespace std;

vector<int> array_left_rotation(vector<int> a, int n, int k) {
// To do..
}

int main(){
    int n;
    int k;
    cin >> n >> k;
    vector<int> a(n);
    for(int i = 0;i < n;i++){
        cin >> a[i];
    }
    vector<int> output = array_left_rotation(a, n, k);
    for(int i = 0; i < n;i++)
        cout << output[i] << " ";
    cout << endl;
    return 0;
}

```

```cpp
vector<int> array_left_rotation(vector<int> a, int n, int k) {
	vector<int> result;
	int idx = k%n;
	for(unsigned int i=idx;i<a.size();i++){
		result.push_back(a[i]);
	}
	for(int i=0;i<idx;i++){
		result.push_back(a[i]);
	}

	return result;
}

```
