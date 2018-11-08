package chapter1;

/**
 * given 2 strings, decide if one of them is the permutation of the other
 *
 * 不用hashtable也能完成，
 *
 * @author andy
 * @date Nov 8th
 */

import java.util.HashMap;

public class CheckPerm {
    String str1;
    String str2;

    public CheckPerm(String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
    }
    /** 判断两个字符串里面的字符是否相等即可 */
    public boolean isPermutaion(){
        HashMap<Character, Integer> table1 = fillTable(str1);
        HashMap<Character, Integer> table2 = fillTable(str2);

        for(Character tempKey: table1.keySet()){
            if(table1.get(tempKey) != table2.get(tempKey)){
                return false;
            }
        }
        return true;
    }

    public static HashMap fillTable(String tempStr){
        HashMap<Character, Integer> table = new HashMap<>();
        for(int i=0; i<tempStr.length(); i++){
            if(table.get(tempStr.charAt(i)) == null){
                table.put(tempStr.charAt(i), 1);
            } else {
                table.put(tempStr.charAt(i), table.get(tempStr.charAt(i))+1);
            }
        }
        return table;
    }

    public static void main(String[] args){
        CheckPerm cp = new CheckPerm("Andy", "andy ");
        System.out.println(cp.isPermutaion());
    }
}
