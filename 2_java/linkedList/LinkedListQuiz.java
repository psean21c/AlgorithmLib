class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class LinkedListQuiz {

	static ListNode makeNode() {
		ListNode head1 = new ListNode(1);
		ListNode current = head1;

		current.next = new ListNode(2);
		current = current.next;

		current.next = new ListNode(3);
		current = current.next;

		current.next = new ListNode(4);
		current = current.next;

		// current.next = new ListNode(5);
		// current = current.next;

		return head1;
	}

	static void printNode(ListNode node) {
		System.out.print(node.val + " ");
		while (node.next != null) {
			node = node.next;
			System.out.print(node.val + " ");
		}
		System.out.println();
	}

	
	/***
	 * Basic : append / delete / reverse
	 */
	static  ListNode appendNode(ListNode head,int data) {
        return null;
    }
	
	static ListNode deleteNode(ListNode head,int data) {
		return head;
	}
	
	static ListNode reverseList(ListNode head) {
		return head;
	}


	/***
	 * Advanced: swap pairs / merge / reverse for between
	 */
	static ListNode swapPairs(ListNode head) {
		// You need to implement below
		return head;
	}

	static ListNode mergeTwoLists(ListNode lst1, ListNode lst2) {
		return lst1;
	}

	static ListNode reverseBetween(ListNode head, int m, int n) {
		return head;
	}


	public static void main(String[] args) {

		ListNode n1 = makeNode();
		printNode(n1);

		ListNode n2 = swapPairs(n1);
		printNode(n2);
	}

}
