

### minimum depth
```java
    // 1st solution
    static int minDepth(TreeNode root) {
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	
		if(root==null) return 0;

		queue.add(root);
		
		int cnt=0;
		boolean isFound = false;
		while(!queue.isEmpty() & !isFound){ 
			int size = queue.size();
			for(int i=0;i<size;i++){
				if(queue.peek().left==null & queue.peek().right==null) {
					isFound = true;
					break;
				}
				if(queue.peek().left!=null)	queue.add(queue.peek().left);
				if(queue.peek().right!=null) queue.add(queue.peek().right);
				queue.poll();
			}
			++cnt;
		}
		
		return cnt;
    }
    
    // 2nd solution
    static int minDepth(TreeNode root) {
    	
    	if(root==null) return 0;
    	int depth = 0;
    	int l = minDepth(root.left);
    	int r = minDepth(root.right);
    	int min = Math.min(l, r);
    	if(min==0) depth = Math.max(l, r);
    	else depth = min;
    	return 1 + depth;
    }

```

Depicted diagram
```

   1
  / \
 2    2
/ \  / \
3 4  4  3
```


```java
static TreeNode makeTree1(){
	TreeNode ch1 = new TreeNode(2);
	ch1.left = new TreeNode(3);
	ch1.right = new TreeNode(4);
	
	TreeNode ch2 = new TreeNode(2);
	ch2.left = new TreeNode(4);
	ch2.right = new TreeNode(3);
	
	TreeNode n = new TreeNode(1);
	n.left = ch1;
	n.right = ch2;
	
	return n;
}

```

Depicted diagram
```
   1
   / \
 2    2
/ \  / \
  3     3
```

```java
static TreeNode makeTree2(){
	TreeNode ch1 = new TreeNode(2);
	ch1.right = new TreeNode(3);
	
	TreeNode ch2 = new TreeNode(2);
	ch2.right = new TreeNode(3);
	
	TreeNode n = new TreeNode(1);
	n.left = ch1;
	n.right = ch2;
	
	return n;
}
```

Depicted diagram
```
   1
  / \
     2

```
  
```java
static TreeNode makeTree3(){

	
	TreeNode ch2 = new TreeNode(2);
	
	TreeNode n = new TreeNode(1);
	n.right = ch2;
	
	return n;
}

```


Depicted diagram
```
   1
   / \
 2    2
/      \
3       4
         \
          5
```


```java
static TreeNode makeTree4(){		
	TreeNode ch3 = new TreeNode(4);
	ch3.right = new TreeNode(5);
	
	TreeNode ch2 = new TreeNode(2);
	ch2.left = new TreeNode(3);
	ch2.right = ch3;
	
	TreeNode n = new TreeNode(1);
	n.right = ch2;
	
	return n;
}
```



```java
public static void main(String[] args) {
	TreeNode n1 = makeTree1();
	System.out.println(minDepth(n1));
	TreeNode n2 = makeTree2();
	System.out.println(minDepth(n2));
	TreeNode n3 = makeTree3();
	System.out.println(minDepth(n3));
	TreeNode n4 = makeTree4();
	System.out.println(minDepth(n4));
	TreeNode n5 = new TreeNode(4);
	System.out.println(minDepth(n5));
}

```

### Level Order

Depicted diagram
```

 3
/ \
9  20
  /  \
 15   7

```

```java
//1st solution.. Poor...un neccessary complicated.. 
static List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> lstList = new ArrayList<List<Integer>>();
	
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	Queue<TreeNode> tmp = new LinkedList<TreeNode>();
	List<Integer> lst = new ArrayList<Integer>();

	if(root==null) return lstList;

	queue.add(root);
	TreeNode vertex = root;
	while(!queue.isEmpty()){ 
		vertex = queue.poll();
		lst.add(vertex.val);
		// Didn't know how to use size() ..
		
		if(vertex.left!=null) {
			tmp.add(vertex.left);
		}
		if(vertex.right!=null){
			tmp.add(vertex.right);
		}
		if(queue.isEmpty()){
			lstList.add(lst);
			lst = new ArrayList<Integer>(); // new object needs to be initialzed in line 17 before using
			if(!tmp.isEmpty()){
				queue.addAll(tmp);
				tmp.clear();
			}
		}

	}
	return lstList;
}


// 2nd solutoin Maybe it's the best solution..
static List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> lstList = new ArrayList<List<Integer>>();
	Queue<TreeNode> queue = new LinkedList<TreeNode>();

	if(root==null) return lstList;

	queue.add(root);
	
	while(!queue.isEmpty()){ 
		int size = queue.size();
		List<Integer> lst = new ArrayList<Integer>();
		
		for(int i=0;i<size;i++){
			if(queue.peek().left!=null) queue.add(queue.peek().left);
			if(queue.peek().right!=null) queue.add(queue.peek().right);
			lst.add(queue.poll().val);
		}
		lstList.add(lst);

	}
	return lstList;
}

```



