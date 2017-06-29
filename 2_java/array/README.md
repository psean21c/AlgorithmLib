
12345

### Array Copy

```java

	int[] src  = new int[]{1,2,3,4,5};
	int[] dest = new int[5];

	System.arraycopy( src, 0, dest, 0, src.length );

```

### Convert between Array and List
```java
// 
public static void run(){
	int[] ar = {1,2,3,4,5,6};
		
	// 1) int[] -> List<Integer>
	List<Integer> intList = intToList(ar);
	printList(intList);
		
	// 2) List<Integer> -> int[]
	int[] arList = toIntArray(intList);
	printArray(arList);
}
	
static int[] toIntArray(List<Integer> list)  {
    int[] ret = new int[list.size()];
    for(int i =0;i<list.size();i++) ret[i] = list.get(i).intValue();
    return ret;
}

static List<Integer> intToList(int[] ar)  {
	List<Integer> intList = new ArrayList<Integer>();
	for (int i = 0; i < ar.length; i++)	intList.add(ar[i]);
	return intList;
}
```

### Initialize ArrayList
```java
 ArrayList<Boolean> booleanArray
   = new ArrayList<Boolean>( Arrays.asList(false,true,false,true));


Integer[] arr = {7,5,7,3};
Set<Integer> set = new TreeSet<Integer>(Arrays.asList(arr));
		
set.add(4);
		
for(Integer value: set){
	System.out.println("" + value);
}


#
static int[][] grid = { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 0, 0 } };


// assign the character variable ch to the lowercase version of itself, 
// without having to write any additional methods
ch = Character.toLowerCase(ch);
```

### Count the number of group in the array

int[] a = {0,1,1,0,1,0,1,0,1,1}

We can count 4 as the number of group of 1's as {1,1} {1}, {1}, {1,1} between 0's

```java
public class A {

	static int a[] = {0,1,1,0,1,0,1,0,1,1};
	
	public static void main(String[] args){
		int cnt  = countGroup(a);
		System.out.println(cnt);
	}
	
	static int countGroup(int[] ar){
		int cnt = 0;
		for(int i=0;i<ar.length;i++){
			if(ar[i]==1) {
				findNext(i);
				cnt++;
			}
		}
		return cnt;
	}
	
	static void findNext(int idx){
		if(idx>=a.length) return;
		if(a[idx]!=1) return;
		a[idx]=2;
		findNext(idx+1);
	}
}
```

When you find {1}, call findNext() 

First, In order to update it with {2} 

Second, continue doing it with its next element

```
0 1 1 0 1 0 1 0 1 1 

0 2 2 0 1 0 1 0 1 1 : count=1
0 2 2 0 2 0 1 0 1 1 : count=2
0 2 2 0 2 0 2 0 1 1 : count=3
0 2 2 0 2 0 2 0 2 2 : count=4

4
```


### Good example

https://www.hackerrank.com/challenges/java-arraylist
