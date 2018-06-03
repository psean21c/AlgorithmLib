
### 541. Reverse String II (leetcode/ week-23)

Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. 

If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

Example:
```
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
```
Restrictions:
```
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
```


```java
//lerry.z
public class Solution {
    public String reverseStr(String s, int k) {
        String ans = "";
        int base = 2*k;
        String tmp = "";
        for(int i = 0; i < s.length(); i++) {
            if(i%base < k) {
                tmp = s.charAt(i) + tmp;
            } else {
                ans += tmp + s.charAt(i);
                tmp = "";
            }
        }
        ans += tmp;
        return ans;
    }
}

//uwi
public class Solution {
	    public String reverseStr(String s, int k) {
	        int n = s.length();
	        char[] t = s.toCharArray();
	        for(int i = 0;i < n;i += 2*k){
	        	int j = Math.min(i+k, n);
	        	for(int u = i, v = j-1;u < v;u++,v--){
	        		char d = t[u]; t[u] = t[v]; t[v] = d;
	        	}
	        }
	        return new String(t);
	    }
	}	
  
// shik (Taiwan)
class Solution {
public:
    string reverseStr(string s, int k) {
        for (int i = 0; i < s.size(); i += k * 2) {
            int v = min<int>(s.size(), i + k);
            reverse(s.begin() + i, s.begin() + v);
        }
        return s;
    }
};
```
