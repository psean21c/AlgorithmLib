### 315. Count of Smaller Numbers After Self (LeetCode)

[Question](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)

[Answer](https://discuss.leetcode.com/topic/31910/7ms-java-solution-using-binary-indexed-tree/2)

```java

public class Solution {
    static int MAX = 100; //we set max value that can be store in the tree
    int[] tree = new int[MAX];
    
    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];
        
        //make all elements in the array posive while maintaining their order
        makePositive(nums);
    
        for(int i=nums.length-1; i>=0; i--){
            result[i] = get(nums[i]);
            add(nums[i]+1, 1);
            System.out.println();
        }
        return Arrays.asList(result);
    }
    
    public void makePositive(int[] nums){
        int min = MAX;
        for(int i=0; i<nums.length; i++)    
            min = Math.min(min, nums[i]);
        if(min < 0){
            min = -min+1;
            for(int i=0; i<nums.length; i++)
                nums[i] += min;
        }
    }
    
    public void add(int idx, int val){
    	System.out.println("add");
        while(idx<MAX){
            tree[idx] += val;
            
            //System.out.print("tree[" + idx + "]=" + tree[idx] + 
	    //" " + Integer.toBinaryString(idx) + " >> ");
            idx += (idx & (-idx));
            System.out.println("tree[" + idx + "]");
        }
    }
    
    public int get(int idx){
    	System.out.println("get");
        int result = 0;
        while(idx>0){
            result += tree[idx];
            //System.out.print("tree[" + idx + "]=" + tree[idx] + "," +  
	    //Integer.toBinaryString(idx) + ",result=" + result + " ");
            idx &= (idx-1);
            System.out.println("tree[" + idx + "]");
        }
        return result;
    }

}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int arr[] = {5, 2, 6, 1};		
		sol.countSmaller(arr);
		

	}	
```

Flow
```
5, 2, 6, 1

get
tree[1]=0,1,result=0 tree[0]
add
tree[2]=1 10 >> tree[4]
tree[4]=1 100 >> tree[8]
tree[8]=1 1000 >> tree[16]
tree[16]=1 10000 >> tree[32]
tree[32]=1 100000 >> tree[64]
tree[64]=1 1000000 >> tree[128]

get
tree[6]=0,110,result=0 tree[4]
tree[4]=1,100,result=1 tree[0]
add
tree[7]=1 111 >> tree[8]
tree[8]=2 1000 >> tree[16]
tree[16]=2 10000 >> tree[32]
tree[32]=2 100000 >> tree[64]
tree[64]=2 1000000 >> tree[128]

get
tree[2]=1,10,result=1 tree[0]
add
tree[3]=1 11 >> tree[4]
tree[4]=2 100 >> tree[8]
tree[8]=3 1000 >> tree[16]
tree[16]=3 10000 >> tree[32]
tree[32]=3 100000 >> tree[64]
tree[64]=3 1000000 >> tree[128]

get
tree[5]=0,101,result=0 tree[4]
tree[4]=2,100,result=2 tree[0]
add
tree[6]=1 110 >> tree[8]
tree[8]=4 1000 >> tree[16]
tree[16]=4 10000 >> tree[32]
tree[32]=4 100000 >> tree[64]
tree[64]=4 1000000 >> tree[128]

2 1 1 0 
```
