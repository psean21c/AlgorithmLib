#


[Picking Numbers](https://www.hackerrank.com/contests/101hack44/challenges/picking-numbers)

A single integer denoting the maximum number of integers you can choose from the array 
such that the absolute difference between any two of the chosen integers is <=1.

The answer will be >=2

흘러가는 연속 가운데에서.. 바로 앞의 것들을 정확하게 수정을 해주는 것은 매우 어렵다..


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


