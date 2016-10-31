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

Format of Sample Input
```
Q 
N 
A1 A2 A3 .. An
```
Q = Number of TestCases
N = Number of Elements
A1 .. An = List of Integers


Expected output
```
X Y
```
X = maximum contiguous subarray
Y = maximum non-contiguous subarray


### Normal Case - all positive integer
Sample Input
```
1 
4 
1 2 3 4
```
Sample Output
```
10 10
```
---

### Normal Case - all positive integer (Only 1)
```
1
1
1
```


Sample Output
```
1 1
```

### Case - having negative integers

Sample Input
```
1
6
2 -1 2 3 4 -5
```

Sample Output
```
10 11
```

### Case - having all negative integers

Sample Input
```
1
6
-1 -2 -3 -4 -5 -6
```


Sample Output
```
-1 -1
```

---
### Case - having negative integers

Sample Input
```
1
2
1 -2
```


Sample Output
```
1 1
```
### Case - having negative integers (Only 1)
Sample Input
```
1
1
-10
```


Sample Output
```
-10 -10
```

### Case - having negative integers

Sample Input
```
1
6
1 -1 -1 -1 -1 5
```


Sample Output
```
5 6
```
---

### Case - having negative integers (Mixed)

Sample Input
```
1
6
7 -9 1 2 -5 9
```

Sample Output
```
9 19 
```
