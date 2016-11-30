# balance Scale

It is very straightforward to understand what to do .. when you look at the picture below.

Simply you are supposed to balance this scale.

![scale](https://cloud.githubusercontent.com/assets/5623445/19781633/1ed65b64-9c58-11e6-84de-a18dde85cea2.png)

I am still trying to find out a better solution using DP(Dynamic Programming).

However the challenge here is that you don't know which side you have to balance it first until you read all of tree structure.



* For example, in Case 1 
```
(1) you have to figure out that the left side is heavier than the right 
(2) and then put additional weight on right side(D).
```

* However in Case 2 
```
(1) you have to put 2 on the left side of D node 
(2) and then you can put 10 on the left side of A node 
```

![scalesol](https://cloud.githubusercontent.com/assets/5623445/19782165/a59fd0e2-9c5a-11e6-9ed8-94d3d13b9042.PNG)


### Requirement

![balancetree1](https://cloud.githubusercontent.com/assets/5623445/20761471/1aa93756-b6f1-11e6-80c3-975a3e37b2e2.PNG)
![balancetree2](https://cloud.githubusercontent.com/assets/5623445/20761470/1aa73938-b6f1-11e6-9704-44d4921372e0.PNG)
