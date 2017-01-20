
Convert between Array and List
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
Initialize ArrayList

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

```
```
// assign the character variable ch to the lowercase version of itself, without having to write any additional methods
ch = Character.toLowerCase(ch);
```
