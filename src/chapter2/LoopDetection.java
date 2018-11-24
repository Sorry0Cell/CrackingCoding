package chapter2;

/**
 * Given a circular linkedList, return the startNode of the loop
 * core: runner technique
 *
 * @author andy
 * @date Nov 23rd
 */
public class LoopDetection {

    public static Node detectLoop(Node node){
        Node slowRunner = node.next;
        Node fastRunner = node.next.next;

        while (slowRunner != fastRunner){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }
        slowRunner = node;
        while (slowRunner != fastRunner){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }
        return fastRunner;
    }

    public static void showLoop(Node node){
        System.out.println("\nshow circle: " );
        Node testNode = node;
        int count = 0;
        while (testNode != null){
            System.out.println(testNode.data);
            if(count ++ == 15){
                break;
            }
            testNode = testNode.next;
        }
    }
    public static void main(String[] args){
        LinkedList linkedList = LinkedListUtils.genLinkedList(8);
        LinkedListUtils.printLinkedList(linkedList.head, "before insert: ");

        Node tempNode = new Node(999);
        linkedList.insert(tempNode, 7);
        LinkedListUtils.printLinkedList(linkedList.head, "\nafter insert: ");

        Node tailNode = tempNode;
        while (tailNode.next!=null){
            tailNode = tailNode.next;
        }
        // 造一个环
        tailNode.next = tempNode;
        // showLoop(linkedList.head);

        Node loopBegin = detectLoop(linkedList.head);
        System.out.println("\nloop start: " + loopBegin.data);
    }
}
