package chapter3;

import java.util.EmptyStackException;

/**
 * implement a stack with queue
 * core: stack first in first out, queue last in first out
 *
 * @author andy
 * @date Nov 24th
 */

public class StackWithQueue<T> {

    private MyQueue<T> queueA;
    private MyQueue<T> queueB;

    public StackWithQueue(){
        this.queueA = new MyQueue<>();
        this.queueB = new MyQueue<>();
    }

    public void push(T data){
        if(queueA.isEmpty()){
            queueB.add(data);
        } else if(queueB.isEmpty()){
            queueA.add(data);
        }
    }

    public T pop() throws EmptyStackException{
        if(queueA.isEmpty() && queueB.isEmpty()){
            throw new EmptyStackException();
        } else if(queueA.isEmpty()){
            while (queueB.getSize() != 1){
                queueA.add(queueB.remove());
            }
            return queueB.remove();
        } else {
            while (queueA.getSize() != 1){
                queueB.add(queueA.remove());
            }
            return queueA.remove();
        }
    }

    public T peek(){
        if(queueA.isEmpty() && queueB.isEmpty()){
            throw new EmptyStackException();
        } else if(queueA.isEmpty()){
            while (queueB.getSize() != 0){
                queueA.add(queueB.remove());
            }
            return queueA.peek();
        } else {
            while (queueA.getSize() != 0){
                queueB.add(queueA.remove());
            }
            return queueB.peek();
        }
    }

    public boolean isEmpty(){
        return queueA.isEmpty() && queueB.isEmpty();
    }

    public static void main(String[] args){
        StackWithQueue<Integer> stackWithQueue = new StackWithQueue<>();
        int[] tempArray1 = {1,2,3,4,5,};
        for(int i: tempArray1){
            stackWithQueue.push(i);
        }
        System.out.println("first pop one element: " + stackWithQueue.pop());
        System.out.println();
        int[] tempArray2 = {6,7,8,9,10,11};
        for(int i: tempArray2){
            stackWithQueue.push(i);
        }
        System.out.println("\nsecond pop one element: " + stackWithQueue.pop());
        System.out.println();
    }
}
