
### Template for Code Challenge

```java
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class H {

	InputStream in;
	PrintWriter out;
	String INPUT = "";

	void solve(){
		
	}

	void run() throws Exception
	{
		in = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if(!INPUT.isEmpty()) tr(System.currentTimeMillis()-s+"ms");
	}

	public static void main(String[] args) throws Exception { new H().run(); }
	private static void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }
}

```
