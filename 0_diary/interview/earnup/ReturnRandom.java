import java.util.HashSet;
import java.util.Random;

// Quiz-3 & 4
public class ReturnRandom {
	
	// Quiz-3
	static HashSet<Integer> randomIntegers(int N){
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		Random rand = new Random();
		int  M = rand.nextInt(N)+1;
		if(M==N) M -=1;
		
		// Keep using random method until filling up the Set
		for(int i=0;i<M;i++){
			int m = rand.nextInt(N)+1;
			if(!set.contains(Integer.valueOf(m))){
				set.add(m);
			} else {
				while(set.contains(Integer.valueOf(m))){
					m = rand.nextInt(N)+1;
				}
				set.add(m);
			}
			set.add(m);
		}
		return set;
		
	}
	
	// Quiz-4
	static char[] randomArray(char[] arr){
		// Re-use the randomIntegers method to get the indices for the new array
		HashSet<Integer> indices = randomIntegers(arr.length-1);
		System.out.println(indices);
		
		char[] ret = new char[indices.size()];
		
		int idx =0;
		for(Integer i:indices){
			ret[idx++] = arr[i];
		}
		return ret;
		
	}
	
	
	public static void main(String[] args) {
		int N = 30;
		HashSet<Integer> set = randomIntegers(N);
		System.out.println(set.size() + " " + set);
		System.out.println();
		
//		String str1 = "EachElementMustBeDifferent"; 
		String str2 = "abcdefghijklmnopqrstuvwxyz"; 
		char[] arr = str2.toCharArray();		
		char[] ranArry = randomArray(arr);
		
		for(int i=0;i<ranArry.length;i++){
			System.out.print(ranArry[i] + " ");
		}
		
	}

}
