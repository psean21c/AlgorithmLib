###



### Day-1

Warm up
```java
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int m = in.nextInt();
        int t = c * m;
        int[] p = new int[n];
        boolean isBoat = true;
        for(int i=0; i < n; i++){
            p[i] = in.nextInt();
            if(p[i]>t){
            	isBoat = false;
            	break;
            }
        }
        if(isBoat) System.out.println("Yes");
        else System.out.println("No");
    }
```
### Day-2
```java

	static long getDecimal(int i){
		if(i==0) return 1;
		return 2 * getDecimal(i-1);
	}
	
	static void getXOR(long l){
		String s = Long.toBinaryString(l);
		int len = s.length();
		long bigger = 0L;
		long delta = 0L;
		boolean isFirstZero = false;
		for(int i=0;i<len;i++){
			int order = len-(i+1);
			if(s.charAt(i)=='0' & !isFirstZero){
				isFirstZero = true;
				bigger = getDecimal(order+1) -1;
			}
			if(isFirstZero & s.charAt(i)=='1'){
				delta = delta + getDecimal(order);
			}
		}
		long total = bigger - delta;
		System.out.println(total);
		
	}
	
	static void doXOR(long l){
		String s = Long.toBinaryString(l);
        int cnt = 0;
		for(long i=1;i<l;i++ ){
			long t = i ^ l;
			if(t>l) cnt++;
			String t2 = Long.toBinaryString(t);
			String i2 =  Long.toBinaryString(i);
//	        System.out.println(i+ ":\t\t" + i2 + "\t^\t" + s + "\t=" + t2 + "\t\t"+ t);
		}
//		System.out.println("cnt:" + cnt);
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long l = in.nextLong();
            getXOR(l);
            
        }
    }
}

```
