package chapter3;

import java.util.EmptyStackException;

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

    /**
     *
     * @param stackNum
     * @param item
     * @throws FullStackException
     */
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
     * @return
     * first, whether the No.stackNum stack is empty
     * second, find the top_index of the No.stackNum stack
     * last, return values[top_index], and values[top_index]=0, sizes[stackNum]--
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
