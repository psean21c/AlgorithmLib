public class mergeSort {

	public static void main(String[] args) {

		int[] a = {3,7,4,2,1,5,6};
		int[] b = sort(a);
		printSort(b);
	}
	
	static int[] sort(int[] ar){
		int len = ar.length;
		int mid = len/2;
		
		if(ar.length == 1){
			return ar;
		}else{
			int[] a = new int[mid];
			int[] b = new int[len-mid];
			int a_cnt = 0;
			int b_cnt = 0;
			for(int i=0;i<len;i++){
				if(i<mid){
					a[a_cnt++] = ar[i];
				}
				else{
					b[b_cnt++] = ar[i];
				}
			}
			int[] l = sort(a);
			int[] r = sort(b);
			int[] m = merge(l,r);
			return m;
		}
		
	}
	
	static int[] merge(int[]a, int[]b){
		int[] s = new int[a.length + b.length];
		int i=0,j=0,idx = 0;

		while(i<a.length && j<b.length){
			if(a[i] <= b[j]) s[idx++] = a[i++];
			else s[idx++] = b[j++];
		}
		
		if(i<a.length && j==b.length)
			while(i<a.length) s[idx++] = a[i++];
		
		if(j<b.length && i==a.length) 
			while(j<b.length) s[idx++] = b[j++];
		
		return s;
	}

	static void printSort(int[] ar){
		for(int a:ar) System.out.println(a);
	}
	
}
