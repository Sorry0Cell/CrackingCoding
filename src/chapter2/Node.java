package chapter2;

/**
 * node class
 *
 * @author andy
 * @date Nov 19th
 */


public class Node<T> {
    T data;
    Node next = null;

    Node(){}

    Node(T data){
        this.data = data;
    }

    public boolean setNext(Node nextNode){
        this.next = nextNode;
        return true;
    }

    public int length(){
        int len = 0;
        Node node = this;
        while (node!=null){
            node = node.next;
            len++;
        }
        return len;
    }

}
