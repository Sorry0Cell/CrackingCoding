package chapter1;

/**
 * check if 2 strings are one edit away
 * e.g pale, ple True; pale pala True; pale bae False
 *
 * @author andy
 * @date Nov 8th
 */

public class OneAway {

    String str1;
    String str2;

    public OneAway(String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
    }

    public boolean oneEditReplace(){
        boolean fountDifference = false;

        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) {
                if (fountDifference) {
                    return false;
                }
                fountDifference = true;
            }
        }
        return true;
    }

    public boolean oneEditInsert(){
        String shorterStr = str1.length() + 1 == str2.length()? str1: str2;
        String longerStr = str1.length() + 1 == str2.length()? str2: str1;
        int i=0, j = 0;
        while (i<shorterStr.length() && j<longerStr.length()){
            if(shorterStr.charAt(i) != longerStr.charAt(j)){
                if(i != j){
                    // 说明已经错过位置了, 即已经有过一次不相等了
                    return false;
                }
                j++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    /**
     * 把上述两个方法整合在一起
     *
     * 观察上面的两个方法, 发现较长的字符串的index总是向前加一; 如果两个字符串长度相等,
     * 遇到不等的情况, 两个字符串的index都要向前加一
     */
    public boolean oneEditAway(){
        String shorterStr = str1.length() < str2.length()? str1: str2;
        String longerStr  = str1.length() < str2.length()? str2: str1;

        int i=0, j=0;
        boolean foundDifference = false;
        while(i<shorterStr.length() && j < longerStr.length()){
            if (shorterStr.charAt(i) != longerStr.charAt(j)){
                if (foundDifference) return false;
                foundDifference = true;

                if(shorterStr.length() == longerStr.length()){
                    i++;
                }
            } else {
                i++;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args){

        OneAway oneAway = new OneAway("pale", "ple");
        System.out.println(oneAway.oneEditInsert());
    }
}
