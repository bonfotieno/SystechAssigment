public class reverse {
    public static void main(String[] args) {
        String word = new String("This word");
        System.out.println(reverse_str(word));
    }

    static String reverse_str(String word){
        String reversed_word = "";
        char[] c = word.toCharArray();
        int len_c = c.length;
        for (int k = len_c; k > 0; k--){
            reversed_word = reversed_word.concat(String.valueOf(c[k-1]));
        }
        return reversed_word;
    }
}
