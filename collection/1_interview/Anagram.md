# Making Anagram

[Original Question](https://www.hackerrank.com/challenges/ctci-making-anagrams)

###

###
TestCase1: input/output
```
cde
abc

>> 4
```

TestCase2
```
fcrxzwscanmligyxyvym
jxwtrhvujlmrpdoqbisbwhmgpmeoke
>>30
```
TestCase3
```
tttttttttttttttttttttttttttttttttttttsssssssssssssssss
sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
>>107
```



```cpp
#include <vector>
#include <iostream>

using namespace std;

int A[200];

/***
int number_needed(string a, string b) {

}
***/

int main(){
    string a;
    cin >> a;
    string b;
    cin >> b;
    cout << number_needed(a, b) << endl;
    return 0;
}


```

My Solution
```cpp
int number_needed(string a, string b) {
	string str1 (a);
	string str2 (b);

	for(unsigned int i=0;i<str1.length();i++){
		int x = str1[i];
		A[x]++;
	}

	for(unsigned int i=0;i<str2.length();i++){
		int y = str2[i];
		A[y]--;
	}

	int sum = 0;
	// a=97, z=122
	for(int i=97;i<123;i++){
		sum+=abs(A[i]);
	}

	return sum;

}
```
