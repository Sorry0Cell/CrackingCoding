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
}
