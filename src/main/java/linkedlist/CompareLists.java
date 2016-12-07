package linkedlist;

/**
 * Created by pshrestha on 12/7/2016.
 */
public class CompareLists {

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

        int test = compareLists(A, C);
        System.out.println("test: " + test);
    }

    public static int compareLists(Node headA, Node headB){

        Node currentNodeA = headA;
        Node currentNodeB = headB;

        while (currentNodeA != null)
        {
            if(currentNodeB == null || currentNodeA.data != currentNodeB.data){
                return 0;
            }
            currentNodeA = currentNodeA.next;
            currentNodeB = currentNodeB.next;
        }
        if(currentNodeB != null){
            return 0;
        }

        return 1;
    }

    static class Node {
        int data;
        Node next;
        Node(){}
        Node(int d)  { data = d;  next = null; }
    }

}


