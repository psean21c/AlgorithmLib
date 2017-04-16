
```java
package hacker;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static long makeChange(int[] coins, int money) {
		return makeChange(coins, money, 0, new HashMap<String, Long>());
	}
	
	public static long makeChange(int[] coins,int money, int index, HashMap<String, Long> memo){
		if(money ==0) return 1;
		if(index >= coins.length) return 0;
		
		// memoization
		String key = money + "-" + index;
		if(memo.containsKey(key)) return memo.get(key);
		
		int amountWithCoin = 0;
		long ways = 0;
		while(amountWithCoin <=money){
			int remain = money - amountWithCoin;
			ways += makeChange(coins,remain, index + 1, memo);
			amountWithCoin += coins[index];
		}
		memo.put(key, ways);
		return ways;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        long ways = makeChange(coins, 10);
        System.out.println(ways);
    }
}

```
