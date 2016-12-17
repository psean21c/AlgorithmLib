#


[Picking Numbers](https://www.hackerrank.com/contests/101hack44/challenges/picking-numbers)

A single integer denoting the maximum number of integers you can choose from the array 
such that the absolute difference between any two of the chosen integers is <=1.

The answer will be >=2



TestCase1
```
6
4 6 5 3 3 1

>> 3
```
Explain
```
1) sort
1 3 3 4 5 6

2) list
{1}      X
{3,3}
{3,3,4}
{4}      X
{4,5}
{5}      X
{5,6}
{6}      X

흘러가는 연속 가운데에서.. 현재와 (지금까지) 지나온 변화의 차이를 기준으로....
지금의 상태를 정확하게 기록을 해주는 것은 매우 어렵다..


array: 1 3 3 4 5 6
count:   1 2 3
count:       1 2
count:         1 2

```


TestCase2
```
6
1 2 2 3 1 2

>> 5
```

Explain
```
1) sort
1 1 2 2 2 3

2) list
{1,1}
{1,1,2,2,2}
{2,2,2,3}
```


TestCase3
```
11
1 2 4 2 3 3 1 2 4 4 4 

>> 6
```
Explain
```
1) sort
1 1 2 2 2 3 3 4 4 4 4

2) list

```

* My solution

내 방식으로 문제를 풀고 다른 사람의 방식을 비교해보니.. 나의 접근 방법이 좋지 않았다는 것을 알았다.

|After sorted| 1  | 1  | 2  | 2  |  2 |  3 | 3  | 4  | 4  | 4  |  4 |
| -----------|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
|Sub counted |  1 | 2  | 1  | 2  | 3  | 1  | 2  | 1  | 2  | 3  | 4  |

{1 1}{2 2 2} {3 3} {4 4 4 4}
  2       3      2        4
  2       5      5        6

내 전략은 정렬 후 동일한 숫자들의 부분합(SubCount)을 구하여 다음 숫자 그룹이 나올 때
조건(처음 그룹의 숫자와 나중 그룹의 숫자의 차이가 1보다 작은)이 맞을 경우 ...
그 두 그룹의 합을 계속 Max(first,second)값으로 비교해 나가는 방법이었다.


```cpp
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	int n = 0;
	cin >> n;
	vector<int> arr(n);

	for(int i=0;i<n;i++){
		cin >> arr[i];
	}

	sort(arr.begin(),arr.end());

	int subCnt = 0;
	int curCnt = 1;

	int maxNo = 0;

	// Logic start
	int prev = arr[0];
	for(unsigned int i=1;i<arr.size();i++){
		//cout << arr[i] << " ";
		int post = arr[i];
		int cnt = 0;

		if(post == prev) {
			curCnt++;
			if((i+1)==arr.size()){ // if it's the last
				cnt = curCnt + subCnt;
			}
		} else{

			cnt = curCnt + subCnt;
			if(post-prev <=1) {
				subCnt = curCnt;
			} else {
				subCnt = 0;
			}
			curCnt=1;
			prev = arr[i];
		}


		int maxSub = max(subCnt,cnt);
		maxNo = max(maxNo,maxSub);
	}

	cout << maxNo << endl;

}

```



