#


###

구종만 씨의 책 서문을 읽으면서 그 사람이 말한 프로그램 대회에 나가는 장점에 대한 이야기를 아래와 같이 읽었다. 

```
1. 문제 해결에만 집중
2. 알고리듬에 대한 깊은 이해
3. 단위 테스트 프로그램에 충실 
   => 결국은 Quality의 문제로 귀결된다. (회사에서 이러한 문화에 대한 진정한 고민이 필요한 이유이다.)
4. 프로그램의 효율성과 퍼포먼스가 좋아진다.
5. 좋은 코드를 작성하는 연습
6. 고수의 코드를 배우는 기회
```

현재 한국인으로서 높은 성적을 내고 있는 LG에 근무하는 한 개발자 분은 다음과 같이 나에게 말했다. 

`"Algorithm contest를 만나고 제 삶이 바뀌었습니다.정말로 바뀌었어요. 새로운 것을 시도해보게되고, 회사 내에서도 어느정도 알려지면서 많은 변화가 생겼습니다." ` 

개발자라는 직업을 가진 사람 입장에서 이보다 더 좋은 변화가 있을까.. 
나는 프로그램 대회를 자주 참석하고 그를 위한 연습을 하는 과정들이.. 보다 근본적인 면에서 다음과 같은 장점들이 있다는 것을 느꼈다. 

1. 새로운 문제를 해결해야 하는 상황에 대한 두려움을 극복하게 된다.
2. 필요에 의한 도구 사용 방법을 익히는 습관을 갖게 된다.

 언어를 배우는 과정이 힘든 이유 중 하나는 언제/어디에서 사용해야 하는지 정확하게 필요한 상황을 이해하지 못하고 그냥 프로그램을 실행해보기만 하기 때문이다. 언어를구성하고 표현할 때 필요한 수많은 문법과 언어를 구성하는 환경에 대해서..  ‘이론을 위한’ 이론이 아닌 ‘문제 해결의 과정에서 필요한 도구적’ 관점을 가지고 배우게 된다.
3. 집중력 이야기

  (앞의 저자의 이야기와 중복되는 부분도 있지만) 생활과 업무 간에 필요한 
  수많은 사건들 사이에서 업무에서 필요한..전체적인 집중력을 잃지 않는다..

# To do

### 1

[Minimize Summation](https://www.hackerrank.com/contests/101hack43/challenges/minimizing-the-summation)

### 2) Review the previous questions..(go to w24 folder)

[Review week24](https://www.hackerrank.com/contests/w24/challenges/xor-matrix)


### 3) Next Topological Sorting (DAQ)
[Next Topological Sorting](https://www.hackerrank.com/contests/101hack40/challenges/next-topological-sorting)

[CodeForce](http://codeforces.com/contest/707/problem/C)


### 4) 구글코드잼 라운드1C B 문제
https://code.google.com/codejam/contest/4314486/dashboard#s=p1

https://raw.githubusercontent.com/…/2016/round1_c/b/main.cpp

https://en.wikipedia.org/wiki/Hamming_weight


[test](korea.. karljang / bluedawnstar / noeffserv/ singleheart/ kcm1700 /shinsy11/ 
      japan .. piczaw / pekempey
      usa .. tina_heiligers
)

[Big Data Scientist](https://www.linkedin.com/in/christianeheiligers)



---
### Day1
```cpp

#include <cmath>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;


int main(){
    int n;
    cin >> n;
    int p;
    cin >> p;
    // your code goes here
    int front = (p-1)/2;
    if((p-1)%2!=0) front++;

    int back = (n-p)/2;
    if(p%2!=0 and (n-p)%2!=0){
        back++;
    }

    int page = min(front,back);
    cout << page << endl;
    return 0;
}

```

### Day2

```cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int main() {
	int n, p;
	cin >> n >> p ;
	vector<int> arr(n);

	for (int i = 0; i < n; i++) {
		int a,b;
		cin >> a;
		b = a / p;
		if(a%p!=0) b+=1;
		arr[i] = b;
	}


	sort(arr.begin(), arr.end());
	long sum = arr[0];
	int c = arr[0];
	for (int i = 1; i < n; i++) {
		//cout << arr[i] << " " << endl;
		int d = arr[i];
		if(c>=d) sum += (++c);
		else {
			sum += d;
			c = d;
		}
	}
	cout << sum << endl;
	return 0;
}


```

