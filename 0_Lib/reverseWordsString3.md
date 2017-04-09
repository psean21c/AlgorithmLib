### LeetCode: 557. Reverse Words in a String

```
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
```

```java
// Submit
    public String reverseWords(String s) {

    	StringBuilder builder = new StringBuilder();
    	String[] result = s.split("\\s");
    	for (int x=0; x<result.length; x++){
    		String reversed = reverse(result[x]);
    		System.out.println(result[x] + " " + reversed);
    		builder.append(reversed);
    		if(x<result.length-1) builder.append(" ");
    	}
    	
    	return builder.toString();
    }
	
    public String reverse(String s){
		String ret = new StringBuilder(s).reverse().toString();
		return ret;
    }
    
```
