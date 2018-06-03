

[Original Question](https://www.hackerrank.com/challenges/java-negative-subarray)

```java
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int a1 = a[i];
			if (a1 < 0)	cnt++;
			int sum = a1;
			for (int j = i + 1; j < n; j++) {
				// System.out.print(a1 + ": "+ a[j] + " ");
				sum += a[j];
				if (sum < 0)	cnt++;
				a1 = a[j];
			}
			// System.out.println();
		}
		System.out.println(cnt);
		in.close();
	}

```
