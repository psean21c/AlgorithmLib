

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

```

   1
  / \
 2    2
/ \  / \
3 4  4  3
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

```
   1
   / \
 2    2
/ \  / \
  3     3
```

  
```java
static TreeNode makeTree3(){

	
	TreeNode ch2 = new TreeNode(2);
	
	TreeNode n = new TreeNode(1);
	n.right = ch2;
	
	return n;
}

```

```
   1
  / \
     2

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

```

 3
/ \
9  20
  /  \
 15   7

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
