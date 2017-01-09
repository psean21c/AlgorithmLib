class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
	
	static ListNode head = null;
	
	static ListNode makeNode(){
		head = new ListNode(1);
		ListNode current = head;
		
		current.next = new ListNode(2);
		current = current.next;
		
		current.next = new ListNode(3);
		current = current.next;
		
		current.next = new ListNode(4);
		current = current.next;
		
		return head;
	}
	
	static void printNode(){
		ListNode node = head;
		System.out.print(node.val + " ");
		while(node.next!=null){
			node = node.next;
			System.out.print(node.val + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		makeNode();
		ListNode n = new ListNode(2);
		
		printNode();
		deleteNode(n);
		printNode();
		
	}
	
    static void deleteNode(ListNode node) {
    	ListNode current = head;
		ListNode previous = head;
    	while(current.next!=null){
    		if(current.val == node.val){
    			previous.next = current.next;
    		}
    		previous = current;
    		current = current.next;
    	}
    }
}
