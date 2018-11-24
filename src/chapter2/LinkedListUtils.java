package chapter2;

import java.util.Random;

/**
 * utils class implementing LinkedList
 *
 * @author andy
 * @email Nov 19th
 */
public class LinkedListUtils {

    private static int RANDOM_BOUND = 10;

    public static LinkedList genLinkedList(int size){

        Random random = new Random();

        LinkedList<Integer> randomLinkedList = new LinkedList<>(random.nextInt(RANDOM_BOUND));
        for(int i=0; i<size-1; i++) {
            int tempData = random.nextInt(RANDOM_BOUND);
            randomLinkedList.append(tempData);
        }
        return randomLinkedList;
    }

    /**
     * print linkedList data
     * @param node
     * @param str
     */
    public static void printLinkedList(Node node, String str){
        System.out.println(str);
        String dataType = "";
        while (node!=null){
            if(node.data.getClass().getName() == "java.lang.Character"){
                dataType = "%c ";
            }
            if(node.data.getClass().getName() == "java.lang.Integer"){
                dataType = "%d ";
            }
            System.out.print(String.format(dataType, node.data));
            node = node.next;
        }
    }

    /**
     * compare if 2 linkedLists have the same data
     * @param linkedListA
     * @param linkedListB
     * @return
     */
    public static boolean isEqual(LinkedList linkedListA, LinkedList linkedListB){
        Node node1 = linkedListA.head;
        Node node2 = linkedListB.head;
        while (node1!=null && node2!=null){
            if(node1.data != node2.data){
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1==null && node2==null;
    }

    public static LinkedList connectLinkedList(LinkedList linkedListA, LinkedList linkedListB){
        Node tailOfA = linkedListA.head;
        while (tailOfA.next!=null){
            tailOfA = tailOfA.next;
        }
        tailOfA.next = linkedListB.head;
        return linkedListA;
    }
}
