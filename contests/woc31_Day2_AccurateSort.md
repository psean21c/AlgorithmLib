### Accurate Sorting

[Hackerrank Question](https://www.hackerrank.com/contests/w31/challenges/accurate-sorting)



```java
package hacker.com.week31;

import java.util.Scanner;

public class B {

	static String accurateSort(int a[]) {
		for (int i = 1; i < a.length; i++) {
			if ((a[i - 1] > a[i]) && (a[i - 1] - a[i] == 1)) {
				int temp = a[i - 1];
				a[i - 1] = a[i];
				a[i] = temp;
			}
		}

		boolean isSorted = true;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				isSorted = false;
				break;
			}
		}

		if (isSorted)
			return "Yes";
		else
			return "No";

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			System.out.println(accurateSort(a));
		}
		in.close();
	}
}

```


```java
package hacker.com.week31;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class BTest {

	int [] a1 = {1,2,0,4,3};
	int [] a2 = {1,0,3,2};
	int [] a3 = {2,1,0};
	int [] a4 = {0,1,2,3,4,5,6,7};
	int [] a5 = {0,1,2,5,3,4};
	


	@Before
	public void setUp() throws Exception {
		B b = new B();
	}


	@Test
	public void testAccurateSort() {
		assertSame("{1,2,0,4,3}", B.accurateSort(a1),"No");
		assertSame("{1,0,3,2}", B.accurateSort(a2),"Yes");
		assertSame("{2,1,0}", B.accurateSort(a3),"No");
		assertSame("{0,1,2,3,4,5,6,7}", B.accurateSort(a4),"Yes");
		assertSame("{0,1,2,3,4,5,6,7}", B.accurateSort(a5),"Yes");
	}

}

```
