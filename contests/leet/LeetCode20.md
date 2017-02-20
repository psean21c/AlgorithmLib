
###520. Detect Capital My SubmissionsBack To Contest

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.

Example 1:
```
Input: "USA"
Output: True
```
Example 2:
```
Input: "FlaG"
Output: False
```
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

```java
public boolean detectCapitalUse(String word) {


    boolean isFirstCap = false;
    char ch0 = word.charAt(0);
    int ascii = (int) ch0;
    int upper = 0;
    int lower = 0;
    if(ascii >=65 & ascii <=90)  {
        isFirstCap = true;
    }

    for(int i=0;i<word.length();i++){
        char ch = word.charAt(i);
        ascii = (int) ch;
        if(ascii >=65 & ascii <=90){  // A-Z
            upper += 1;
        } else if(ascii >=97 & ascii <=122){ // a-z
            lower += 1;
        }
    }

    boolean detected = false;
    if(isFirstCap){
        if(upper == word.length() || upper == 1) detected = true;
    } else {
        if(lower == word.length()) detected = true;
    }
    return detected;
}
```
### 525. Contiguous Array My SubmissionsBack To Contest

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
```
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
```
Example 2:
```
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
```
Note: The length of the given binary array will not exceed 50,000.

```java

```
