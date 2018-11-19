package chapter2;

import java.util.HashSet;

/**
 * remove duplicate node in a LinkedList
 *
 * 思路1: 通过 HashSet 存储元素, 不断地做判断, O(n)
 * 思路2: 用两个指针, 一个指向当前node, 一个指向之后的node, O(n**2)
 *
 * @author andy
 * @date Nov 19th
 */

public class RemoveDups {
    private static int LINKED_LIST_SIZE = 15;

    public LinkedList randomLinkedList;

    /**
     * 借助HashSet来删除
     */
    public void delDupsBySet(){
        HashSet<Integer> set = new HashSet<>();
        Node previousNode = null;
        Node node = randomLinkedList.head;
        while (node!=null){
            if(set.contains(node.data)){
                previousNode.next = node.next;
            } else {
                set.add((Integer)node.data);
                previousNode = node;
            }
            node = node.next;
        }
    }

    /**
     * 实际是靠runner来删除
     */
    public void delDups(){
        Node current = randomLinkedList.head;
        Node runner;

        while (current != null){
            runner = current;
            while (runner.next != null){
                if(runner.next.data == current.data){
                    // 只删除下一个，而不移动runner
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }

    }

    public static void main(String[] args){
        RemoveDups removeDups = new RemoveDups();

        removeDups.randomLinkedList = LinkedListUtils.genLinkedList(LINKED_LIST_SIZE);
        removeDups.randomLinkedList.insert(8,8);
        removeDups.randomLinkedList.insert(8,8);

        System.out.println("before remove duplicate ...");
        Node node = removeDups.randomLinkedList.head;
        while (node!=null){
            System.out.print(String.format("%d ",node.data));
            node = node.next;
        }
        // removeDups.delDupsBySet();
        removeDups.delDups();

        System.out.println("\nafter remove duplicate ...");
        node = removeDups.randomLinkedList.head;
        while (node!=null){
            System.out.print(String.format("%d ",node.data));
            node = node.next;
        }
    }
}
