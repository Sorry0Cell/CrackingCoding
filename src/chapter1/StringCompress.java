package chapter1;

/**
 * String compression using the counts of repeated characters, e.g aabccc -> a2b1c3
 *
 * 记住 StringBuffer和StringBuilder 的区别, 前者支持多线程, 后者不支持
 * 记住 设计到字符串的拼接问题, 尽量不要用String
 *
 * @author andy
 * @date Nov 19th
 */

public class StringCompress {

    String originalStr;

    public StringCompress(String str){
        originalStr = str;
    }

    public String compress(){
        StringBuilder resultStr = new StringBuilder();
        int countConsecutive = 0;

        for(int i=0; i<originalStr.length()-1; i++){
            if(originalStr.charAt(i) == originalStr.charAt(i+1)){
                countConsecutive ++;
            } else {
                resultStr.append(originalStr.charAt(i));
                resultStr.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return resultStr.length() < originalStr.length()? resultStr.toString():originalStr;
    }

    public static void main(String[] args){
        StringCompress strCom = new StringCompress("what the heeeeeeeeeeeell");
        System.out.println(strCom.compress());
    }
}
