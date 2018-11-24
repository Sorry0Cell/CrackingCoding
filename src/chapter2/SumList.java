package chapter2;


/**
 * you have 2 numbers represented by linkedList, where each node contains a single digit, the
 * digits are stored in reverse order, write a function to add the two numbers and return the
 * sum as linkedList
 * e.g 7->1->6(617) + 5->9->2(295), the result is 2->1->9(912)
 *
 * Follow up: what if the digits are stored in forward order
 * e.g 6->1->7(617) + 2->9->5(295), the result is 9->1->2(912)
 *
 * core: recursive; padding
 *
 * @author andy
 * @date Nov 21st
 */

class WrapperNode{
    Node node;
    int carry;

    WrapperNode (){}
    WrapperNode(Node node, int carry){
        this.node = node;
        this.carry = carry;
    }
}

public class SumList {

    /**
     * non recursive implementation reverse
     * @param numNode1
     * @param numNode2
     * @return
     */
    public static Node reverseAdd(Node numNode1, Node numNode2){
        Node head = null;
        Node tail = null;
        int carry = 0;
        int digitSum;
        while (numNode1!=null || numNode2!=null){
            if(numNode1!=null && numNode2!=null){
                digitSum = (int)numNode1.data + (int)numNode2.data + carry;
                numNode1 = numNode1.next;
                numNode2 = numNode2.next;
            } else if(numNode1 == null){
                digitSum = (int)numNode2.data + carry;
                numNode2 = numNode2.next;
            } else {
                digitSum = (int)numNode1.data + carry;
                numNode1 = numNode1.next;
            }
            int digitNum = digitSum % 10;
            carry = digitSum / 10;
            Node<Integer> digitNode = new Node<>(digitNum);
            if(head == null){
                head = digitNode;
                tail = head;
            } else {
                tail.next = digitNode;
                tail = digitNode;
            }
        }
        return head;
    }

    /**
     * recursive implementation reverse
     * @param numNode1
     * @param numNode2
     * @param carry
     * @return
     */
    public static Node reverseAdd(Node numNode1, Node numNode2, int carry){
        // 递归三段式1: 临界条件
        if(numNode1==null && numNode2==null && carry==0){
            return null;
        }
        // 递归三段式2: 处理逻辑
        Node resultNode = new Node();
        int value = carry;
        if(numNode1 != null){
            value += (int)numNode1.data;
        }
        if(numNode2 != null){
            value += (int)numNode2.data;
        }
        resultNode.data = value % 10;

        // 递归三段式3: 递归调用
        if(numNode1 != null || numNode2 != null){
            Node nextNode = reverseAdd(numNode1==null? null:numNode1.next,
                    numNode2==null? null:numNode2.next,value / 10);
            resultNode.setNext(nextNode);
        }
        return resultNode;
    }

    /**
     * forward entry
     *
     * @param numNode1
     * @param numNode2
     * @return
     */
    public static Node forwardAdd(Node numNode1, Node numNode2){
        int len1 = numNode1.length();
        int len2 = numNode2.length();

        // padding first
        if(len1 < len2){
            numNode1 = padNode(numNode1, len2-len1);
        }
        if(len2 < len1){
            numNode2 = padNode(numNode2, len1-len2);
        }

        WrapperNode wrapper = forwardAddHelper(numNode1, numNode2);

        // 这里还要对wrapper进行判断, check carry
        if(wrapper.carry != 0){
            Node tempNode = new Node(wrapper.carry);
            tempNode.setNext(wrapper.node);
            return tempNode;
        }
        return wrapper.node;
    }

    /**
     * recursive implementation forward
     * core: solve the child problem before solve current problem
     * we need to return the nextNode as well as the carry, we we need a wrapper class
     *
     * @param numNode1
     * @param numNode2
     * @return
     */
    public static WrapperNode forwardAddHelper(Node numNode1, Node numNode2){
        // 递归三段式1: 临界条件
        if(numNode1==null && numNode2==null){
            return null;
        }
        // 递归三段式2: 递归调用
        WrapperNode wrapperNode = forwardAddHelper(numNode1.next, numNode2.next);

        // 递归三段式3: 处理逻辑
        Node tempNode;
        int carry;
        int value = (int)numNode1.data + (int)numNode2.data;
        if(wrapperNode == null){
            tempNode = new Node(value % 10);
            carry = value / 10;
        } else {
            value += wrapperNode.carry;
            tempNode = new Node(value % 10);
            carry = value / 10;
            tempNode.setNext(wrapperNode.node);
        }

        WrapperNode resultWrapper = new WrapperNode(tempNode, carry);
        return resultWrapper;
    }

    public static Node padNode(Node node, int padNum){
        Node head = node;
        for(int i=0; i<padNum; i++){
            Node tempNode = new Node(0);
            tempNode.next = head;
            head = tempNode;
        }
        return head;
    }

    public static void main(String[] args){
        LinkedList numLinkedList1 = LinkedListUtils.genLinkedList(3);
        LinkedList numLinkedList2 = LinkedListUtils.genLinkedList(3);

        LinkedListUtils.printLinkedList(numLinkedList1.head, "num1 in reverse order ");
        LinkedListUtils.printLinkedList(numLinkedList2.head, "\nnum2 in reverse order ");

        // non recursive method reverse
//        Node addSum = reverseAdd(numLinkedList1.head, numLinkedList2.head);
//        LinkedListUtils.printLinkedList(addSum, "\nadd in reverse ");

        // recursive method reverse
//        Node addSum = reverseAdd(numLinkedList1.head, numLinkedList2.head, 0);
//        LinkedListUtils.printLinkedList(addSum, "\nadd in reverse(recursive) ");

        // recursive method forward
        Node addSum = forwardAdd(numLinkedList1.head, numLinkedList2.head);
        LinkedListUtils.printLinkedList(addSum, "\nadd in forward(recursive) ");

    }
}
