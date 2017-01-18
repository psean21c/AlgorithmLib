class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {

	static ListNode head = null;

	static ListNode makeNode() {
		head = new ListNode(1);
		ListNode current = head;

		current.next = new ListNode(2);
		current = current.next;

		current.next = new ListNode(3);
		current = current.next;

		current.next = new ListNode(4);
		current = current.next;

		current.next = new ListNode(5);
		current = current.next;
		
//		current.next = new ListNode(6);
//		current = current.next;
		
		return head;
	}
	
    static ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode current = head;
    	ListNode next = null;
    	ListNode previous = null;
    	
    	ListNode t1 = null;
    	ListNode t2 = null;
    	
    	
    	if(m>n || m==n || current==null) return head;
    	
    	int cnt = 1;
    	while(current!=null){
    		
			next = current.next;
    		if(cnt==m){ // starting reverse
    			if(m==1){
        			current.next = previous;
        			previous = current;
        			
    				t2 = previous;
    				t2.next = null;
    				
    			} else {
    				t1 = previous;
    				t1.next = null; // wait until reverse is done
    				
    				previous = current;
    				previous.next = null;
    				t2 = previous;
    				t2.next = null;
    				
    			}
    			
    		} else if(cnt>m  && cnt<n){ // doing reverse 
    			current.next = previous;
    			previous = current;
    			

    		} else if(cnt==n){ // ending reverse
    			current.next = previous;
    			previous = current;
    			
    			if(m==1){
    				head = previous;
    			} else {
        			t1.next = previous; // t1
        			previous = t2;
    			}
    			
    			if(next==null){
    				
    			} else {
        			t2.next = next;    // t2 ??
    			}
    			
    			
			} else { // keeping the same order
    			previous = current;
			}
			current = next;
    		
    		cnt++;
    		
    	}
    	
    	return head;
   	
    }
	
    static ListNode reverseBetween2(ListNode head, int m, int n) {
    	
    	ListNode current = head;
    	ListNode next = null;
    	ListNode previous = null;
    	
    	ListNode t1 = null;
    	ListNode t2 = null;
    	
    	
    	if(m>n || m==n || current==null) return head;
    	
    	int cnt = 1;
    	while(current!=null){
    		
    		if(cnt==m){ // starting reverse
    			if(m==1){
        			next = current.next;
        			current.next = previous;
        			previous = current;
        			
    				t2 = previous;
    				t2.next = null;
    				
        			current = next;
    			} else {
    				next = current.next;
    				t1 = previous;
    				t1.next = null; // wait until reverse is done
    				
    				previous = current;
    				previous.next = null;
    				t2 = previous;
    				t2.next = null;
    				
    				current = next;
    			}
    			
    		} else if(cnt>m  && cnt<n){ // doing reverse 
    			next = current.next;
    			current.next = previous;
    			previous = current;
    			
    			current = next;

    		} else if(cnt==n){ // ending reverse
    			next = current.next;
    			current.next = previous;
    			previous = current;
    			
    			if(m==1){
    				head = previous;
    			} else {
        			t1.next = previous; // t1
        			previous = t2;
    			}
    			
    			if(next==null){
    				
    			} else {
        			t2.next = next;    // t2 ??
    			}
    			
    			current = next;
    			
			} else { // keeping the same order
    			next = current.next;
    			previous = current;
    			current = next;
			}
    		cnt++;
    		
    	}
    	
    	return head;
    }
    
	static ListNode reverseList2(ListNode head) {

		ListNode current = head;
		ListNode previous = null;

		while (current !=null) {
			ListNode next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	static ListNode reverseList(ListNode head) {
		
		if(head ==null || head.next==null) return head;
	    ListNode p = reverseList(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;		

	}

	static void deleteNode(ListNode node) {
		ListNode current = head;
		ListNode previous = head;
		while (current.next != null) {
			if (current.val == node.val) {
				previous.next = current.next;
			}
			previous = current;
			current = current.next;
		}
	}

	static void printNode(ListNode node) {
		System.out.print(node.val + " ");
		while (node.next != null) {
			node = node.next;
			System.out.print(node.val + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode n = new ListNode(2);
		printNode(n);

		ListNode n1 = makeNode();
		printNode(n1);

		ListNode n2 = reverseBetween(head,1,5); 
//		ListNode n2 = reverseBetween(head,1,3); 
//		ListNode n2 = reverseBetween(head,2,5); 
//		ListNode n2 = reverseBetween(head,2,4); 
		printNode(n2);

		ListNode n3 = reverseList(head);
		printNode(n3);

	}


}
