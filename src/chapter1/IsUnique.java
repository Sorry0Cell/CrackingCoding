package chapter1;

import java.util.Arrays;

/***
 * determine whether the characters in a string are unique or not
 *
 * 牢记：在 java 中, 单引号和双引号是有区别的，前者用于字符(char), 后者用于字符串(String)
 * 注意理解 java 中 char 的本质, char是两个字节, 0~65535, 可以直接用数字表示
 *
 * @author andy
 * @date Nov 8th
 */

public class IsUnique {

    private String str;
    private int strLen;

    public IsUnique(String str){
        this.str = str;
        this.strLen = str.length();
    }

    public boolean isUniqueChars(){
        if(strLen > 128){
            return false;
        }
        boolean[] flagArray = new boolean[128];

        for(int i=0; i<strLen; i++){
            int tempChar = str.charAt(i);
            // char tempChar = str.charAt(i);   //定义成int 或 char 都可以
            // System.out.println(tempChar);
            if (flagArray[tempChar]){
                return false;
            }
            else {
                flagArray[tempChar] = true;
            }
        }
        return true;
    }

    /**
     * 通过比特位来进行判断，节省空间, 一个int是4个字节, 32位
     * @return
     */
    public boolean isUniqueByBit(){
        int[] flagArray = new int[4];

        for(int i=0; i<strLen; i++){
            int tempIndex = str.charAt(i);
            int arrayIndex = tempIndex / 32;
            int shiftNum = tempIndex % 32;

            if ((flagArray[arrayIndex] & (1 << shiftNum)) > 0){
                System.out.println(String.format("flagArray[%d]: %d", arrayIndex, flagArray[arrayIndex]));
                return false;
            }
            flagArray[arrayIndex] |= (1 << shiftNum);
        }
        return true;
    }

    public String sortStr(){
        System.out.println(String.format("str before sort: %s", str));
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        System.out.println(String.format("str after sort: %s", String.valueOf(charArray)));
        return String.valueOf(charArray);
    }


    public static void main(String[] args){
        IsUnique testStr = new IsUnique("AndyWonder");
        /**  方法1 */
        boolean result1 = testStr.isUniqueByBit();
        System.out.println(result1);
        /** 方法2 */
        boolean result2 = testStr.isUniqueChars();
        System.out.println(result2);
        /** 方法3 */
        boolean result3 = true;
        String sortStr = testStr.sortStr();
        for(int i=0; i<sortStr.length()-1; i++){
            if(sortStr.charAt(i) == sortStr.charAt(i+1)){
                result3 = false;
                break;
            }
        }
        System.out.println(result3);
    }

}

