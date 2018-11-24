package chapter3;

import java.util.EmptyStackException;

/**
 *
 * @param <T>
 * Stack, commonly used in stack, iterative algorithms
 * Attention: push and pop are operated in the same end
 */

public class MyStack<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        // 泛型, 注意, 类名, 除了在构造方法后不加<T>, 在其他地方都要加
        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;
    private int size;

    public T pop() throws EmptyStackException{
        if(top == null){
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public void push(T item){
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
        size++;
    }

    public T peek(){
        if(top == null){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int getSize(){return size;}
}
