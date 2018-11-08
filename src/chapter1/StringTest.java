package chapter1;

public class StringTest {
    public static void main(String[] args){
        String str1 = "ABC";
        String str2 = new String("ABC");

        int temp1 = 123;
        Integer temp2 = 123;

        System.out.println(temp2.equals(temp1));

        // == 比较的是内存地址
        // equals比较的是具体内容
        System.out.println(str1.equals(str2));

        char[] tempCharArray = str1.toCharArray();
        tempCharArray[1] = '\0';
        str1 = String.valueOf(tempCharArray);
        System.out.println(str1);

    }
}
