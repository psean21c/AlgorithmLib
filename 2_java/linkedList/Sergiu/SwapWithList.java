package linkedList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by sergiu.filip on 1/20/2017.
 */
public class SwapWithList {
    static class Element{
        int value;
        Element(int value){
            this.value = value;
        }
    }
    public static LinkedList<Element> getList(int[] values) {
        LinkedList<Element> list = new LinkedList<Element>();
        for (int i = 0; i < values.length; i++) {
            list.add(new Element(values[i]));
        }
        return list;
    }
    public static LinkedList<Element> swap(LinkedList<Element> root){
        Iterator<Element> it = root.iterator();
        while(it.hasNext()) {
            Element e1 = it.next();
            Element e2 = null;
            if(it.hasNext()){
                e2 = it.next();
                int value = e1.value;
                e1.value = e2.value;
                e2.value = value;
            }

        }
        return root;
    }

    public static String toString(LinkedList<Element>  n){

        String s = ""+n.get(0).value;
        for(int i=1;i<n.size();i++){
            s+= "->"+n.get(i).value;
        }

        return s;
    }

    public static void main(String[] s){
        int[] val1 = {1,2,3,4,5,6};
        LinkedList<Element> node1 = getList(val1);


        System.out.println("Before "+toString(node1));
        LinkedList<Element> node2 = swap(node1);
        System.out.println("After "+toString(node2));
        System.out.println();

        val1 = new int[]{1,2,3,4,5};
        node1 = getList(val1);
        System.out.println("Before "+toString(node1));
        node2 = swap(node1);
        System.out.println("After "+toString(node2));
    }
}
