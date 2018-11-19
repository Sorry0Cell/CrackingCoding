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
}
