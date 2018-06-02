
public class Merge {

public static List<Integer> mergeSort(List<Integer> lst){
	int high = lst.size();
	
	if(high == 1) return lst;
	else {
		int mid = high/2;
		List<Integer> leftGroup = mergeSort(lst.subList(0,mid));
		List<Integer> rightGroup = mergeSort(lst.subList(mid, high));
		List<Integer> resultGroup = mergeAllSort(leftGroup, rightGroup);
		return resultGroup;
	}
	
}


public static List<Integer> mergeAllSort(List<Integer> left, List<Integer> right) {
	
	int mergedSize = left.size() + right.size();
	List<Integer> sortedList = new ArrayList<Integer>(mergedSize);
	
	for(int i=0; i<left.size() ;i++){
		sortedList.add(left.get(i));
	}
	for(int j=0; j<right.size() ;j++){
		sortedList.add(right.get(j));
	}


	int i = 0;
       int j = 0;
       int k = 0;
	while (i < left.size() && j < right.size()){
		if(left.get(i) <= right.get(j)) {
			sortedList.set(k, left.get(i));
			i++;
		} else {
			sortedList.set(k,right.get(j));
			j++;
		}
		k++;
	}
	
	if(i < left.size() && j == right.size()){
		while(i < left.size()){
			sortedList.set(k, left.get(i));
			i++;
			k++;
		}
	} else if(i == left.size() && j < right.size()){
		while(j < left.size()){
			sortedList.set(k, right.get(j));
			j++;
			k++;
		}
	}


	return sortedList;
}




public static void main(String[] args) {
    Integer[] array = new Integer[] {12,11,10,9,8,7,6,5,4,3,2,1,0};
    List<Integer> input = Arrays.asList(array);
    printSort(input);
    List<Integer> output = mergeSort(input);
    printSort(output);
}


/*** 
printSort() defined in BubbleSort
**/


}
