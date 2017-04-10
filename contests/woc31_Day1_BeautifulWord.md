
https://www.hackerrank.com/contests/w31/challenges/beautiful-word

```java
package hacker.com.week31;


import java.util.Scanner;

public class A {

	boolean isVowels(char c){
		if(c=='a' | c=='e' | c=='i'| c=='o'| c=='u'| c=='y') return true;
		else return false;
	}
	
	boolean isBeautifulWord(String word){
		char prev = word.charAt(0);
		boolean isDetectedDup = false;
		for(int i=1;i<word.length();i++){
			char c= word.charAt(i);
			if((isVowels(prev) & isVowels(c)) | prev == c){
				isDetectedDup = true;
			}
			if(isDetectedDup) return false;
			prev = c;
		}
		return true;
	}
	
	void run() {
        Scanner in = new Scanner(System.in);
        String w = in.next();
        boolean isBeautiful = isBeautifulWord(w);
        if(isBeautiful) System.out.println("Yes");
        else System.out.println("No");
        
	}
	
    public static void main(String args[]) {
        new A().run();
    }
    
}

```
