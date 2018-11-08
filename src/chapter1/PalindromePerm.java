package chapter1;

/**
 * given a string, check if a string a palindrome permutation
 * 核心思想：出现奇数次数的字符顶多有一个
 *
 * 假定在给定的字符串中，只有 小写字母
 * @author andy
 * @date Nov 8th
 */

public class PalindromePerm {

    public static final int tableSize = 26;
    String str;
    int[] countTable;

    public PalindromePerm(String str){
        this.str = str;
        countTable = new int[tableSize];
    }

    public int[] buildTable(){
        for(int i=0; i<str.length(); i++){
            int tempIndex = str.charAt(i) - 'a';
            countTable[tempIndex] += 1;
        }
        return countTable;
    }

    public boolean isPalindrome(){
        boolean evenFlag = false;
        for(int i=0; i<countTable.length; i++){
            if((countTable[i] % 2) != 0){
                if(evenFlag){
                    return false;
                } else {
                    evenFlag = true;
                }
            }
        }
        return true;
    }

    /**
     * 第二种方法, 借助bit manipulation, 节省内存
     * @return
     */
    public boolean isPalindromeByBit(){
        int result = 0;

        for(int i=0; i<str.length(); i++){
            int tempIndex = 1 << (str.charAt(i) - 'a');
            result ^= tempIndex;
        }

        System.out.println(result);
        return (result & (result-1)) == 0;
    }

    /**
     * 第三种方法, 只用数一次, 数完即得到结果, 不用再去数
     * @return
     */
    public boolean isPalindromeCountOnce(){
        int countOdd = 0;
        int[] tempCache = new int[tableSize];

        for(int i=0; i<str.length(); i++){
            int tempIndex = str.charAt(i) - 'a';
            tempCache[tempIndex]++;
            if((tempCache[tempIndex] % 2) == 0){
                countOdd--;
            } else {
                countOdd++;
            }
        }
        System.out.println(countOdd);
        return countOdd<=1;
    }


    public static void main(String[] args){
        PalindromePerm palPerm = new PalindromePerm("tactcoa");
        palPerm.buildTable();
        System.out.println(palPerm.isPalindrome());
        // 通过第二种方式进行判断, bit manipulation
        System.out.println(palPerm.isPalindromeByBit());
        // 通过第三种方式进行判断，扫一遍即能得到结果
        System.out.println(palPerm.isPalindromeCountOnce());
    }
}
