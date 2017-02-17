
### Dr Peter Fenwick

[Fenwick in Wiki](https://en.wikipedia.org/wiki/Fenwick_tree)

![Dr Peter Fenwick](https://cloud.githubusercontent.com/assets/5623445/23033823/894ce872-f447-11e6-969d-8373e07b5ec5.png)

[Official WebSite The University of Auckland](https://www.cs.auckland.ac.nz/~peter-f/)



[GitHub Source](https://github.com/ProgrammingJack/Algorithm-DataStructures)

[Video Tutoring](https://www.youtube.com/watch?v=v_wj_mOAlig)


### BIT (Binary Indexes Tree)

[Question](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)

[Answer](https://discuss.leetcode.com/topic/31910/7ms-java-solution-using-binary-indexed-tree/2)


```
5, 2, 6, 1

get
tree[1]=0,1,result=0 tree[0]
add
tree[2]=1 10 >> tree[4]
tree[4]=1 100 >> tree[8]
tree[8]=1 1000 >> tree[16]
tree[16]=1 10000 >> tree[32]
tree[32]=1 100000 >> tree[64]
tree[64]=1 1000000 >> tree[128]

get
tree[6]=0,110,result=0 tree[4]
tree[4]=1,100,result=1 tree[0]
add
tree[7]=1 111 >> tree[8]
tree[8]=2 1000 >> tree[16]
tree[16]=2 10000 >> tree[32]
tree[32]=2 100000 >> tree[64]
tree[64]=2 1000000 >> tree[128]

get
tree[2]=1,10,result=1 tree[0]
add
tree[3]=1 11 >> tree[4]
tree[4]=2 100 >> tree[8]
tree[8]=3 1000 >> tree[16]
tree[16]=3 10000 >> tree[32]
tree[32]=3 100000 >> tree[64]
tree[64]=3 1000000 >> tree[128]

get
tree[5]=0,101,result=0 tree[4]
tree[4]=2,100,result=2 tree[0]
add
tree[6]=1 110 >> tree[8]
tree[8]=4 1000 >> tree[16]
tree[16]=4 10000 >> tree[32]
tree[32]=4 100000 >> tree[64]
tree[64]=4 1000000 >> tree[128]

2 1 1 0 
```
