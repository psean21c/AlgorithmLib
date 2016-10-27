
# Idea

Algorithm : count number of occurence which can split list of numbers when the sum of list on both sides are equal
             (Get 1 point when the left & right can be equally divided into two parts)
 - Need to partition the array into 2 non-empty parts such that the sum of the elements in the left partition is equal to the sum of the elements in the right partition. If you can make such a move, you will get 1 point; otherwise, the game ends.
	     
```
4 1 0 1 1 0 1
==============
4 1 0 1 1 0 1
  1 0 1 1 0 1 (1st)
  1 0 1       (2nd)
  1           (3rd)

```

## Link
https://www.hackerrank.com/challenges/array-splitting


### TestCases 


Basic sample input
- It is straightforward to understand
```
3
3
3 3 3
4
2 2 2 2
7
4 1 0 1 1 0 1
```
output
```
0
2
3
```


TestCase-1
- You need to partition /discard either left or right depending on the situation
```
1
8
2 1 1 2 1 1 4 4
```
Output
```
4
```
Explain
```
2 1 1 2 1 1 4 4
2 1 1 2 1 1
2 1 1
  1 1
  1
```



TestCase-2
- You need to handle odd number of list
```
1
3
2 2 4
```
Output
```
2
```


TestCase-2
```
1
3
4 2 2
```
Output
```
2
```

TestCase-3
- You need to handle all 0's 
```
1
10
0 0 0 0 0 0 0 0 0 0
```
Output
```
9
```

TestCase-4
- It is difficult to think about this scenario
 1 1 1 2 2 ... 1 1 ... 1 .. 1.. 1 .. 1.. 4 ..4
       8             |       10 
* When you first partiton the list, you can have less number of list left partition than right partition.
  But eventually you might end up with greater number of occurrence in the right partition than left.
```
1
103
4096 4096 1024 256 256 128 128 128 128 512 512 512 512 256 256 512 512 128 32 32 32 32 128 128 1024 1024 2048 512 512 1024 2048 2048 1024 512 512 2048 2048 2048 16384 16384 2048 256 128 128 512 256 256 512 2048 1024 1024 512 512 1024 1024 1024 2048 512 512 1024 4096 4096 4096 2048 2048 4096 2048 2048 2048 1024 512 256 16 16 32 64 128 2048 512 512 512 512 8192 8192 32768 32768 65536 16384 8192 4096 4096 16384 16384 32768 8192 8192 16384 65536 16384 16384 16384 8192 8192
```
Output
```
15
```

### SourceCode 'Java' 



```java
	return 1 + max(count(arr1), count(arr2));
```
https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet
