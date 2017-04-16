
```java

package hacker.com.week31;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class E {
	
	static double pi = 3.1415926535897932384;

	// core method
	static Double collideCircle(int k, int[] r){
		if(k==r.length-1) {
			return bigOneCircle(r);
		}
		Double area = areaCircle(k, r);
		int len = r.length;
		int freq = freqeunce(k, len-1);
		area /= freq;
		return area;
	}

	
	
	static Double bigOneCircle(int[] r){
		Long radius = 0L;
		for(int i = 0;i<r.length;i++){
			radius += r[i];
		}
		Double area = calculateCircle(radius * radius);
//		System.out.println(area);
		return area;
	}

	static Double areaCircle(int k,int[] r){
		
		List<Integer> lst = intToList(r);
		Long radius = makeCircle(k,lst ,new HashMap<Set<Integer>, Long>());
		Double area = calculateCircle(radius);
//		System.out.println(area + ":" + area/18);
		return area;
	}
	
	static Double calculateCircle(Long power){
		Double area = (double) Math.round((pi * (power)) * 10000000000d) / 10000000000d;
		return area;
	}
	
	static int freqeunce(int k, int len){
		if(k==1) return len * (len + 1) / 2;
		
		int occurence = len * (len + 1) / 2;
		int frequence = occurence * freqeunce(k-1,len-1);
		return frequence;
	}
	

	
	static Long radiiPower(List<Integer> lst){
		Long radii = 0L;
		for(Integer l:lst) radii += (l * l);
		return radii;		
	}
	
	static Long makeCircle(int k,List<Integer> lst,HashMap<Set<Integer>, Long> memo){
		
		if(k==0) return radiiPower(lst);

		// memoization
		Set<Integer> key = new HashSet<Integer>(lst);
		if(memo.containsKey(key)) return memo.get(key);
		
		Long sumRadius = 0L;
		Long radius = 0L;
		for(int i=0;i<lst.size()-1;i++){
			List<Integer> prefix = lst.subList(0, i); 
			int elem = lst.get(i);
			List<Integer> suffix = lst.subList(i+1, lst.size());
			for(int j=0;j<suffix.size();j++){
				List<Integer> lst2  = new ArrayList<Integer>();
				List<Integer> suffix2 = new ArrayList<Integer>();
				List<Integer> prefix2 = suffix.subList(0, j); 
				suffix2.addAll(prefix2);
				int elem2 = suffix.get(j) + elem;
				suffix2.add(elem2);
				suffix2.addAll(suffix.subList(j+1, suffix.size()));
				lst2.addAll(prefix);
				lst2.addAll(suffix2);
				radius = makeCircle(k-1, lst2, memo);
			    sumRadius += radius;
				
			}
			
		}

		memo.put(key, radius);
		
		return sumRadius;		
	}

	static List<Integer> intToList(int[] ar)  {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < ar.length; i++)	intList.add(ar[i]);
		return intList;
	}
	
	static void printFormat(Double number) {
    	String pattern = "###################.##########";
    	DecimalFormat decimalFormat = new DecimalFormat(pattern);

    	String format = decimalFormat.format(number);
    	System.out.println(format);
		
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] r = new int[n];
        for(int r_i=0; r_i < n; r_i++){
            r[r_i] = in.nextInt();
        }
        
        Double areaCircle = collideCircle(k, r);
        printFormat(areaCircle);

    }

}


```

Unit Test

```java
package hacker.com.week31;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ETest {

	static int [] a1 = {1, 2, 3, 4};

	@Before
	public void setUp() throws Exception {
//		e = new E();
	}

	

	// collideCircle
	@Test
	public void testCollideCircle() {
		int k = 1;
		int [] r = {1,2,3};
		E.collideCircle(k, r);
	}

	@Test
	public void testCollideCircle2() {
		int k = 2;
		int [] r = {1,2,3};
		Double area = E.collideCircle(k, r);
		assertSame("Area",113.0973355292, area);
	}

	@Test
	public void testCollideCircle3() {
		int k = 1;
		int [] r = {1,2,3};
		Double area = E.collideCircle(k, r);
		assertSame("Area",67.02064327656667, area );
	}

	// makeCircle()
	@Test
	public void testMakeCircle(){
		int k = 2;
		List<Integer> lst = intToList(a1);
		HashMap<Set<Integer>, Long> memo =new HashMap<Set<Integer>, Long>();
		E.makeCircle(k, lst, memo);
	}

	// areaCircle()
	@Test
	public void testAreaCircle1(){
		int k = 2;
		int [] r = {1,2,3,4};
		Double area = E.areaCircle(k, r);
		assertSame("Area",3455.7519189488,area);
	}
	
	@Test
	public void testFreqeunce(){
		int k =2;
		int len = 3;
		int fre = E.freqeunce(k, len);
		assertSame("The number ",fre, 18);

	}
	
//	@Test
	public void testPrintFormat() {
		Double number = 67.02064327601010101010;
		E.printFormat(number);
	}
	
	
	static List<Integer> intToList(int[] ar)  {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < ar.length; i++)	intList.add(ar[i]);
		return intList;
	}

	
	String strArray(int[] a){
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(int i =0;i<a.length;i++) {
			builder.append(a[i]);
			if(i != (a.length-1)) builder.append(",");
		}
		builder.append("}");
		return builder.toString();
	}

	
}

```
