package hackerrank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by pshrestha on 11/15/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
public class HackerRankPractice {

    public int compareLists(Node headA, Node headB){

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

    Node mergeLists(Node headA, Node headB) {
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

    Node mergeListsRecursive(Node headA, Node headB) {
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
        //Node temp = null;

        if(currentNodeA.data < currentNodeB.data){
            currentNodeA.next = mergeLists(currentNodeA.next, currentNodeB);
            //currentNodeA = currentNodeA.next;
        } else if (currentNodeA.data > currentNodeB.data){
            Node temp  = currentNodeB;
            currentNodeB = currentNodeB.next;
            temp.next = currentNodeA;
            currentNodeA = temp;
            currentNodeA.next = mergeLists(currentNodeA.next, currentNodeB);
        }

        return currentNodeA;
    }

    @Test
    public void testCompareList(){
        Node A = new Node(1);
        Node B = new Node(5);
        Node C = new Node(7);
        Node D = new Node(8);
        A.next = B;
        B.next = C;
        C.next = D;

        Node E = new Node(1);
        Node F = new Node(5);
        Node G = new Node(7);
        Node H = new Node(8);
        E.next = F;
        F.next = G;
        G.next = H;

        int test = compareLists(A, E);
        System.out.println("test: " + test);
    }

    @Test
    public void testMergeList(){
        Node A = new Node(1);
        Node B = new Node(5);
        Node C = new Node(7);
        Node D = new Node(8);
        A.next = B;
        B.next = C;
        C.next = D;

        Node E = new Node(3);
        Node F = new Node(7);
        Node G = new Node(10);
        Node H = null;
        E.next = F;
        F.next = G;

//        Node mergedNode = mergeLists(A, H);
        Node mergedNode = mergeListsRecursive(A, E);
        Node currentNode = mergedNode;
        while(currentNode != null){
            System.out.println("Node1: " + currentNode.data);
            currentNode = currentNode.next;
        }
    }


    class Node {
        int data;
        Node next;
        Node(){}
        Node(int d)  { data = d;  next = null; }
    }

    int getNode(Node head,int n) {
//        Node temp = head;

        while(head != null ){
            Node temp = head;
            for(int i = 0; i<n; i++){
                if(temp != null) {
                    temp = temp.next;
                }
            }
//            if(temp == null){
//                break;
//            }
            if(temp != null && temp.next == null){
                return head.data;
            }
            head = head.next;
        }
        return 0;

    }

    int getNode2(Node head,int positionFromTail)
    {
        int index = 0;
        Node current = head;
        Node result = head;
        while(current!=null)
        {
            current=current.next;
            if (index++>positionFromTail)
            {
                result=result.next;
            }
        }
        return result.data;
    }

    @Test
    public void testGetNode(){
        Node A = new Node(1);
        Node B = new Node(5);
        Node C = new Node(7);
        Node D = new Node(8);
        A.next = B;
        B.next = C;
        C.next = D;

        int nodeValue = getNode2(A, 3);
        System.out.println("nodeValue: " + nodeValue);

    }

    Node removeDuplicates(Node head) {
        Node temp = head;
        while(temp != null && temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return temp;
    }

    Node removeDuplicates2(Node head){

        Node temp = head;
        while(temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    @Test
    public void testRemoveDuplicates(){
        Node A = new Node(1);
        Node B = new Node(1);
        Node C = new Node(1);
        Node D = new Node(1);
        Node E = new Node(1);
        Node F = new Node(1);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;

        Node node = removeDuplicates(A);
        while(node != null){
            System.out.println("node: " + node.data);
            node = node.next;
        }
    }



}
