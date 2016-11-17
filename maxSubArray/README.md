## Link
Original question

https://www.hackerrank.com/challenges/maxsubarray

Need to count  

(1) the maximum contiguous subarray 

(2) the maximum non-contiguous subarray 

Initially Not only did not I get the proper answer but also I made very complicated implementation. After looking at the Kadane-algorithm(* See the link below)  I was embarrassed with my code and also impressed by the simplicity of the algorithm. I realized that I didn't fully understand the power of the max() function because I only know what the max() function does but don't know how /when to use this function.

하나의 중요한 개념을 정확하게 이해한다는 것은.. 어떤 면에서 .. 자신이 철저하게 틀렸다는 것을 인정해야 받아들이는 부분들이 더욱 많다. 속되게 말해서..개망신을 당해봐야 자기가 잘나지 않았다는 것을 깨닫는 것과 동일한 이치이다.


## Idea

### Algorithm : contiguous subarray

```
the maximum subarray problem is the task of finding the contiguous subarray 
   within a one-dimensional array of numbers which has the largest sum. 
For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; 
the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.
```

Korean for my dear friends
```
일단 아래와 같은 정수들의 리스트가 있다고 가정을 하고..

2 -1 2 3 4 -5

그러면 2번째(-1)와 마지막 6번째(-5) 원소는 음의 정수라는 것을 한 눈에 볼 수 있습니다..

그리고 그 음의 정수를 제외하고 양의 정수들의 합만 구해보면..괄호{  } 안의 숫자가 그 중간 합이 될 겁니다.
{2} -1 {9} -5

여기서.. 처음 리스트로 돌아가서...

2 -1 2 3 4 -5

두번째 요구사항..(* 이것은 어렵지 않겠지.. 음수의 수는 건너뛰고 양의 수만 더하면 되니까..)
가운데 음수를 제외하고 양의 수만 더한 최종 값을 구하려고 하면 답은 {2} + {9}= 11

첫번째 요구사항은 ..
가운데 음의 정수를 포함해서 가장 큰 합을 구하려고 하면 {2} + {-1} + {9} = 10 이 됩니다.

BigTestCase.md 에 보면 극단적으로 많은 테스트 케이스가 있으니 그것까지 통과하면 만점..

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

https://en.wikipedia.org/wiki/Maximum_subarray_problem

It looks so simply, but - To be honest - I was very impressed by the power of max() function.
It is always different when you see it and when you touch it.

```python
def max_subarray(A):
    max_ending_here = max_so_far = 0
    for x in A:
        max_ending_here = max(0, max_ending_here + x)
        max_so_far = max(max_so_far, max_ending_here)
    return max_so_far

```
