package chapter3;

import java.util.NoSuchElementException;

/**
 *
 * @param <T>
 * Queue, 常用于图、树的广度优先遍历
 * 注意: 入队列和出队列是在不同的两个方向, 一个在头, 一个在尾
 */
public class MyQueue<T> {

    private static class QueueNode<T>{
        private T data;
        private QueueNode<T> next;

        // 范性, 注意, 类名, 除了在构造方法后不加<T>, 在其他地方都要加
        public QueueNode(T data){
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item){
        QueueNode<T> t = new QueueNode<T>(item);
        if(last != null){
            last.next = t;
        }
        last = t;
        if(first == null){
            first = last;
        }
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
}
