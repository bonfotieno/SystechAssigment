public class Combo_string {
    public static void main(String[] args) {
        String word1 = "This ";
        String word2 = "Marking ";
        System.out.println(combo_string(word1, word2));
    }

    static String combo_string(String str1, String str2){
        String combo_str = "";
        int str1_len = str1.length();
        int str2_len = str2.length();
        if (str1_len > str2_len ){
            combo_str = str2+str1+str2;
        }
        else{
            combo_str = str1+str2+str1;
        }
        return combo_str;
    }
}
