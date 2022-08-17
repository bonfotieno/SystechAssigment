
/*
 Given a string, if a length 2 substring appears at both its beginning and end,
 return a string without the substring at the beginning, so "HelloHe" yields "lloHe".
 The substring may overlap with itself, so "Hi" yields "".
 Otherwise, return the original string unchanged.
 */

public class assignment1 {
    public static void main(String[] args) {
        String word2 = "He";
        System.out.println(without2(word2));
    }

    static String without2(String str){
        if (str.length() % 2 == 0){  // checks if the length is even
            if (str.length() > 2){
                return str.substring(2);
            }
            else{
               return "";
            }
        }
        else{
           return str;
        }
    }
}
