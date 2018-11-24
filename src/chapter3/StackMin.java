package chapter3;

import java.util.EmptyStackException;

/**
 * How would you design a stack which, in addition to push and pop, has a function
 * min which returns the minimum element? Push, pop and min should all operate in
 * O(1) time.
 *
 * core: use an additional stack, which store current min
 *
 * @author andy
 * @date July 2nd
 */

public class StackMin extends MyStack<Integer> {
    MyStack<Integer> s2;

    public StackMin(){
        s2 = new MyStack<>();
    }

    public void push(int value){
        if(value <= min()){
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop(){
        int value = super.pop();
        if(value == min()){
            s2.pop();
        }
        return value;
    }

    public int min(){
        if(s2.isEmpty()){
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }

    public static void main(String[] args){
        StackMin stackMin = new StackMin();
        int[] tempArray = {5,3,1,4,-1,8,-2};
        for(int i: tempArray){
            stackMin.push(i);
        }
        try {
            while (true){
                //System.out.println(stackMin.min());
                System.out.println(stackMin.pop());
            }
        } catch (EmptyStackException e){
            //e.printStackTrace();
            System.err.println("The stack is empty");
        }
    }
}
