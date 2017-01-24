
```java
// My solution.. Poor... complicated.. uncessary
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


```


```java
// Other's
    static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
    

```


```java
package nov;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 3
/ \
9  20
  /  \
 15   7

***/


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

	
	// bfs()
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
			if(vertex.left!=null) {
				tmp.add(vertex.left);
			}
			if(vertex.right!=null){
				tmp.add(vertex.right);
			}
			if(queue.isEmpty()){
				lstList.add(lst);
				lst = new ArrayList<Integer>();
				if(!tmp.isEmpty()){
					queue.addAll(tmp);
					tmp.clear();
				}
			}

		}
		return lstList;
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
	
}

```
