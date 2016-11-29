
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

def sum_digits(n):
    s = 0
    while n:
        s += n % 10
        n //= 10
    return s
         
N = int(input().strip())

B = [i for i in range(1, N+1) if N%i ==0]
 
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

