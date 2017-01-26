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
	
	// Other's solution
	static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummyhead = new ListNode(0);
		dummyhead.next = head;
		ListNode sublisthead = new ListNode(0);
		ListNode sublisttail = new ListNode(0);
		int count = 1;
		ListNode pre_cur = dummyhead, cur = head;
		while(count <=n){
			ListNode temp = cur.next;
			if (count < m)
				pre_cur = cur;
			else if (count == m){
				sublisttail = cur;
				sublisthead.next = cur;
			}else if (count > m){
				cur.next = sublisthead.next;
				sublisthead.next = cur;
			}
			cur = temp;
			++count;
		}
		pre_cur.next = sublisthead.next;
		sublisttail.next = cur;
		return dummyhead.next;
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
	// Recursive way
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

	static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}
	static ListNode mergeTwoLists(ListNode lst1, ListNode lst2) {
        ListNode nHead = new ListNode(0);
        ListNode n1 = nHead;
        
        if(lst1==null & lst2!=null)      	return lst2;
        if(lst1!=null & lst2==null)        	return lst1;
        if(lst1==null & lst2==null)        	return null;
        
        
        while(lst1!=null || lst2!=null){
        	ListNode tmp  = null;
        	if(lst1==null){
        		tmp = new ListNode(lst2.val);
        		n1.next = tmp;
        		n1 = n1.next;
        		lst2 = lst2.next;
        		
        	} else if(lst2==null){
        		tmp = new ListNode(lst1.val);
        		n1.next = tmp;
        		n1 = n1.next;
        		lst1 = lst1.next;
        		
        	} else if(lst1.val<=lst2.val){
        		tmp = new ListNode(lst1.val);
        		n1.next = tmp;
        		n1 = n1.next;
        		lst1 = lst1.next;
        	} else {
        		tmp = new ListNode(lst2.val);
        		n1.next = tmp;
        		n1 = n1.next;
        		lst2 = lst2.next;
        	}
        }

    	return nHead.next;
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
