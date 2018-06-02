import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class DirectedGraph {

	// Node 
	class Node {
		int value;
		List<Integer> children;
		boolean visited = false;
		
	    Node() {}
	    Node(int p) { value = p;  }
	}
	
	// Main container to hold all node in the graph during the test
	public List<Node> nodes;
	public DirectedGraph(){
		nodes = new ArrayList<Node>();
	}

	// validate if 'nodes' contains this value of node
	private boolean contains(int v){
		for(Node node:nodes){
			if(node.value==v) return true;
		}
		return false;
	}
	
	// return the index for this value of node
	private int nodeIndex(int v){
		int i = 0;
		for(Node node:nodes){
			if(node.value==v) break;
			i++;
		}
		return i;
	}
	
	// reset the visited = false in order to re-use it.
	public void resetVisited(){
		for(Node node:nodes){
			node.visited = false;
		}
	}

	/*** Use DFS(Depth First Search) algorithm
	Validate whether or not the graph has any cycle
	***/
	public boolean isCycled(int target,int next){
		if(!contains(next)) return false;
		boolean cycle = dfs(target,next);
		
		resetVisited();
		return cycle;
	}
	
	private boolean dfs(int target,int next){
		if(target==next) return true;
		if(!contains(next)) return false;
		
		int start = nodeIndex(next);
		if(target==nodes.get(start).value) return true;
		
		nodes.get(start).visited = true;
		boolean cycle = false;
		
		List<Integer> children = nodes.get(start).children;
		for(Integer child:children){
			if(child!=-1){
				cycle |= dfs(target,child);
				if(cycle) break;
			}
		}
			
		return cycle;
	}
	
	/*** Use BFS(Breadth First Search) algorithm
	to print Node value in terms of level
	Strategy : Use value [-1] for the Node having No children.
	***/
	public void printNode(int start){
		List<List<Integer>> lstList = new ArrayList<List<Integer>>();
		Queue<Integer> queue = new LinkedList<Integer>();
		try {
			int idx = nodes.get(start).value;
			nodes.get(start).visited = true;
			queue.add(idx);

			while (!queue.isEmpty()) {
				List<Integer> lst = new ArrayList<Integer>();
				int size = queue.size();

				for (int i = 0; i < size; i++) {
					if(queue.peek()!=-1 & !contains(queue.peek())){
						
					} else{
						int ind = nodeIndex(queue.peek());
						List<Integer> children = nodes.get(ind).children;
						for (Integer child : children) {
							if (child == -1 & !contains(child))
								break;
							else if (child != -1 & !contains(child)) {
								queue.add(child);
							} else {
								int childIdx = nodeIndex(child);
								if (!nodes.get(childIdx).visited) {
									queue.add(child);
									nodes.get(childIdx).visited = true;
								}
							}
						}
					}
					lst.add(queue.poll());
				}
				lstList.add(lst);
			}

			// reset visited marks to false again for the future use
			resetVisited();
			
			// print value of nodes at each level
			int i = 0;
			for (List<Integer> lst : lstList) {
				System.out.print("At " + (++i) + " level :\t");
				for (Integer l : lst) {
					System.out.print(l + " ");
				}
				System.out.println();
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBoundsException");

		}
	}
	
	/*** insert method to add new Node
	Strategy : Try to make sure if the new Node will form any cycle before adding it.
	***/
	public void insertNode(int v,int child){
		Node newNode = new Node(v);
		
		// Make sure whether or not this new node will create cycle, if possible, skip
		if(isCycled(v,child)) {
			System.out.println("Not able to insert because " + v + "->" + child + " will cause Cycle");
			return;
		}
		
		// if node already exists, only need to add child to children
		if(nodes!=null && contains(v)){ 
			int idx = nodeIndex(v);
			List<Integer> children = nodes.get(idx).children;
			children.add(child);
			newNode.children = children;
			nodes.set(idx, newNode);
		} else{ // if not exist, create new Node, and then add it to Set
			List<Integer> children = new ArrayList<Integer>();
			children.add(child);
			newNode.children = children;
			nodes.add(newNode);
		}
	}
 
}
