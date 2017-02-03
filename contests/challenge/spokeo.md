
```java
1. Input is an array of integers, print out all the different duplicated number? 
(print each duplicated num only once) 1 2 -1 3 -1 -1 -1 5 5 7 -->> -1 5

class A{

    duplicateNumber(int[] ar){
        
        //Arrays.sort(ar);
        //-1 -1 -1,-1 1 2  3  5 5 7
        int len = ar.length;
        int a_pos[] = new int[len];
        int a_neg[] = new int[len];
        int i_p = 0;
        int i_n = 0;
        for(int i=0;i<ar.length;i++){
            if(ar[i] >=0){
                 int idx_p = ar[i];
                 a_pos[idx_p++] += 1;
             }
            if(ar[i] <0) {
                 int idx_n = -1 * ar[i];
                a_pos[idx_n++] += 1;
            }
        }
        
        for(int i=0;i<a_pos.length;i++){
            if(a_pos[i] > 1) System.out.println(i);
        }
        for(int i=0;i<a_neg.length;i++){
            if(a_neg[i] > 1) System.out.println(-1*i);
        }
        
    }
}

Q2. Given a random tree print level by level
      1
     / \
    2   3
    |  /|\ \
    8 4 5 6 10
    |   |
    11  9

# print those nodes in level order.
1 2 3 8 4 5 6 10 11 9

class Tree{
    int name;
    int[] child;
    boolean[] hasNextChild;
    Tree next;
//    Tree (int i){
//        a = i;
//        next = i;
//    }
}

static printLevel(Tree a){
   if(a==null) return;
    //bfs(); // Breath First Search()
    while(a!=null){
       System.out.println(a.child);
       printLevel(a.next);
       a = a.next;   
    }  
    for(Tree t: a){
        System.out.println(a.name);     
    }
}

3. Input is an array of integers, some number are popular(appears 50%)
{ 1, 1, 1, 1, 1, 4, 5, 6 } 1 -> > 50%
find this major #? (assume the input is fairly large, from (50G?) big file, hdfs)

a ={ 1, 1, 1, 1, 1, 4, 5, 6 }
Arrays.sort(a)

// count # for each integer
key: value
1 : 5
4 : 1
5 : 1
6 : 1

HashSet a = new HashSet();
for(){
    a.put(key,value)
}
```
