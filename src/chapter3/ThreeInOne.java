package chapter3;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Describe how you could use a single array to implement three stacks.
 *
 * @author andy
 * @date July 2nd
 */

public class ThreeInOne {

    private static class FullStackException extends Exception{
        public FullStackException(){}
        public FullStackException(String msg){
            super(msg);
        }
    }

    private int numberOfStacks = 3;
    private int stackCapacity;      //每个栈的大小
    private int[] values;           //即题目中的 a single array
    private int[] sizes;            //用来记录对应栈中有几个元素

    public ThreeInOne(int stackSize){
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int item) throws FullStackException{
        if(isFull(stackNum)){
            throw new FullStackException();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = item;
    }

    /**
     *
     * @param stackNum
     * @return pop 的值
     * 首先, 要判断 stackNum 对应的栈是否为空
     * 其次, 找到 stackNum 对应的栈 top index
     * 最后, 返回 values中 top index 处对应的item值,
     *      并把top index 处的值赋为0, 同时 stackNum 对应的栈 size 要减一
     */
    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int item = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return item;
    }

    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }

    public int indexOfTop(int stackNum){
        int offset  = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size -1;
    }
}
