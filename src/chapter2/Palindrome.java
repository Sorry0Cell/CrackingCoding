package chapter2;

import java.util.Stack;

/**
 * check if a linkedList is a palindrome
 *
 * core0: reverse linkedList, clone and not clone, set a previous node ...
 * core1: since it's palindrome, it must be the same backwards and forwards, only compare half of the linkedList
 *        if we know the size of the linkedList
 * core2: iterative method, runner technique, with a stack, pushing the first half into the stack first compare
 *        second half then
 * core3: recursive, we need to know the node length advance, base case: middle element
 *        each call compares its head to returned_node, and then passes returned_node.next up the stack
 *
 * @author andy
 * @date Nov 21st
 *
 */


class WrapperRes{
    Node node;
    boolean res;

    WrapperRes(Node node, boolean res){
        this.node = node;
        this.res = res;
    }

}

public class Palindrome {

    /**
     * reverse the linkedList, and then compare half of the linkedList
     * @param linkedList
     * @return
     */
    public static boolean isPalindromeByCopy(LinkedList linkedList){
        LinkedList tempLinkedList = reverseLinkedList(linkedList, true);
        return LinkedListUtils.isEqual(linkedList, tempLinkedList);
    }

    public static boolean isPalindromeByStack(LinkedList linkedList){
        Node slowRunner = linkedList.head;
        Node fastRunner = linkedList.head;

        Stack<Integer> firstHalfStack = new Stack<>();
        while (fastRunner!=null && fastRunner.next!=null){
            firstHalfStack.push((int)slowRunner.data);
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        if(fastRunner!=null){
            slowRunner = slowRunner.next;
        }

        while (slowRunner!=null){
            if(firstHalfStack.pop() != slowRunner.data){
                return false;
            }
            slowRunner = slowRunner.next;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(LinkedList linkedList){
        int len = linkedList.head.length();
        WrapperRes resultWrapper = isPalindromeHelper(linkedList.head, len);
        return resultWrapper.res;
    }

    public static WrapperRes isPalindromeHelper(Node node, int length){
        // 递归三段式1: 临界条件
        if(length == 0){
            return new WrapperRes(node, true);
        } else if(length == 1){
            return new WrapperRes(node.next, true);
        }

        // 递归三段式2: 递归调用
        WrapperRes resultWrapper = isPalindromeHelper(node.next, length-2);

        // 递归三段式3: 处理逻辑
        if(!resultWrapper.res || resultWrapper.node.data != node.data){
            // return new WrapperRes(resultWrapper.node.next, false);
            resultWrapper.res = false;
        } else if(resultWrapper.node.data == node.data){
            // return new WrapperRes(resultWrapper.node.next, true);
            resultWrapper.res = true;
        }
        resultWrapper.node = resultWrapper.node.next;
        return resultWrapper;
        // return null
    }

    public static LinkedList reverseLinkedList(LinkedList linkedList, boolean isClone){
        Node tempNode;
        if(isClone){
            tempNode = reverseAndClone(linkedList.head);
        } else {
            tempNode = reverseNode(linkedList.head);
        }
        return new LinkedList(tempNode);
    }
    /**
     * change the original Node Sequence, head becomes tail, tail becomes head
     * @param node
     * @return
     */
    public static Node reverseNode(Node node){
        Node currentNode = node;
        Node previousNode = null;
//        while (currentNode.next != null){
//            Node tempNode = currentNode.next;
//            currentNode.next = previousNode;
//            previousNode = currentNode;
//            currentNode = tempNode;
//        }
//        currentNode.next = previousNode;
//        return currentNode;

        // another way
        while (currentNode!=null){
            Node tempNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = tempNode;
        }
        return previousNode;
    }

    /**
     * doesn't change the original Node Sequence, create a new one
     * @param node
     * @return
     */
    public static Node reverseAndClone(Node node){
        Node previousNode = null;
        while (node!=null){
            Node currentNode = new Node(node.data); // clone it
            currentNode.next = previousNode;
            previousNode = currentNode;
            node = node.next;
        }
        return previousNode;
    }

    public static void main(String[] args){
        Integer[] dataList = {1,2,1,1};
        LinkedList<Integer> intLinkedList = new LinkedList<>(dataList);
        LinkedListUtils.printLinkedList(intLinkedList.head, "original LinkedList: ");

        // test reverseLinkedList
        LinkedList reverseList = reverseLinkedList(intLinkedList, true);
        LinkedListUtils.printLinkedList(reverseList.head, "\nreverseLinkedList, isClone: ");

        System.out.println("\nis palindrome recursively: " + isPalindromeRecursive(intLinkedList));
    }
}
