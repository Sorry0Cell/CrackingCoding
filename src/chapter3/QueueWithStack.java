package chapter3;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * implement a queue with stack
 * core: queue first in first out, stack last in first out
 *
 * @author andy
 * @date Nov 24th
 */

public class QueueWithStack<T> {

    private MyStack<T> stackIn;     // push
    private MyStack<T> stackOut;    // pop & peek

    public QueueWithStack(){
        this.stackIn = new MyStack<>();
        this.stackOut = new MyStack<>();

    }

    public void add(T data){
        stackIn.push(data);
    }

    public T remove() throws EmptyStackException{
        if(stackIn.isEmpty() && stackOut.isEmpty()){
            throw new EmptyStackException();
        } else if(!stackOut.isEmpty()){
            return stackOut.pop();
        } else {
            while (stackIn.getSize() != 1){
                stackOut.push(stackIn.pop());
            }
            return stackIn.pop();
        }
    }

    public T peek() throws NoSuchElementException {
        if(stackIn.isEmpty() && stackOut.isEmpty()){
            throw new NoSuchElementException();
        } else if(!stackOut.isEmpty()){
            return stackOut.peek();
        } else {
            while (stackIn.getSize() != 0){
                stackOut.push(stackIn.pop());
            }
            return stackOut.peek();
        }
    }

    public boolean isEmpty(){
        return stackIn.isEmpty() && stackOut.isEmpty();
    }


    public static void main(String[] args){
        QueueWithStack<Integer> queueWithStack = new QueueWithStack<>();
        int[] tempArray1 = {1,2,3,4,5,};
        for(int i: tempArray1){
            queueWithStack.add(i);
        }
        System.out.println("first remove one element: " + queueWithStack.remove());
        System.out.println();
        int[] tempArray2 = {6,7,8,9,10,11};
        for(int i: tempArray2){
            queueWithStack.add(i);
        }
        System.out.println("\nsecond remove one element: " + queueWithStack.remove());
        System.out.println();
    }
}
