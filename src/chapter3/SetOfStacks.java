package chapter3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Random;

/**
 * composed of several stacks, and should create a new one if the previous one exceed its threshold
 * core: ArrayList
 *
 * @author andy
 * @date Nov 24th
 */

public class SetOfStacks<T> {

    private ArrayList<MyStack<T>> stackList;
    private int stackNum;
    private int stackThresh;

    public SetOfStacks(int thresh){
        stackList = new ArrayList<>();
        stackThresh = thresh;
    }

    public void push(T data){
        MyStack<T> lastStack = getLastStack();
        if(lastStack==null || lastStack.getSize()==stackThresh){
            addStack(data);
        } else {
            lastStack.push(data);
        }
    }

    public void addStack(T data){
        MyStack<T> lastStack = new MyStack<>();
        lastStack.push(data);
        stackList.add(lastStack);
        stackNum++;
    }

    public MyStack getLastStack(){
        if(stackNum==0) return null;
        return stackList.get(stackNum-1);
    }

    public T pop()throws EmptyStackException{
        MyStack<T> lastStack = getLastStack();
        if(lastStack==null){
            throw new EmptyStackException();
        }
        T data = lastStack.pop();
        if(lastStack.getSize() == 0){
            stackList.remove(stackNum-1);
            stackNum--;
        }
        return data;
    }

    public T peek() throws EmptyStackException{
        if(stackNum==0){
            throw new EmptyStackException();
        }
        MyStack<T> lastStack = stackList.get(stackNum-1);
        T data = lastStack.peek();
        return data;
    }

    public static void main(String[] args){
        int[] tempArray = new int[100];
        Random random = new Random();
        SetOfStacks stackSet = new SetOfStacks(10);
        for(int i=0; i<tempArray.length; i++){
            tempArray[i] = random.nextInt(100);
            stackSet.push(tempArray[i]);
        }

        for(int i=1; i<tempArray.length+1; i++){
            stackSet.pop();
            if(i%10 == 0){
                System.out.println("\nCurrent stackSet size: " + stackSet.stackNum);
            }
        }
    }
}
