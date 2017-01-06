It is important that you should be able to implement basic methods regarding LinkedList.

```java
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
	public static  Node insert(Node head,int data) {
		return null;
	}
	
	// 2) show
	public static void display(Node head){
		
	}
	
	// 3) reverse
	public static  Node reverse(Node head) {
		return null;
	}
	
	// 4) remove 
	public static  Node remove(Node head,int data) {
		return null;
	}
	
	// 5) remove dup
	public static  Node removeDup(Node head) {
		return null;
	}
	
    public static void main(String[] args) {
 	   
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
    
}

```
