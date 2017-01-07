
### Basic prime() function
```cpp
#include <iostream>
#include <cstddef>
#include <cmath>
using namespace std;


bool isPrime(int n){
	if(n<=1) return false;
	if(n==2) return true;
	if(n%2==0) return false;
	int sqrtn = int(sqrt(n));
	for(int div=3;div <=sqrtn; div +=2){
		if(n%div ==0) return false;
	}
	return true;
}

int main() {
    int T;
    cin >> T;
    while (T-->0) {
    	int n;
    	cin >> n;
    	if(isPrime(n)) cout << "Prime" <<endl;
    	else cout << "Not prime" << endl;
    }
}

```

### Other Question

[101 Hacker44 Question](https://www.hackerrank.com/contests/101hack44/challenges/alice-and-bobs-silly-game)

```cpp
import java.util.Scanner;

public class C {
	static int N = 100000;

	static int ar[] = new int[N + 1];
//	static boolean isPrime[] = new boolean[N];

	static void fillPrime() {

		ar[0] = 0;
		ar[1] = 0;
		ar[2] = 1;
		int cnt = 1;

		for (int i = 3; i <= N; i++) {
			boolean isPrime = true;

			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) cnt++;
			ar[i] = cnt;
		}

//		 for(int i=0;i<ar.length;i++){
//			 System.out.print(i + ":" + ar[i] + "\t");
//		 }

	}

	public static void main(String[] args) {
		fillPrime();
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		for (int i = 0; i < g; i++) {
			int n = in.nextInt();
			if (ar[n] % 2 == 0)
				System.out.println("Bob");
			else
				System.out.println("Alice");
		}
	}
}
```

CoPrime
```java
// GCD(X,Y) and CoPrime
public static int gcd(int x, int y) {
    if (y == 0) return x;
    else if (x >= y && y > 0) return gcd(y, (x % y));
    else return gcd(y, x);
}
	
	
private static boolean isCoPrime(int a, int b) {
	return gcd(a, b) == 1;
}

```
