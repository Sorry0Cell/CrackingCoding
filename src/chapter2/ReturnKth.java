package chapter2;

/**
 * return the kth to last element in a linked list
 *
 * core: 递归、非递归方法
 *
 * @author andy
 * @date Nov 19th
 */


class WrapperInt{
    int index = 0;
}

public class ReturnKth {

    // 用来服务 recursiveNthToLast2方法
    private static int POS = 0;

    LinkedList linkedList;

    public ReturnKth(LinkedList linkedList){
        this.linkedList = linkedList;
    }

    public int getListSize(){
        Node node = linkedList.head;
        int size = 0;
        while (node != null){
            node = node.next;
            size++;
        }
        return size;
    }

    public void display(){
        Node node = linkedList.head;
        while (node!=null){
            System.out.print(String.format("%d ",node.data));
            node = node.next;
        }
    }

    public Node nthToLast(int k) {
        Node runner1 = linkedList.head;
        Node runner2 = linkedList.head;

        for (int i = 0; i < k; i++) {
            runner1 = runner1.next;
        }

        while (runner1 != null) {
            runner1 = runner1.next;
            runner2 = runner2.next;
        }
        return runner2;
    }

    /**
     * 思路：要想返回倒数第k个, 得先返回倒数第k-1个, 然后倒数第k-2个, ...
     *       临界条件, 返回倒数第1个
     * @param node
     * @param k
     * @return
     */
    public int recursiveNthToLast(Node node, int k){
        // 递归三段式1, 临界条件
        if(node == null){
            System.out.println("\ncoming to the last element");
            return 0;
        }
        // 递归三段式2, 递归调用
        int index = recursiveNthToLast(node.next, k) + 1;

        // 递归三段式3, 处理逻辑
        if(index == k){
            System.out.println(String.format("\nthe %dth to last element is %d", k, node.data));
        }
        return index;
    }

    // 借助静态变量, 使得所有的递归栈都能知道当前在倒数第几个位置
    public Node recursiveNthToLast2(Node node, int k){
        if(node == null){
            return null;
        }
        Node tempNode = recursiveNthToLast2(node.next, k);
        POS = POS + 1;
        if(POS == k){
            // 除非在这个位置, 否则返回的全是null(画张图)
            return node;
        }
        return tempNode;
    }

    // we need to update both the node and counter in a way thar all levels
    // of the recursive stack will see
    public Node recursiveNthToLast(Node node, int k, WrapperInt wrapper){
        if(node == null){
            return null;
        }
        Node tempNode = recursiveNthToLast(node.next, k, wrapper);
        wrapper.index += 1;
        if(wrapper.index == k){
            System.out.println("\npos equals k");
            return node;
        }
        return tempNode;
    }

    public static void main(String[] args){
        LinkedList randomLinkedList = LinkedListUtils.genLinkedList(10);
        ReturnKth returnKth = new ReturnKth(randomLinkedList);

        returnKth.display();

         // 1. runner technique
//         Node thirdToLast  = returnKth.nthToLast(3);
//         System.out.println(String.format("\nThe 3rd to last element is: %d", thirdToLast.data));

        // 2. recursive method, 无返回Node
        returnKth.recursiveNthToLast(randomLinkedList.head, 4);

         // 3. 借助wrapper, 有返回Node
//         Wrapper wrapper = new Wrapper();
//         Node result = returnKth.recursiveNthToLast(randomLinkedList.head, 4, wrapper);
//         System.out.println(result.data);


        // 4. 借助静态变量, 有返回Node
//        Node result = returnKth.recursiveNthToLast2(randomLinkedList.head, 4);
//        System.out.println(String.format("\nThe 4th to last element is: %d", result.data));

    }
}

