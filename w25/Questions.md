#


###

https://www.hackerrank.com/contests/w25/challenges/between-two-sets

Sample Input
```
2 3
2 4
16 32 96
```
Sample Output
```
3
```
Explanation

The integers that are between A = {2,4} and B = {16,32,96} are 4, 8, and 16.

```java
	public static void main(String[] args) {
		run();

	}
	
	static void run(){
		Scanner in = new Scanner(System.in);
		int Q = in.nextInt();
		int R = in.nextInt();
		
		long[] a = new long[Q];
		for(int i=0;i<Q;i++){
			a[i]= in.nextInt();
		}
		
		long[] b = new long[R];
		for(int j=0;j<R;j++){
			b[j] = in.nextInt();
		}

		long l = 0;
		if(a.length ==1){
			l = a[0];
		} else{
			l = lcm(a);
		}
		
		long g = 0;
		if(b.length ==1){
			g = b[0];
		} else{
			g = gcd(b);
		}
		
		
		long[] c = primeFactors(g);

		
		long m = g/l;
		int cnt = 0;
		for(int i=0;i<c.length;i++){
			if(c[i]%l==0) cnt++;
		}
		System.out.println(cnt);
		
	}
	
	static long gcd(long a,long b){
		if(a==0 | b==0) return a;
		else return gcd(b,a%b);
	}
	
	static long gcd(long[] g){
		long gcd = g[0];
		for(int i=0;i<g.length;i++){
			gcd = gcd(gcd,g[i]);
		}
		return gcd;
	}
	
	static long lcm(long a,long b){
		long lcm = a/gcd(a,b) * b;
		return lcm;
	}
	
	static long lcm(long[] l){
		long lcm = l[0];
		for(int i=0;i<l.length;i++){
			lcm = lcm(lcm,l[i]);
		}
		return lcm;
	}
	
	static long max(long a,long b){
		if(a >=b) return a;
		else return b;
	}
	
	static long[] primeFactors(long numbers) {
		long n = numbers;
		List<Integer> factors = new ArrayList<Integer>();
		
		int factorNumber =1;
		while(factorNumber <= n){
			 if(n % factorNumber == 0){
				 factors.add(factorNumber);
			 }
			 factorNumber++;
		}


		long[] ret = new long[factors.size()];
		for (int i = 0; i < factors.size(); i++)
			ret[i] = factors.get(i).intValue();
		return ret;

	}

```

```python
```


