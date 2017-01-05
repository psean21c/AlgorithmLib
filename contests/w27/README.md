# 27주차 경연대회 후기

이번 대회에서는 5일차 chess게임이 나오면서 (지난 24주차에 비슷한 문제가 나왔는데) 그 문제는 풀지도 않고 넘어갔던 기억이 났다. 그래서 다시 그 문제를 풀어보기 위해서  pekempey라는 다른 (일본 여자) 사람의 해답을 하루종일 공부하고 그 다음날은 그 소스를 나의 것으로 변경해서 27주차 스스로의 답을 만들어보았다.

다른 사람의 소스를 공부하는 것은 장단점이 뚜렷하다는 생각을 했다.
장점이란 좋은 소스를 공부할 경우는 자기가 시도하지 않는 수많은 방법들을 배울 수 있었다. 반면 자기와 잘 맞고 배울 것이 많은 좋은 수준 높은 소스를 찾는 것은 많은 시간이 걸린다. 남의 소스를 이해하는 것은 자기가 처음부터 짜는 것보다 훨씬 많은 시간이 걸린다. 상대의 의도를 완벽하게 이해하지 않으면 내 것으로 만들기가 힘들기 때문이다.. 중요한 것은 좋은 소스라고해도.. 같은 문제에 대한 본인의 시도가 먼저 있지 않으면 상대의 소스에 대한 방법론에 숨겨 있는 좋은 아이디어를 잡아내기가 매우 쉽지 않다. 쉽게 말해 먼저 스스로 풀어보고 고생을 한 만큼 다른 사람의 방법론에 감탄을 하게 된다.

개인적으로 이러한 활동을 통해 마지막으로 직업적인 역량을 키우는 계기로 생각하게 되었다. 
너무 욕심내서 등수를 올리려고 하면 포기할 확률이 더 크다는 생각을 했다.

쉽지 않지만 매번 대회를 통해 나 스스로 부족하다는 것을 배우는 계기로 삼는 수 밖에 없다.

---
 `노영만 님에게 온 편지이다. 마치 제자에게 친절하게 설명하듯이 알려주어서 공부하는데 큰 길잡이가 될 것 같다..`

코딩 대회의 경쟁은 피할 수 없는 경쟁이 아니라 피할 수 있는 상황이기 때문에 압박이라기 보다는 기대감이 더 큰 것 같습니다.
누구를 이기겠다는 것보다는 내 힘으로 하나라도 더 풀고자 하는 마음이 더 큰 거 같아요.
그리고 그 결과로 등수가 더 올라갈 수 있으니 더 탄력을 받는 것 같구요.
제가 보기에는 상위권에 있는 사람들은 대부분 경쟁을 즐기는 것 같아 보입니다. ^^;

실제로 한국에서 같이 공부하는 친구들도 그런 말들을 해요. 서로 같이 참여하는 것이 자극도 되고 같이 하는 기분이 너무 좋다구요.
안 풀리다가도 누가 풀었다는 것을 보면 나도 풀 수 있겠다는 자신감도 생기기도 한다고 하네요.

저는 WoC 같은 경우 대회 중에 공부를 할 수 있어서 너무 좋습니다.
다른 short time 대회는 대회 중간에 오히려 압박이 상당하고, 끝나고 복기하면서 배우게 되는데,
WoC는 시간도 넉넉하기 때문에 여러가지 방법을 동원해서 풀어볼 수도 있고, 또 대회 중에 몰랐던 것도 공부하면서 풀 수 있어서 개인적으로는 좋습니다.

예를 들면 WoC 4일차 문제 같은 경우는 grundy number에 대해 이해하고 나면 너무 쉬운 문젠데
대회 전까지만 해도 저도 전혀 몰랐던 내용입니다.
대회 중에 찾아보고 새벽 5시까지 공부하고 나서 식을 세워보니 바로 풀리더라구요.
하나 알았을 때의 기쁨, 새로운 무기를 장착한 것 같은 기분이 들었습니다.

