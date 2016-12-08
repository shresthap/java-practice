package linkedlist;

import java.util.Hashtable;

/**
 * Created by pshrestha on 12/8/2016.
 */
public class RemoveDuplicate {

    public static void main(String[] args){
        Node A = new Node(1);
        Node B = new Node(2);
        Node C = new Node(3);
        Node D = new Node(3);
        Node E = new Node(5);
        Node F = new Node(6);
        Node G = new Node(5);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;
        F.next = G;
        G.next = null;

        Node node = deleteDuplicates(A);
        while(node != null){
            System.out.println("Node: " + node.data);
            node = node.next;
        }
    }

    // remove duplicates from unsorted linkedlist
    public static Node deleteDuplicates(Node head){
        Hashtable table = new Hashtable();
        Node previous = null;
        while (head != null){
            if(table.containsKey(head.data)) {
                head.next = previous.next;
            }
            else {
                table.put(head.data, true);
                previous = head;
            }
            head = head.next;
        }

        return head;
    }


//    private static class Node {
//        // reference to the next node in the chain, or null if there isn't one.
//        Node next;
//        // data carried by this node. could be of any type you need.
//        Object data;
//
//        // Node constructor
//        public Node(Object dataValue) {
//            this.next = null;
//            this.data = dataValue;
//        }
//    }

    static class Node {
        int data;
        Node next;
        Node(){}
        Node(int d)  { data = d;  next = null; }
    }
}
