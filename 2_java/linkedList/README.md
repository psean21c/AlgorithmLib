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
	
	// 6) detect cycle
	public boolean hasCycle(Node head) {
		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Node head = null;
		int T = sc.nextInt();

		while (T-->0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		display(head);

		head = reverse(head);
		display(head);

		head = removeDup(head);
		display(head);
		
		sc.close();

	}
    
}

```

### Add function : insert()

```java
/***
Important to understand what current is trying to do for the head.
 head -> [A] -> [B] -> [C] -> NULL
 while:
 current -> [A]
 current -> [B]  after current = current.next;
 current -> [C]  after current = current.next;
 current -> [D]  after current.next = tmp;
***/

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

```

![append](https://cloud.githubusercontent.com/assets/5623445/21731556/ebe1b566-d422-11e6-94db-2c7e2b06114d.PNG)

### show function : display()

```java
public static void display(Node head){
	Node current = head;
	System.out.print(current.data + " ");
	while (current.next != null) {
		current = current.next;
		System.out.print(current.data + " ");
	}
}

```

### reverse LinkedList function : reverse()

```java
/***
Important to understand that 
1) current /next variables works as temporary containers 
 to hold current/next values for each step
2) When finished while(), "head" need to get last node from the "current" &
   the "next of head" points to "previous"
***/
public static  Node reverse(Node head) {
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
```
![linked-list-reversal](https://cloud.githubusercontent.com/assets/5623445/21732597/3b1f80ae-d428-11e6-871b-b9c09ad27245.png)


### removde duplicate: removeDup()
```java

public static Node removeDup(Node head) {
	Node head2 = new Node(head.data);
	while(head.next !=null){
		head = head.next;
		if(noDup(head2, head.data)) {
			// 1)
			head2 = insert(head2,head.data);
			
			// 2)
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
```

### hasCycled()
```java

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


// My approach..
// 1 -> 2 -> 3 -> 4
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
	
// slow/fast algorithm ..
boolean hasCycle(Node head) {
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
```