이번 대회 문제들도 참 좋네요.
다 풀어보셨으면 좋겠는데, 아래와 같은 관점에서 WoC 27 문제들을 review 해보셨으면 합니다.

    1. 4일차 문제
        - 말씀드린 것처럼 4일차 문제는 grundy number에 관한 문제입니다.
          아래 site에 grundy number에 대해서 잘 정리되어있으니 한 번 보시고 공식을 세워보시면 좋겠습니다.
          > http://letuskode.blogspot.kr/2014/08/grundy-numbers.html#!/2014/08/grundy-numbers.html
          > http://www.geeksforgeeks.org/combinatorial-game-theory-set-3-grundy-numbersnimbers-and-mex/

    2. 6일차 문제
        - 이 문제는 제가 풀이를 발견해 놓고서는 1은 특별해서 1과 1이 서로소라는 것을 생각하지 못해서 몇 개 테스트 케이스를 실패하는 바람에
           top 10 도전을 멈췄던 문제입니다. (그 전까지는 성적이 좋았는데, 대량 실점을 한 후 의욕이 꺾이더라구요 ㅋ)
        - 이 문제에서 배울 점이 아주 많습니다. 아래에 대해서 각각 공부한 다음에 문제에 다시 도전해보시는 것이 어떨까 합니다.
           1) 정수의 소인수 분해를 효과 적으로 하는 방법
                > 구종만님 책 1권 495 ~ 506 페이지에 있는 정수론 부분 중 소수 관련 내용 참고하시면  됩니다.
           2) LCA 구하는 방법 - O(logN) 시간에 LCA를 구할 수 있는 방법이 있습니다.
           3) MO's algorithm - query에 대해서 square root decomposition을 수행해서 O(N*Q) 시간을 O(Q sqrt(N) 정도의 시간으로 줄여줍니다.
               상위 ranker 들이 사용하는 고급 기법입니다.
                > http://www.geeksforgeeks.org/mos-algorithm-query-square-root-decomposition-set-1-introduction/
                > https://www.hackerrank.com/topics/mos-algorithm
           4) Tree에 MO's algorithm을 적용하기 위해, tree를 DFS 순회하면서 visit / exit time 기준으로 각 노드를 1차원 배열로 풀어내는 방법
               이 방법은 저도 처음 알았습니다. Tree에는 MO's algorithm 적용하기기 쉽지 않은데, tree를 1차원으로 펼쳐놓아 MO's algorithm을
               적용할 수 있도록 하는 기법입니다.
                > http://www.animeshf.com/posts/mo-s-algorithm-on-trees

    3. 7일차 문제
        - 7일차 문제는 50% 정답을 맞추는 것에 목표를 두시고 Suffix Array에 대해서 공부를 해보시는 게 어떨까합니다.
        - Suffix Array 생성 방법과 이 Suffix Array를 통해서 부분 문자열 개수를 세는 방법은 googling 하면 쉽게 구할 수 있습니다.
        - Suffix Array는 구종만님 책 2권 662 페이지에도 설명이 되어있습니다.
	
	WoC 27의 마지막날 문제를 review하면서 공부한 내용들입니다.

    - Fenwick tree - 구종만님 책 (p.754 ~)
      : Fenwick tree 앞에 있는 Segment tree와 함께 공부하시면 매우 좋습니다.
        Fenwick tree는 매우 간단하면서도 파워풀한 아주 재밌는 자료구조입니다.
        Fenwick tree와 segment tree는 익혀두시면 큰 힘이 될 것으로 생각합니다.
    - Suffix tree (http://www.geeksforgeeks.org/pattern-searching-set-8-suffix-tree-introduction/)
      : 굳이 이것까지는 공부할 필요를 못느꼈습니다.
    - Suffix automation (https://saisumit.wordpress.com/2016/01/26/suffix-automaton/, 
                        http://codeforces.com/blog/entry/8011?)
      : 이건 재밌는 구조였습니다. Suffix tree보다도 더 활용도가 높아보입니다.
        단, suffix automation 자체만 가지고는 성능이 잘 안나옵니다.
        그리고 사이트에서 제공하는 솔루션들이 map을 사용하고 있는데, 배열로 바꾸면 훨씬 빨라집니다.
        이 suffix automation은 fenwick tree나 segment tree, 
	그리고 아래 heavy / light decomposition 기법과 같이 사용하면 굉장히 강력한 툴이 될 것으로 생각이됩니다.
    - Heavy light decomposition (http://theyearlyprophet.com/heavy-light-decomposition.html)
      : 이것 정말 재밌는 알고리즘입니다. 위 사이트는 구종만님의 블로그에 소개된 내용인데요.
        Tree의 구간 연산(대표적인 것이 구간합)을 반복해서 해야할 경우 매우 유용합니다.
        알고리즘의 핵심은 자식이 많은 heavy node(위 블로그에 자세히 설명이 되어있습니다.)들을
        tree가 아닌 배열로 빼서 fenwick tree나 segment tree로 구간 연산을 빠르게 하고,
        남은 light node들은 tree에서 직접 조회를 하는 방법입니다.
        light node의 search는 log(N) 시간에 가능해지고, 
	heavy node들도 log(N)시간에 가능해져 전체적으로 log(N) 시간에 구간 연산을 할 수 있는 매우 재밌는 알고리즘입니다.

    => 공부할 가치가 있다고 생각하는 우선순위는...
        Fenwick tree / segment tree >> heavy light decomposition > suffix automation >> suffix tree (너무 어려워요)
	


---

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

프로그램 대회를 참석하고 그를 위한 연습을 하는 과정 중 .. 다음과 같은 장점들이 있다는 것을 느꼈다. 

```
1. 혼돈에 대한 두려움은 누구에게나 있다..
 새로운 문제를 해결해야 하는 상황에 대한 두려움을 극복하게 된다..

2. 무언가 필요한 상황에 바라보는 도구에 대한 인식..
 필요에 의한 도구 사용 방법을 익히는 습관을 갖게 된다. 
 언어를 배우는 과정이 힘든 이유 중 하나는 
 언제/어디에서 사용해야 하는지 정확하게 필요한 상황을 이해하지 못하고 
 그냥 프로그램을 실행해보기만 하기 때문이다. 
 언어를구성하고 표현할 때 필요한 수많은 문법과 언어를 구성하는 환경에 대해서..  
 ‘이론을 위한’ 이론이 아닌 ‘문제 해결의 과정에서 필요한 도구적’ 관점을 가지고 배우게 된다.
 
3. 집중력 ...
  (앞의 저자의 이야기와 중복되는 부분도 있지만) 생활과 업무 간에 필요한 
  수많은 사건들 사이에서 업무에서 필요한..전체적인 집중력을 잃지 않는다..
  
4. 말할 수 없는 것들
 저조한 성적.. 심지어 꼴찌를 하더라도 대회에 참가를 해야만 배우는 것들도 있다.
	
```



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
