package linkedList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by sergiu.filip on 1/20/2017.
 */
public class Swap {
    static class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }

    }

    public static String toString(Node n){
        Node node = n;
        String s = ""+node.value;
        while(node.next != null){
            s+="->"+node.next.value;
            node = node.next;
        }
        return s;
    }
    public static Node getNode(int[] values){
        Node previousNode = null;
        Node root = null;
        for(int i=0;i< values.length;i++){
            Node node = new Node(values[i]);
            if(root == null){
                root = node;
                previousNode = node;
            }else{
                previousNode.next = node;
                previousNode = node;
            }
        }
        return root;
    }
    public static Node swap(Node root){
        Node node = root;
        while(node.next != null){
            int value = node.value;
            node.value = node.next.value;
            node.next.value = value;
            if(node.next.next != null){
                node = node.next.next;
            }else{
                break;
            }
        }
        return root;
    }

    public static void main(String[] s){
        int[] val1 = {1,2,3,4,5,6};
        Node node1 = getNode(val1);


        System.out.println("Before "+toString(node1));
        Node node2 = swap(node1);
        System.out.println("After "+toString(node2));
        System.out.println();

        val1 = new int[]{1,2,3,4,5};
        node1 = getNode(val1);
        System.out.println("Before "+toString(node1));
        node2 = swap(node1);
        System.out.println("After "+toString(node2));
    }
}
