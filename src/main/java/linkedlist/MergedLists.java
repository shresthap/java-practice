package linkedlist;

/**
 * Created by pshrestha on 12/7/2016.
 */
public class MergedLists {

    public static void main(String[] args){
        Node A = new Node(1);
        Node B = new Node(5);
        Node C = new Node(7);
        Node D = new Node(8);
        A.next = B;
        B.next = C;
        C.next = D;

        Node E = new Node(3);
        Node F = new Node(4);
        Node G = new Node(10);
        Node H = null;
        E.next = F;
        F.next = G;

        //int test = compareLists(A, C);
        Node mergedNode = MergeLists(A, H);
        Node currentNode = mergedNode;
        while(currentNode != null){
            System.out.println("Node1: " + currentNode.data);
            currentNode = currentNode.next;
        }
        //System.out.println("test: " + test);
    }


    static Node MergeLists(Node headA, Node headB) {
        Node currentNodeA = headA;
        Node currentNodeB = headB;
        if(currentNodeA == null && currentNodeB == null){
            return null;
        }
        if(currentNodeA == null){
            return currentNodeB;
        }
        if(currentNodeB == null){
            return currentNodeA;
        }
        Node temp = null;

        if(currentNodeA.data < currentNodeB.data){
            temp = currentNodeA;
            currentNodeA = currentNodeA.next;
        } else {
            temp = currentNodeB;
            currentNodeB = currentNodeB.next;
        }
        Node head = temp;
        while(currentNodeA != null){
            if(currentNodeB != null) {
                if (currentNodeA.data < currentNodeB.data) {
                    temp.next = currentNodeA;
                    currentNodeA = currentNodeA.next;
                    temp = temp.next;
                } else {
                    temp.next = currentNodeB;
                    currentNodeB = currentNodeB.next;
                    temp = temp.next;
                }
            } else {
                temp.next = currentNodeA;
                break;
            }
        }
        if(currentNodeB != null) {
            temp.next = currentNodeB;
        }

        return head;
    }

    static class Node {
        int data;
        Node next;
        Node(){}
        Node(int d)  { data = d;  next = null; }
    }

}
