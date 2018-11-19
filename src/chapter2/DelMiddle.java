package chapter2;

/**
 * delete the middle element in a linked list, you are not given access to the head or the tail, but only that node
 * e.g a->b->c->d->e, delete c, only give u the access to c, the linked list become a->b->d->e
 *
 * core: copy the data of next node to current node, and then delete the next one
 *
 * @author andy
 * @date Nov 19th
 */

public class DelMiddle {

    public static void main(String[] args){

        LinkedList linkedList = LinkedListUtils.genLinkedList(7);

        System.out.println("data before insert ...");
        Node node = linkedList.head;
        while (node!=null){
            System.out.print(String.format("%d ", node.data));
            node = node.next;
        }

        // 插入一个
        Node tempNode = new Node(777);
        linkedList.insert(tempNode, 3);
        System.out.println("\ndata after insert ...");
        node = linkedList.head;
        while (node!=null){
            System.out.print(String.format("%d ", node.data));
            node = node.next;
        }

        // 删除这个node
        tempNode.data = tempNode.next.data;
        tempNode.next = tempNode.next.next;
        System.out.println("\ndata after delete ...");
        node = linkedList.head;
        while (node!=null){
            System.out.print(String.format("%d ", node.data));
            node = node.next;
        }
    }
}
