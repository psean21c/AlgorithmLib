
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


int[] array = { 1, 2, 3 };
ArrayList<Integer> list = new ArrayList<Integer>(array.length);
for (int i = 0; i < array.length; i++)
	list.add(Integer.valueOf(array[i]));



// assign the character variable ch to the lowercase version of itself, 
// without having to write any additional methods
ch = Character.toLowerCase(ch);
```
