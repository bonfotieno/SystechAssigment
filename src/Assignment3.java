
/*
    Given a string, return a version without the first 2 chars.
    Except keep the first char if it is 'a' and keep the second char if it is 'b'.
    The string may be any length. Harder than it looks.
    deFront("Hello") → "llo"
    deFront("java") → "va"
    deFront("away") → "aay"
 */

public class Assignment3 {
    public static void main(String[] args){
        System.out.println(deFront("rbtco"));
    }

    static String deFront(String str){
        char[] c = str.toCharArray();
        if (str.substring(0, 2).equals("ab")) {
            return str;
        } else if (c[0] == 'a'){
            return str.substring(0,1)+str.substring(2);
        } else if (c[1] == 'b') {
            return str.substring(1);
        } else {
            return str.substring(2);
        }
    }
}
