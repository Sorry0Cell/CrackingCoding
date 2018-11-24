package chapter2;


/**
 * Determine if 2 linkedLists are intersected, return the intersection node
 *
 * core: judge by memory address instead of value, and whether the last node is same; skip over
 *
 * @author andy
 * @date Nov 23rd
 */


public class Intersection {

    public static Node findIntersection(LinkedList linkedListA, LinkedList linkedListB){
        if(!isIntersected(linkedListA, linkedListB)){
            return null;
        }
        int lenA = linkedListA.length();
        int lenB = linkedListB.length();
        Node startNodeA = linkedListA.head;
        Node startNodeB = linkedListB.head;
        if(lenA<lenB){
            startNodeB = skipNode(startNodeB, lenB-lenA);
        }
        if(lenB<lenA){
            startNodeA = skipNode(startNodeA, lenA-lenB);
        }

        while (startNodeA.next!=startNodeB.next){
            startNodeA=startNodeA.next;
            startNodeB=startNodeB.next;
        }

        return startNodeA.next;
    }

    public static Node skipNode(Node node, int skipLen){
        for(int i=0; i< skipLen; i++){
            node = node.next;
        }
        return node;
    }

    public static boolean isIntersected(LinkedList linkedListA, LinkedList linkedListB){
        Node tailOfA = linkedListA.head;
        Node tailOfB = linkedListB.head;

        while (tailOfA.next != null){
            tailOfA = tailOfA.next;
        }
        while (tailOfB.next != null){
            tailOfB = tailOfB.next;
        }
        return tailOfA==tailOfB;
    }

    public static void main(String[] args){
        LinkedList linkedListA = LinkedListUtils.genLinkedList(4);
        LinkedList linkedListB = LinkedListUtils.genLinkedList(6);
        LinkedList linkedListC = LinkedListUtils.genLinkedList(3);

        LinkedListUtils.printLinkedList(linkedListA.head, "linkedListA: ");
        LinkedListUtils.printLinkedList(linkedListB.head, "\nlinkedListB: ");
        LinkedListUtils.printLinkedList(linkedListC.head, "\nlinkedListC: ");

        linkedListA = LinkedListUtils.connectLinkedList(linkedListA, linkedListC);
        linkedListB = LinkedListUtils.connectLinkedList(linkedListB, linkedListC);
        LinkedListUtils.printLinkedList(linkedListA.head, "\nnew linkedListA: ");
        LinkedListUtils.printLinkedList(linkedListB.head, "\nnew linkedListB: ");

        Node interSection = findIntersection(linkedListA, linkedListB);
        System.out.println("\nintersection node: " + interSection.data);
    }
}
