package chapter3;

import static java.lang.System.*;

public class DisorderArray {

    public int[] numArray = {1,2,3};


    public static int[] staticDisrupt(int[] tempArray){

        int size = tempArray.length;
        int temp = tempArray[0];
        tempArray[0] = tempArray[size-1];
        tempArray[size-1] = temp;
        return tempArray;

    }

    private void disrupt(){

        int temp = numArray[0];
        numArray[0] = numArray[2];
        numArray[2] = temp;
    }


    public static void main(String[] args){
        DisorderArray disorderArray = new DisorderArray();

        for(int temp: disorderArray.numArray){
            //out.println(temp);
        }

        disorderArray.disrupt();
        out.println();


        for(int temp: disorderArray.numArray){
             //out.println(temp);
        }

        int[] tempArray = {4,5,6,7,8};
        for(int temp: DisorderArray.staticDisrupt(tempArray)){
            out.println(temp);
        }
        for(int temp: tempArray){
            out.println(temp);
        }
    }
}
