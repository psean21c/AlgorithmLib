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




