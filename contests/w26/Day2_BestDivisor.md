
Kristen loves playing with and comparing numbers. She thinks that if she takes two different positive numbers, 
the one whose digits sum to a larger number is better than the other. If the sum of digits is equal for both numbers, 
then she thinks the smaller number is better. For example, Kristen thinks that  is better than  and that  is better than .

Given an integer, , can you find the divisor of  that Kristin will consider to be the best?

Input
```
12
```

Output
```
6
```

The set of divisors of 6 can be expressed as {1,2,3,4,6,12} . 
The divisor whose digits sum to the largest number is 6 (which, having only one digit, sums to itself). 
Thus, we print 6 as our answer.

```python
# Version -1

# sum function
def sum_digits(n):
    s = 0
    while n:
        s += n % 10
        n //= 10
    return s

# input
N = int(input().strip())
B = [i for i in range(1, N+1) if N%i ==0]
 
# logic 
best = B[0]

for i in B:
    #print(i, end=" ")  
    compare = i
    if i >= 10:
        compare = sum_digits(i)
    if compare > best:
        best = i
 
print(best)
```

TestCase 1
```
n = 12
B = [1, 2, 3, 4, 6, 12]
=> 6
```


TestCase 2
```
n =100000
B = [1, 2, 4, 5, 8, 10, 16, 20, 25, 32, 40, 50, 80, 100, 125, 160, 200, 250, 400, 500, 625, 800, 1000, 1250, 2000, 2500, 3125, 4000, 5000, 6250, 10000, 12500, 20000, 25000, 50000, 100000]
=> 625
```


TestCase 3
```
# Below is the extreme test case
B = [1,13,31,52]
=> 52
```
Because the version 1 didn't pass the case for TC-3, (even though the list was made up)
It print 13 not 52.
Version -2 was fixed to accomodate this case.

```python
# Version -2

# sum function
def sum_digits(n):
..
# input
..
   # The same as above

best = B[0]
greatest_sum = 0
 
for i in B:
    next_digit = sum_digits(i)
    
    if next_digit > greatest_sum:
        best = i
        greatest_sum = next_digit

 
print(best)

```
