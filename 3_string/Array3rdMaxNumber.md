
https://leetcode.com/problems/third-maximum-number/


```java
    public int thirdMax(int[] nums) {
		int first = -2147483648;
		int second = -2147483648;
		int third = -2147483648;
		int edge = -2147483648;
		int ret = 0;
		boolean neg8 = false, neg7 =false, neg6 = false;
		int cnt = 0;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= -2147483646){
				if(nums[i]==-2147483648) neg8 = true;
				if(nums[i]==-2147483647) neg7 = true;
				if(nums[i]==-2147483646) neg6 = true;
				edge = nums[i];
			} else if (first < nums[i] ) {
				third = second;
				second = first;
				first = nums[i];
				cnt++;
			}
		}

		if (cnt == 0) {
			if(neg8 & neg7 & neg6){
				ret = third;
			} else {
				ret = edge;
			}
		} else if (cnt == 1) {
			if((neg8 & neg7) |(neg8 & neg6) | (neg6 & neg7)){
				ret = third;
			} else {
				ret = first;
			}

		} else if (cnt == 2) {
			if(!neg8 & !neg7 & !neg6) ret = first;
			else ret =edge;
		} else {
			ret = third;
		}
		return ret;
    }
    ```
    
    
    ```java
        public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
    ```
