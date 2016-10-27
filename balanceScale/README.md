
It is very straightforward to understand what to do .. when you look at the picture.
Simply you have balance this scale.

![scale](https://cloud.githubusercontent.com/assets/5623445/19781633/1ed65b64-9c58-11e6-84de-a18dde85cea2.png)

I am still trying to find out better solution using DP(Dynamic Programming)
However the challenge here is you don't know which side you have to make it balanced it first.
Because it depends on different situation.

* For example, in Case 1 
(1) you have to figure out that the left side is heavier than the right 
(2) and then put additional weight on right side(D).

* However in Case 2 
(1) you have to put 2 on the left side of D node 
(2) and then you can put 10 on the left side of A node 

![scalesol](https://cloud.githubusercontent.com/assets/5623445/19782165/a59fd0e2-9c5a-11e6-9ed8-94d3d13b9042.PNG)
