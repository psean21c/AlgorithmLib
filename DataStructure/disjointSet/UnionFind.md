###

Suppose that the id[] array during the weighted quick union (by size) algorithm is given as below.
Which id[] entry changes when we apply the union opeation to 3 and 6?

![unionfind](https://cloud.githubusercontent.com/assets/5623445/23068458/c110846c-f4f1-11e6-9900-24a04efcbde3.PNG)

```
id[0]
id[3]
id[6]
id[8]
```

In weighted quick union(by size), we make the root of the smaller tree (in terms of the number of nodes) point to the root fo the larger tree. So in this example, the algorithm `sets id[8] = 0`
