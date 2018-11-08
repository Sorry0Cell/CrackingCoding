package chapter1;


/**
 * replace all spaces in a string with "20%", assume the string has enough spaces to hold additional characters
 *
 * @author andy
 * @date Nov 8th
 */

public class URLify {

    String str;
    int trueLen;
    int spaceNum = 0;

    public URLify(String str, int trueLen){
        this.str = str;
        this.trueLen = trueLen;
    }

    public String replaceSpaces(){
        int index = trueLen + spaceNum*2;
        char[] tempCharArray = str.toCharArray();
        for(int i=trueLen-1; i>=0; i--){
            if(tempCharArray[i] == ' '){
                tempCharArray[index-1] = '0';
                tempCharArray[index-2] = '2';
                tempCharArray[index-3] = '%';
                index -= 3;
            } else {
                tempCharArray[index-1] = tempCharArray[i];
                index--;
            }
        }
        char[] resultCharArray = new char[trueLen + spaceNum*2];

        //System.out.println(resultCharArray.length);

        for(int i=0; i<resultCharArray.length; i++){
            resultCharArray[i] = tempCharArray[i];
        }
        return String.valueOf(resultCharArray);
    }

    public int countSpace(){
        for(int i=0; i<trueLen; i++){
            if(str.charAt(i) == ' '){
                spaceNum++;
            }
        }
        return spaceNum;
    }

    public static void main(String[] args){
        URLify urLify = new URLify("name: andy, sex: male, age: 24  none of my business whatever", 30);
        System.out.println("original string length: " + urLify.str.length());
        System.out.println(urLify.str);

        urLify.countSpace();
        String resultString = urLify.replaceSpaces();
        System.out.println("\nafter replace spaces length: " + resultString.length());
        System.out.println(resultString);

    }
}
