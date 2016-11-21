# Count the number of group in the array


###

int[] a = {0,1,1,0,1,0,1,0,1,1}

We can count 4 as the number of group of 1's as {1,1} {1}, {1}, {1,1} between 0's

```java
public class A {

	static int a[] = {0,1,1,0,1,0,1,0,1,1};
	
	public static void main(String[] args){
		int numberOfGroup  = countGroup(a);
		System.out.println(numberOfGroup);
	}
	
	static int countGroup(int[] ar){
		int cnt = 0;
		for(int i=0;i<ar.length;i++){
			if(ar[i]==1) {
				f(i);
				cnt++;
			}
		}
		return cnt;
	}
	
	static void f(int idx){
		if(idx>=a.length) return;
		if(a[idx]!=1) return;
		a[idx]=2;
		f(idx+1);
	}
}
```
