package nov;

import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

class A {

	// 1) add
	public static Node insert(Node head, int data) {

		Node tmp = new Node(data);
		if (head == null) {
			return tmp;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = tmp;
			return head;
		}
	}

	// 2) show
	public static void display(Node head) {
		Node current = head;
		System.out.print(current.data + " ");
		while (current.next != null) {
			current = current.next;
			System.out.print(current.data + " ");
		}
		System.out.println();
	}

	// 3) reverse
	public static Node reverse(Node head) {
		Node current = head;
		Node previous = null;
		Node next = null;
		while(current.next !=null){
			next = current.next;
			current.next = previous; 
			previous = current;
			current = next;
		}
		head = current;
		head.next = previous;
		return head;
	}

	// 4) remove
	public static Node remove(Node head, int data) {
		Node current = head;
		Node previous = head;
		
		while(current.next!=null){
			current = current.next;
			if(current.data==data){
				previous.next = current.next;
			}
			previous = current;
		}
		return head;
	}

	// 5) remove dup
	public static Node removeDup(Node head) {
		Node head2 = new Node(head.data);
		while(head.next !=null){
			head = head.next;
			if(noDup(head2, head.data)) {
//				head2 = insert(head2,head.data);
				Node current = head2;
				while(current.next!=null){
					current = current.next;
				}
				Node tmp = new Node(head.data);
				current.next = tmp;
			}
		}
		return head2;
	}
	
	static boolean noDup(Node current,int data){
		while (current!=null){
			if(current.data==data) return false;
			current = current.next;
		}
		return true;
	}
	
	// 6) detect cycle
	static boolean hasCycle(Node head) {
		
		if(head.next==null) return false;
		
		boolean isCycled = false;
		Node current = head;
		int cnt = 0;
		while(current.next!=null){
			
			cnt++;
			current = current.next;
			Node ptr = head;
			for(int i=0;i<cnt;i++){
				
				if(current.next ==ptr) {
					isCycled = true;
					break;
				}
				ptr = ptr.next;
			}
			if(isCycled) break;
		}
		return isCycled;
	}
	
	// 6) Solution by others
	boolean hasCycle2(Node head) {
	    if (head == null) return false;
	    
	    Node slow = head;
	    Node fast = head.next;
	    while (slow != fast) {
	        if (fast == null || fast.next == null) return false;
	        
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    
	    return true;
	}

	
	
	static Node makeCycleNode(){
		Node head = new Node(1);
		Node current = head;
		
		current.next = new Node(2);
		current = current.next;
		
		current.next = new Node(3);
		current = current.next;
		
		current.next = head;
		
		return head;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Node head = null;
		int T = sc.nextInt();

		while (T-->0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		
		head = reverse(head);
		display(head);

		head = removeDup(head);
		display(head);

		head = remove(head,2);
		display(head);
		
		Node head2 = makeCycleNode();
		boolean isCycled = hasCycle(head2);
		System.out.println(isCycled);

		sc.close();

	}

}
