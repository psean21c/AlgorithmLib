## Link
Original question

https://www.hackerrank.com/challenges/maxsubarray


## Idea

Algorithm :  the maximum subarray problem is the task of finding the contiguous subarray within a one-dimensional array of numbers which has the largest sum. For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.

https://en.wikipedia.org/wiki/Maximum_subarray_problem


## Highlight in SourceCode
```
def max_subarray(A):
    max_ending_here = max_so_far = 0
    for x in A:
        max_ending_here = max(0, max_ending_here + x)
        max_so_far = max(max_so_far, max_ending_here)
    return max_so_far

```

## TestCase

Sample Input
```
2 
4 
1 2 3 4
6
2 -1 2 3 4 -5
```

Sample Output
```
10 10
10 11
```

---

Sample Input
```
6
1
1
6
-1 -2 -3 -4 -5 -6
2
1 -2
3
1 2 3
1
-10
6
1 -1 -1 -1 -1 5
```


Sample Output
```
1 1
-1 -1
1 1
6 6
-10 -10
5 6
```
---

Sample Input
```
3
6
-1 -2 -3 -4 -5 -6
1
-10
6
1 -1 -1 -1 -1 5
```

Sample Output
```
-1 -1
-10 -10
5 6
```
---

Sample Input
```
1
6
1 -1 -1 -1 -1 5

```
Sample Input
```
1
4
1 -1 -2 5
```
Sample Output
```
5 6
```
---
Sample Input
```
8
4 
1 2 3 4
6
2 -1 2 3 4 -5
1
1
6
-1 -2 -3 -4 -5 -6
2
1 -2
3
1 2 3
1
-10
6
1 -1 -1 -1 -1 5
```

Sample Output
```

```

---
Sample Input
```
1
6
7 -9 1 2 -5 9
```

```
9 19 
```
