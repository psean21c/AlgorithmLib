
### 539. Minimum Time Difference ( week 23)

Given a list of 24-hour clock time points in "Hour:Minutes" format, 
find the minimum minutes difference between any two time points in the list.

Example 1:
```
Input: ["23:59","00:00"]
Output: 1
```

Note:
```
The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.
```

```java
//uwi
public class Solution {
	    public int findMinDifference(List<String> timePoints) {
	        int n = timePoints.size();
	        int[] s = new int[n];
	        for(int i = 0;i < n;i++){
	        	int h = Integer.parseInt(timePoints.get(i).substring(0, 2));
	        	int m = Integer.parseInt(timePoints.get(i).substring(3));
	        	s[i] = h*60+m;
	        }
	        Arrays.sort(s);
	        int min = 1440;
	        for(int i = 0;i < n;i++){
	        	int d = s[(i+1)%n]-s[i];
	        	if(d < 0)d += 1440;
	        	min = Math.min(min, d);
	        }
	        return min;
	    }
	}	

```
