#


### Day-1 : Between Two Sets

https://www.hackerrank.com/contests/w25/challenges/between-two-sets

Consider two sets of positive integers, A = {a0,a1,...aN} B = {b0,b1,...bN}
A positive integer - x - is between sets A and B if the following conditions are satified;

1. All elements in A are factors of x.
2. x is a factor of all elements in B.


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

A = {2,3}

B = {16,32,96}

The integers (x) that are between A = {2,4} and B = {16,32,96} are 4, 8, and 16.


Below are other Test cases.
```
2 3
2 3
24 36 12
=>2 (6,12)

1 1 
1 
100
=> 9 (1, 2, 4, 5, 10, 20, 25, 50, 100)
```

```java

// Java
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

# Python
N,M = input().strip().split(' ')
N,M = [int(N),int(M)]
A = map(int,input().strip().split(' '))
B = map(int,input().strip().split(' '))

A = list(A)
B = list(B)
A.sort()
B.sort()

C = [i for i in range(1, 101)]
for denom in A:
  C = list(filter(lambda y: y % denom == 0, C))

for numer in B:
  C = list(filter(lambda y: numer % y == 0, C))
  
print(len(C))  
```


