# Item Relationship Clusters

Based on historical customer order information,
we can ascertain that given item A is ordered, what the probability is that item B is also ordered (e.g. Harry Potter 1 is frequently ordered with Harry Potter 2).
If this probability is greater than a certain affinity threshold, these items can be said to have Item Affinity.
All items that are linked together by Item Affinity can be considered to be in the same Item Affinity Cluster.
An item without Item Affinity to any other item can be considered to be in its own cluster of size 1.

Given a list of item affinity relationships and an affinity threshold of T,
return the largest Item Affinity Cluster.
If two clusters are tied, select the clusters that contains the item that appears first in alphabetic sort order.

Input Format:
```
The first line will contain T, the affinity threshold.
The second line will contain N, the number of item affinity relationships provided.
The next N lines will each contain an item affinity relationship triple: Item1 Item2 [Affinity Probability].
```

Output Format:
```
From the largest cluster found, print the item that appears first in alphabetic sort order.
```

Sample Input;
```python
0.15
4
Item1 Item2 0.2
Item2 Item3 0.1
Item4 Item5 0.3
Item5 Item6 0.4
```

Sample Output;
```
Item4
```

Examplantion;
```
There are 2 item Affinity Clusters: (Item1,Item2) and (Item4,Item5,Item6)
The cluster containing Item4 is larger, since it contains more items.
```

