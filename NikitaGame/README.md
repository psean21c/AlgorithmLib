
# Idea

Algorithm : count the number of occurence which you can split a list of numbers into two partitions when the sum of each list on both sides are equal (Get 1 point when the left & right can be equally divided into two parts)
 - Need to partition the array into 2 non-empty parts such that the sum of the elements in the left partition is equal to the sum of the elements in the right partition. If you can make such a move, you will get 1 point; otherwise, the game ends.
	     
```
4 1 0 1 1 0 1
==============
4 1 0 1 1 0 1
  1 0 1 1 0 1 (1st)
  1 0 1       (2nd)
  1           (3rd)

```

## Link
Original question

https://www.hackerrank.com/challenges/array-splitting


### TestCases for different scenario


Basic sample input
- It is straightforward to understand examples below

Input
```
3
3
3 3 3
4
2 2 2 2
7
4 1 0 1 1 0 1
```
Output
```
0
2
3
```

***
Scenario-1
- You need to partition /discard either left or right depending on the situation

Input
```
1
8
2 1 1 2 1 1 4 4
```
Output
```
4
```
Explain
```
2 1 1 2 1 1 4 4
2 1 1 2 1 1
2 1 1
  1 1
  1
```

***

Scenario-2
- You need to handle odd numbers of list

Input
```
1
3
2 2 4
```
Output
```
2
```


Input
```
1
3
4 2 2
```
Output
```
2
```
***

Scenario-3
- You need to handle all 0's 

Input
```
1
10
0 0 0 0 0 0 0 0 0 0
```
Output
```
9
```

Scenario-4

1. It is difficult to think about this scenario below
⋅⋅⋅ Intuitively the more elements the partion has, the more splits occurs. 
⋅⋅⋅ As TestCase-1, it will be more likely to have more splits when they have more elements
⋅⋅⋅ Take the list of TestCase-1 such as {2 1 1 2 1 1 4 4} for example ..

⋅⋅* 2 + 1 + 1 + 2 + 1 + 1 = 8 and 4 + 4 = 8

⋅⋅⋅ And then left partition ends up with 4 splits
⋅⋅* {2 1 1 2 1 1} => {2 1 1} {2 1 1} => {2} {1 1} => {1 1} => {1}
  
⋅⋅⋅ While right partition has only one more split
⋅⋅*  {4 4} => {4}

⋅⋅⋅ So it would be easier to take the list which has more elements in the partition.

2. However that's not always true

⋅⋅⋅ When you first partiton the list, you can have less number of elements in a list than the other between the left and right partition.  But sometimes you might end up with greater number of occurrence in the other side of partition.

⋅⋅* Take anoher list .. {8 1 1 1 1 4 2 2 2 2 2 2 2 2} for example ..

⋅⋅* 8 + 1 + 1 + 1 + 1 + 4 = 16 and 2 + 2 + 2 + 2 + 2 + 2 + 2 + 2 = 16
⋅⋅⋅  Initially right partition has more elements than the left.
⋅⋅⋅  However the other side(right) will return more splits than left.

![alt tag](https://cloud.githubusercontent.com/assets/5623445/19750048/076f9e32-9bbc-11e6-9aa0-0dab0eaf9ce5.GIF)

Input
```
1
14
8 1 1 1 1 4 2 2 2 2 2 2 2 2
```
Output
```
4
```
***

Input (Very difficult to manually figure out)
```
1
103
4096 4096 1024 256 256 128 128 128 128 512 512 512 512 256 256 512 512 128 32 32 32 32 128 128 1024 1024 2048 512 512 1024 2048 2048 1024 512 512 2048 2048 2048 16384 16384 2048 256 128 128 512 256 256 512 2048 1024 1024 512 512 1024 1024 1024 2048 512 512 1024 4096 4096 4096 2048 2048 4096 2048 2048 2048 1024 512 256 16 16 32 64 128 2048 512 512 512 512 8192 8192 32768 32768 65536 16384 8192 4096 4096 16384 16384 32768 8192 8192 16384 65536 16384 16384 16384 8192 8192
```
Output
```
15
```

### SourceCode 'Java' 



```java
static int count(int[] arr) {
	if (sum % 2 == 0 && len > 1) { // Continue when the sums of each side are equal and you can split the list into two
		...
		return 1 + max(count(arr1), count(arr2));
	} else if (len == 1) return 0; // Stop when you have only one element
	else return 0;

```

[GitHub Syntax Link](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

