package chapter2;

/***
 * LinkedList implementation
 *
 * @author andy
 * @date Nov 19th
 */

public class LinkedList<T> {

    public Node head;

    public LinkedList(){
        head = null;
    }

    public LinkedList(T data){
        head = new Node(data);
    }

    public LinkedList(Node node){
        head = node;
    }

    public boolean setHead(T data){
        head.data = data;
        return true;
    }

    public Node append(int data){
        Node node = head;
        while (node.next != null){
            node = node.next;
        }
        node.next = new Node(data);
        return head;
    }

    public Node delete(T data){
        Node node = head;
        if(node.data == data){
            head = head.next;
        } else {
            while (node.next.data != data){
                node = node.next;
            }
            node.next = node.next.next;
        }
        return head;
    }

    public Node insert(T data, int pos){
        if(pos == 0){
            Node node = new Node(data);
            node.next = head;
            head = node;
        } else {
            Node node = head;
            for(int i=0; i<pos-1; i++){
                node = node.next;
            }
            Node tempNode = new Node(data);
            if(node.next != null){
                tempNode.next = node.next;
            }
            node.next = tempNode;
        }
        return head;
    }

    public Node insert(Node middleNode, int pos){
        if(pos == 0){

            middleNode.next = head;
            head = middleNode;
        } else {
            Node node = head;
            for(int i=0; i<pos-1; i++){
                node = node.next;
            }
            if(node.next != null){
                middleNode.next = node.next;
            }
            node.next = middleNode;
        }
        return head;
    }
}
