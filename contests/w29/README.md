

### Day-1

[Original Question](https://www.hackerrank.com/contests/w29/challenges/day-of-the-programmer)

```java
public class Solution {

	static boolean GregorianleapYear(int year){
		if( (year%400==0 || year%100!=0) &&(year%4==0))
			return true;
		else return false;
	}
	
	static boolean JulianleapYear(int year){
		if(year%4==0) return true;
		else return false;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y = in.nextInt();
        boolean isLeap = false;
        String mm = "09";
        int dd = 0;
        // your code goes here
        if(y<=1917){
        	isLeap = JulianleapYear(y);
        	if(isLeap) dd = 12;
        	else dd = 13;
        } else if(y==1918){
        	dd = 26;
        } else {
        	isLeap = GregorianleapYear(y);
        	if(isLeap) dd = 12;
        	else dd = 13;
        }
        
        String converted = String.valueOf(dd) + "." + mm + "." + String.valueOf(y);
        System.out.println(converted);
        
    }
}

```

### Day-2


https://www.youtube.com/watch?v=3M0UyCsAe9I

FFT algorithm?

Test Case
```
# TestCase 1
6
31415926535897932384626433832795
1
3
10
3
5

# TestCase 2
5
1
3
10
3
5

# TestCase 3
4
31415926535897932384626433832795
2147483647
31415926535897932384626433832784
32415926535897932384626433832795

```


```java
public class Solution {

	static BigInteger[] bigSort(BigInteger[] ar){
		int len = ar.length;
		int mid = len/2;
		
		if(ar.length == 1){
			return ar;
		}else{
			BigInteger[] a = new BigInteger[mid];
			BigInteger[] b = new BigInteger[len-mid];
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
			BigInteger[] l = bigSort(a);
			BigInteger[] r = bigSort(b);
			BigInteger[] m = bigMerge(l,r);
			return m;
		}
		
	}
	
	static BigInteger[] bigMerge(BigInteger[] a, BigInteger[] b){
		BigInteger[] s = new BigInteger[a.length + b.length];
		int i=0,j=0,idx = 0;
		
		while(i<a.length && j<b.length){
			int compare = a[i].compareTo(b[j]);
			if(compare<=0) s[idx++] = a[i++];
			else s[idx++] = b[j++];
		}
		
		if(i<a.length && j==b.length)
			while(i<a.length) s[idx++] = a[i++];
		
		if(j<b.length && i==a.length) 
			while(j<b.length) s[idx++] = b[j++];
		
		return s;
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

	static void printBigSort(BigInteger[] ar){
		for(BigInteger a:ar) System.out.println(a);
	}


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        
        int[] arr = new int[n];
        BigInteger[] bigArr = new BigInteger[n];
        
        int a = 0;
        int a2 = 0;
        for(int i=0; i < n; i++){
            unsorted[i] = in.next();
            String tmp = unsorted[i];
            
            if(tmp.length() >=10){
            	bigArr[a2++] = new BigInteger(tmp);
            } else {
            	arr[a++] = Integer.valueOf(tmp);
            }
        }

        if(a>0){
            int[] dest = new int[a];
            System.arraycopy(arr, 0, dest, 0, a);
            int[] sorted = sort(dest);
            printSort(sorted);
        }
        if(a2>0){
            BigInteger[] bigDest = new BigInteger[a2];
            System.arraycopy(bigArr, 0, bigDest, 0, a2);
            BigInteger[] bigSorted = bigSort(bigDest);
            
            printBigSort(bigSorted);
        }
        
        
    }
}


```

### candidates

(single heart)
https://github.com/singleheart

http://singleheart.pe.kr/en/

Challenge author (Russian mfv)
http://codeforces.com/blog/entry/50523


[Japanese Slide](http://hos.ac/slides/)

[Japanese Slide - BIT Fenwick](http://hos.ac/slides/20140319_bit.pdf)


