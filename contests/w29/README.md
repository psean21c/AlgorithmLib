

### Day-1

[Original Question](https://www.hackerrank.com/contests/w29/challenges/day-of-the-programmer)

```java
public class Solution {

	static boolean GregorianleapYear(int year){
		if( (year%400==0 || year%100!=0) &&(year%4==0))
			return true;
		else return false;
	}
	
	static boolean JulianleapYear(int year){
		if(year%4==0) return true;
		else return false;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y = in.nextInt();
        boolean isLeap = false;
        String mm = "09";
        int dd = 0;
        // your code goes here
        if(y<=1917){
        	isLeap = JulianleapYear(y);
        	if(isLeap) dd = 12;
        	else dd = 13;
        } else if(y==1918){
        	dd = 26;
        } else {
        	isLeap = GregorianleapYear(y);
        	if(isLeap) dd = 12;
        	else dd = 13;
        }
        
        String converted = String.valueOf(dd) + "." + mm + "." + String.valueOf(y);
        System.out.println(converted);
        
    }
}

```
