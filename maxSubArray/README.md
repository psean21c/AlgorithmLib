## Link
Original question

https://www.hackerrank.com/challenges/maxsubarray

Need to count  

(1) the maximum contiguous subarray 

(2) the maximum non-contiguous subarray 

Initially Not only that I didn't get the proper answer but I also made very complicated imeplementation.
After looking at the Kadane-algorithm I was embarrassed with my code and also impressed by the simplicity of the algorithm.
I realized that I didn't fully understand the power of the max() function because I only know what the max() function does but don't know how /when to use this function.

## Idea

Algorithm :  the maximum subarray problem is the task of finding the contiguous subarray within a one-dimensional array of numbers which has the largest sum. For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; 
the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.

https://en.wikipedia.org/wiki/Maximum_subarray_problem

```
일단 아래와 같은 정수들의 리스트가 있다고 가정을 하고..


2 -1 2 3 4 -5
그러면 2번째(-1)와 마지막 6번째(-5) 원소는 음의 정수라는 것을 한 눈에 볼 수 있지..
그리고 그 음의 정수를 제외하고 양의 정수들의 합만 구해보면..괄호{  } 안의 숫자가 그 합이 될 거야..


{2} -1 {9} -5
여기서.. 처음 리스트로 돌아가서...
첫번째 요구사항 가운데 음수를 제외하고 양의 수만 더한 최종 값을 구하려고 하면 답은 {2} + {9}= 11
(* 이것은 어렵지 않겠지.. 음수의 수는 건너뛰고 양의 수만 더하면 되니까..)


두번째 요구사항은 ..
가운데 음의 정수를 포함해서 가장 큰 합을 구하려고 하면 {2} + {-1} + {9} = 10 이 되겠지..

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


## Highlight in Kadane-algorithm
```python
def max_subarray(A):
    max_ending_here = max_so_far = 0
    for x in A:
        max_ending_here = max(0, max_ending_here + x)
        max_so_far = max(max_so_far, max_ending_here)
    return max_so_far

```
