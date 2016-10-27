
It is very straightforward when you look at the picture.

![scale](https://cloud.githubusercontent.com/assets/5623445/19781633/1ed65b64-9c58-11e6-84de-a18dde85cea2.png)


1) Test case-1

input

A,20,D

D,2,4

output

A,0,0

D,6,4

    2     4
    |_____|
20 D |_____| A

    2(6)  4(4)
    |_____|
20 D |_____| A

Number inside () is the solution
2) Test case-2

input

A,2,D

D,2,4

output

A,10,0

D,2,0

    2     4
    |_____|
2     D
|_____|
   A

    2(2)  4
    |_____|
2(10) D |_____| A

3) Steps to explain the test-case 1

step-1

A[20,D,0,0]

D[2, 4,0,0]

step-2

A[20,D,0,8*]

D[2, 4,2,0]

** Whenever there is any value(8) for the alphabetic node(D) - A[20,D,0,8]

it has to be re-distributed to child nodes
step-3

8* => 4 : 4

A[20,D,0,0]

D[2, 4,2+4,0+4]

step-4

A[20,D,0,0]

D[2, 4,6,4]

step-5

3rd,4th elements in the List are answers

A[20,D,|0,0]

D[2, 4,|6,4]
