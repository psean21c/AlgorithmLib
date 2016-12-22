# Sorting

### Bubble Sorting

1) Compare adjacent elements. If the first is greater than the second, swap them.

2) Do this for each pair of adjacent elements, starting with the first two and ending with the last two. At this point the last element should be the greatest. 

3) Repeat the steps for all elements except the last one. 

4) Continue for one less element each time, until there are no more pairs to compare.


Because the biggest number will be moved to the last element during each iteration,
 We have to continue for one less element (excluding the last element) each time.
Bubble sort has worst-case and average complexity both О(n2) 


```java
public class Bubble {
	  
    public static void Sort(List<Integer> lst){
    	int len = lst.size();
    	printSort(lst);


    	for(int n=len-1; n> 0 ; n--){
    		for(int i=0; i<len-1; i++){
        		int j = i + 1;
    			if(lst.get(i) > lst.get(j)){
	    	        int temp;
	    	        temp = lst.get(i);
	    	        lst.set(i, lst.get(j));
	    	        lst.set(j, temp);
    			}
    		}
    	}
    	printSort(lst);
    }


    private static void printSort(List<Integer> lst){
    	for(Integer x:lst){
    		System.out.print(" " + x);
    	}
    	System.out.println();
    }
  
    public static void main(String[] args) {
    	Integer[] array = new Integer[] {12,11,10,9,8,7,6,5,4,3,2,1,0 };
    	List<Integer> input = Arrays.asList(array);
        Sort(input);
    }
}
```

---

# Sorting

### BST (Binary Search Tree)

[Original Question](https://www.hackerrank.com/challenges/30-binary-search-trees)

input / output
```
7
3
5
2
1
4
6
7

>> 3
```

![Depiction](https://cloud.githubusercontent.com/assets/5623445/21410971/da4a4c5e-c7b2-11e6-8a43-3a834aac4b4b.png)

 * Requirement
 To implement the method : getHeight()

```cpp
#include <iostream>
#include <cstddef>

using namespace std;

class Node {
public:
	int data;
	Node *left;
	Node *right;
	Node(int d) {
		data = d;
		left = NULL;
		right = NULL;
	}
};

class Solution {
public:
	Node* insert(Node* root, int data) {
		if (root == NULL) {
			return new Node(data);
		} else {
			Node* cur;
			if (data <= root->data) {
				cur = insert(root->left, data);
				root->left = cur;
			} else {
				cur = insert(root->right, data);
				root->right = cur;
			}

			return root;
		}
	}
	/***
	int getHeight(Node* root) {
		//Write your code here
	}
	***/
};


int main() {
	Solution myTree;
	Node* root = NULL;
	int T;
	int data;

	cin >> T;

	while (T-- > 0) {
		cin >> data;
		root = myTree.insert(root, data);
	}
	int height = myTree.getHeight(root);
	cout << height;

	return 0;
}

```

My Solution

```cpp
	int getHeight(Node* root) {
		//Write your code here
		if(root == NULL) return -1;

		int leftHeight = getHeight(root->left);
		int rightHeight = getHeight(root->right);

		return 1+ max(leftHeight,rightHeight);
	}
```


