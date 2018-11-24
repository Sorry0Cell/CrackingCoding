package chapter2;

/**
 * partition: partition a linkedList around a value x, such that all elements less than x come before all nodes
 * greater than or equal to x, note that x may be not in the linkedList
 *
 * core1: move the current node if next node.data > x, else don't move current node, only change current.next
 * core2: create two additional linkedList, combine them
 *
 * @author andy
 * @date Nov 20th
 */
public class Partition {

    /**
     * change the original linkedList, change the head
     * @param head
     * @param x
     * @return
     */
    public static Node partitionLinkedList(Node head, int x){
        Node current = head;

        while (current.next != null){
            if((int)current.next.data < x){
                Node tempNode = current.next;
                current.next = current.next.next;
                tempNode.next = head;
                head = tempNode;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * still change the original linkedList, but in different way(the book)
     * @param node
     * @param x
     * @return
     */
    public static Node partitionLinkedList2(Node node, int x){
        Node nodeStart = node;
        Node nodeEnd = node;
        while (node != null){
            // 避免一开始的时候产生环, 陷入死循环
            Node next = node.next;
            if((int)node.data < x){
                node.next = nodeStart;
                nodeStart = node;
            } else {
                nodeEnd.next = node;
                nodeEnd = node;
            }
            node = next;
        }
        return nodeStart;
    }

    public static void main(String[] args){
        LinkedList randomLinkedList = LinkedListUtils.genLinkedList(9);

        Node head = randomLinkedList.head;
        LinkedListUtils.printLinkedList(head, "data before partition ...");

        head = partitionLinkedList2(head, 5);
        LinkedListUtils.printLinkedList(head, "\ndata after partition ...");

    }
}
