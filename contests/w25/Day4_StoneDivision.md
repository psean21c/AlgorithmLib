# Stone Division


### Original question

https://www.hackerrank.com/contests/w25/challenges/stone-division

### Test Cases

TC-0
```
15 3
5 2 3
>> Second
```

TC-1
```
10 3
5 1000000000000000000 2
>> First
```

TC-2
```
718791247583033625 6
3 5 17 19 23 37
>> First
```

TC-3
```
883086389887727025 10
5 15 51 57 111 465 609 12576855 815897745 1791252075
>> Second
```

TC-4
```
390904930294003125 5
5 9 11 253 345
>> First
```

TC-5
```
328360141446962625 7
5 9 11 35 57 165 345
>> Second
```

TC-6
```
4517123638952925 10
31 231 465 765 847 6851 36363 67735 70035 1916291
>> First
```

TC-7
```
922334673882737115 8
23 43 99 161 10199 164169 611351 784363
>> Second
```

TC-8
```
596920180528546875 3
117 1740609 4039875
>> First
```

### Other questions

[Nim Game](https://www.hackerrank.com/challenges/nim-game-1)


### Reference

[Grundy Theory](https://brilliant.org/wiki/sprague-grundy-theorem/)

[NIM theory by MIT](http://web.mit.edu/sp.268/www/nim.pdf)


### Others' solution

```java
// uwi
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class D {
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	
	long[] s;
	
	void solve()
	{
		long n = nl();
		int m = ni();
		s = new long[m];
		int p = 0;
		for(int i = 0;i < m;i++){
			long v = nl();
			if(n % v == 0){
				s[p++] = v;
			}
		}
		s = Arrays.copyOf(s, p);
		m = p;
		
		for(int i = 0;i < m;i++){
			if(s[i] % 2 == 0){
				out.println("First");
				return;
			}
		}
		
		out.println(win(n) ? "First" : "Second");
	}
	
	Map<Long, Boolean> cache = new HashMap<>();
	
	boolean win(long nn)
	{
		return cache.computeIfAbsent(nn, (n) -> {
			for(long v : s){
				if(n % v == 0){
					if(!win(n/v)){
						return true;
					}
				}
			}
			return false;
		});
	}
	
	void run() throws Exception
	{
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
	}
	
	public static void main(String[] args) throws Exception { new D().run(); }
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private double nd() { return Double.parseDouble(ns()); }
	private char nc() { return (char)skip(); }
	
	private String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	private int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private static void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }
}
```


```python
hist = {}

def foo(n, a):
    if n in hist.keys():
        return hist[n]
    for x in a:
        if n % x == 0:
            if x % 2 == 0:
                hist[n] = True
                return True
            nn = n // x
            if not foo(nn, a):
                hist[n] = True
                return True
    hist[n] = False
    return False

n, s = (int(x) for x in input().split())
a = [int(x) for x in input().split()]

if foo(n,a):
    print("First")
else:
    print("Second")
```
