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

        // 范型, 注意, 类名, 除了在构造方法后不加<T>, 在其他地方都要加
        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop(){
        if(top == null){
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item){
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
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
}
