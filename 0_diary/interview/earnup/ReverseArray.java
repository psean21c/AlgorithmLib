public class ReverseArray {
	
	// Quiz-1
	static char[] reverse(char[] arr){
		int len = arr.length;
		char[] ret = new char[len];
		// copy the value from arr[] to ret[] in the reverse order
		for(int i=len-1;i>=0;i--){
			ret[len-i-1] = arr[i];
		}
		return ret;
	}
	
	public static void main(String[] args) {
		
		String str = "desreveReb2gnirts"; 
		char[] arr = str.toCharArray();
		
		char[] ret = reverse(arr);
		// print to validate
		for(int i=0;i<ret.length;i++){
			System.out.print(ret[i] + "");
		}
		
	}

}
