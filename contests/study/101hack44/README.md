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
{1}
{3,3}
{3,3,4}
{4}
{4,5}
{5}
{5,6}
{6}
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
