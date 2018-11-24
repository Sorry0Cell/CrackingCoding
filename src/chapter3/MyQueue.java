package chapter3;

import java.util.NoSuchElementException;

/**
 *
 * @param <T>
 * Queue, commonly used in tree, graph bread-first-search
 * Attention: push and pop are operated in different end
 */

public class MyQueue<T> {

    // Nov 24th
    // 静态内部类（嵌套类），不需要外部类引用，即可创建内部类对象，
    private static class QueueNode<T>{
        private T data;
        private QueueNode<T> next;

        // 范型, 注意, 类名, 除了在构造方法后不加<T>, 在其他地方都要加
        public QueueNode(T data){
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;
    private int size;

    public void add(T item){
        QueueNode<T> t = new QueueNode<T>(item);
        if(last != null){
            last.next = t;
        }
        last = t;
        if(first == null){
            first = last;
        }
        size++;
    }

    public T remove(){
        if(first == null){
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;
        if(first == null){
            last = null;
        }
        size--;
        return data;
    }

    public T peek(){
        if(first == null){
            throw  new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int getSize(){return size;}
}
