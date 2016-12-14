# Sorting

### Bubble Sorting

1) Compare adjacent elements. If the first is greater than the second, swap them.

2) Do this for each pair of adjacent elements, starting with the first two and ending with the last two. At this point the last element should be the greatest. 

3) Repeat the steps for all elements except the last one. 

4) Continue for one less element each time, until there are no more pairs to compare.


Because the biggest number will be moved to the last element during each iteration,
 We have to continue for one less element (excluding the last element) each time.
Bubble sort has worst-case and average complexity both О(n2) 


```java
public class Bubble {
	  
    public static void Sort(List<Integer> lst){
    	int len = lst.size();
    	printSort(lst);


    	for(int n=len-1; n> 0 ; n--){
    		for(int i=0; i<len-1; i++){
        		int j = i + 1;
    			if(lst.get(i) > lst.get(j)){
	    	        int temp;
	    	        temp = lst.get(i);
	    	        lst.set(i, lst.get(j));
	    	        lst.set(j, temp);
    			}
    		}
    	}
    	printSort(lst);
    }


    private static void printSort(List<Integer> lst){
    	for(Integer x:lst){
    		System.out.print(" " + x);
    	}
    	System.out.println();
    }
  
    public static void main(String[] args) {
    	Integer[] array = new Integer[] {12,11,10,9,8,7,6,5,4,3,2,1,0 };
    	List<Integer> input = Arrays.asList(array);
        Sort(input);
    }
}
```