Template for levelOrder()
```java
package nov;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}


public class B {

	static TreeNode tree = null;

	static TreeNode makeTree(){
		TreeNode ch1 = new TreeNode(9);
		TreeNode ch2 = new TreeNode(20);
		ch2.left = new TreeNode(15);
		ch2.right = new TreeNode(7);
		
		TreeNode n = new TreeNode(3);
		n.left = ch1;
		n.right = ch2;
		
		return n;
	}

	
    static List<List<Integer>> levelOrder(TreeNode root) {
    }

	
	public static void main(String[] args) {
		TreeNode n = makeTree();
		List<List<Integer>> llst = levelOrder(n);
		
		for(List<Integer> lst:llst){
			for(Integer l:lst){
				System.out.print(l + " ");
			}
			System.out.println();
		}
	}
	
}

```
### Symmetric Tree
```
// 1st solution.. performance is very bad...
public class Solution {
	static boolean symetricList(List<Integer> lst){
		boolean isSymmetric = true;
		int size = lst.size();
		for(int i=0;i<size/2;i++){
			
			if(!lst.get(i).equals(lst.get(size-i-1))) {
				//isSymmetric = false;
				return false;
			}
		}
		
		return isSymmetric;
	}    
    public boolean isSymmetric(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	TreeNode tmp = new TreeNode(-1);
		if(root==null) return true;

		boolean isSymmetric = true;
		queue.add(root);
		
		while(!queue.isEmpty()){ 
			int size = queue.size();
			List<Integer> lst = new ArrayList<Integer>();
			int cnt = 0;
			for(int i=0;i<size;i++){
				if(queue.peek().left!=null)	{
					queue.add(queue.peek().left);
				} else {
					queue.add(tmp);
				}
				if(queue.peek().right!=null) {
					queue.add(queue.peek().right);
				} else{
					queue.add(tmp);
				}
				if(queue.peek().left==null && queue.peek().right==null) cnt++;
				lst.add(queue.poll().val);
			}
			//printList(lst);
			if(!symetricList(lst)) return false;
			if(cnt==size) break;
		}
		
		return isSymmetric;        
    }
}


// 2nd solution
static boolean isSymmetric(TreeNode root) {

	if(root==null) return true;
	return doMirror(root.left,root.right);
}

static boolean doMirror(TreeNode node1, TreeNode node2){

	if(node1==null && node2==null) return true;
	if(node1==null || node2==null) return false;

	boolean isSame = (node1.val == node2.val);
	boolean mirror1 = doMirror(node1.left, node2.right) & isSame;
	boolean mirror2 = doMirror(node1.right, node2.left) & isSame;
	boolean isMirror = mirror1 && mirror2;

	return isMirror;
}
```

```java
public static void main(String[] args) {

	TreeNode n1 = makeTree1();
	boolean is = isSymmetric(n1);
	System.out.println(is);
	
	System.out.println("--------------------");
	TreeNode n2 = makeTree2();
	is = isSymmetric(n2);
	System.out.println(is);
}

```

### Queue Sample
```java
	static void queueRun(){

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		for(Integer q:queue){
			System.out.print(q + " ");
		}
		System.out.println();

		queue.poll();
		queue.poll();
		queue.poll();
		if(queue.poll()==null) {
			System.out.print("No such an element ");
			//return;
		}

		for(Integer q:queue){
			System.out.print(q + " ");
		}
		
		
	}
```
