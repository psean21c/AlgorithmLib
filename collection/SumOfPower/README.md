# Sum Of Power


Task 
---

Find the number of ways that a given integer, X , can be expressed as the sum of the  Nth power of unique, natural numbers.

Input Format
```
The first line contains an integer X. 
The second line contains an integer N.
```

Constraints
```
1 <= X <= 1000
2 <=N <=10
```
Output Format

Output a single integer, the answer to the problem explained above.

---
Sample 1

If  X=10 and N=2, we need to find the number of ways that 10 can be represented as the sum of squares of unique numbers. 

This is the only way in which  can be expressed as the sum of unique squares.

![power1](https://cloud.githubusercontent.com/assets/5623445/19808668/de8417d0-9cf3-11e6-862b-4a6a95d22bf1.PNG)

```
# 1) Given input
X = 10
N = 2
# 2) Find out the numbers satisfying the condition
10 = 1 + 9(3 * 3)
# 3) Give the count of ways
1
```
Sample 2

 100 can be expressed as the sum of the cubes of 1,2,3,4.  (1 + 8 + 27 + 64 = 100). There is no other way to express  as the sum of cubes.

```
# 1) Given input
X = 100
N = 3
# 2) Find out the numbers satisfying the condition
10 = 1 + 8(2^3) + 27(3^3) + 64(4^3)
# 3) Give the count of ways
1
```

Sample 3 


![power2](https://cloud.githubusercontent.com/assets/5623445/19808673/e46757de-9cf3-11e6-9f56-de38fd1d4e89.PNG)

```
# 1) Given input
X = 100
N = 2
# 2) Find out the numbers satisfying the condition
100 = 10 * 10 
    = 36(6*6) + 64(8*8)
    = 1 + 9(3*3) + 16(4*4) + 25(5*5) + 49(7*7)
# 3) Give the count of ways
3
```
