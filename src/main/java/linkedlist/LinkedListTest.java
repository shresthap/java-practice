package linkedlist;

import java.util.Hashtable;

/**
 * Created by pshrestha on 12/5/2016.
 */
public class LinkedListTest {

    public static MyLinkedList myLinkedList;

    public static void main(String[] args){
        myLinkedList = new MyLinkedList();

        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");
        myLinkedList.add("4");
        myLinkedList.add("5");

        System.out.println("Print: MyLinkedList: \t\t" + myLinkedList);
        System.out.println(".size(): \t\t\t\t" + myLinkedList.size());
        System.out.println(".get(3): \t\t\t\t" + myLinkedList.get(3) + " (get element at index:3 - list starts from 0)");
        System.out.println(".remove(2): \t\t\t\t" + myLinkedList.remove(1) + " (element removed)");
        System.out.println("Print: MyLinkedList: \t\t" + myLinkedList);
        System.out.println(".get(3): \t\t\t\t" + myLinkedList.get(3) + " (get element at index:3 - list starts from 0)");
        System.out.println(".size(): \t\t\t\t" + myLinkedList.size());
        System.out.println("Print again: MyLinkedList: \t" + myLinkedList);
    }

    static class MyLinkedList {
        private int counter;
        private Node head;

        public MyLinkedList(){
        }

        public void add(Object data){

            // Initialize Node only incase of 1st element
            if(head == null){
               head = new Node(data);
                incrementCounter();
                return;
            }

            Node tempNode = new Node(data);
            Node currentNode = head;

            // Let's check for NPE before iterate over currentNode
            if(currentNode != null) {

                // starting at the head node, crawl to the end of the list and then add element after last node
                while (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }
                // the last node's "next" reference set to our new node
                currentNode.setNext(tempNode);
            }

            // increment the number of elements variable
            incrementCounter();
        }

        private int getCounter(){
            return counter;
        }

        private void incrementCounter(){
            counter++;
        }

        private void decrementCounter(){
            counter--;
        }

        // inserts the specified element at the specified position in this list
        public void add(Object data, int index){
            Node tempNode = new Node(data);
            Node currentNode = head;

            // Let's check for NPE before iterate over crunchifyCurrent
            if(currentNode != null){
                // crawl to the requested index or the last element in the list, whichever comes first
                for(int i = 0; i < index && currentNode.getNext() != null; i++){
                    currentNode = currentNode.getNext();
                }
            }
            tempNode.setNext(currentNode.getNext());
            currentNode.setNext(tempNode);

            incrementCounter();
        }

        // returns the element at the specified position in this list.
        public Object get(int index){

            // index must be 0 or higher
            if(index < 0){
                return null;
            }
//            if(index == 0){
//                return  head.getData();
//            }

            Node currentNode = null;
            if(head != null){
                currentNode = head;
                for(int i = 0 ; i < index; i++){
                    if(currentNode.getNext() == null){
                        return null;
                    }
                    currentNode = currentNode.getNext();
                }
                return currentNode.getData();
            }

            return currentNode;

        }

        // removes the element at the specified position in this list.
        public boolean remove(int index){

            // if the index is out of range, exit
            if(index < 0 || index > size()){
                return false;
            }

            if(index == 0){
                head = head.getNext();
                return true;
            }

            Node currentNode = head;

            if(head != null){
                for(int i = 0 ; i < index - 1; i++){
                    if(currentNode.getNext() == null){
                        return false;
                    }
                    currentNode = currentNode.getNext();
                }
                currentNode.setNext(currentNode.getNext().getNext());

                //decrement the number of elements variable
                decrementCounter();
                return true;
            }

            return false;
        }

        public String toString(){
            String output = "";

            if(head != null){
                Node currentNode = head;
                while (currentNode != null){
                    output += "[" + currentNode.getData().toString() + "]";
                    currentNode = currentNode.getNext();
                }
            }

            return output;
        }

        public int size(){
            return getCounter();
        }





    }

    private static class Node {
        // reference to the next node in the chain, or null if there isn't one.
        Node next;
        // data carried by this node. could be of any type you need.
        Object data;

        // Node constructor
        public Node(Object dataValue){
            this.next = null;
            this.data = dataValue;
        }

        // another Node constructor if we want to specify the node to point to.
        @SuppressWarnings("unused")
        public Node(Object dataValue, Node nextValue){
            next = nextValue;
            data = dataValue;
        }

        void appendToTail(int d){
            Node end = new Node(d);
            Node n = this;
            while(n.next != null) {
                n = n.next;
            }
            n.next = end;
        }

        Node deleteNode(Node head, int d){
            Node node = head;
            if(node.data.equals(d)){
                return head.next;
            }
            while(node.next != null){
                if(node.next.data.equals(d)){
                    node.next = node.next.next;
                    return head; // head didn't change
                }
                node = node.next;
            }
            return head;
        }

        public Object getData(){
            return data;
        }

        @SuppressWarnings("unused")
        public void setData(Object dataValue){
            data = dataValue;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node nextValue){
            next = nextValue;
        }
    }


}
