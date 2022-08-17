public class ncharTwice {
    public static void main(String[] args) {
        int n = 2;
        String word2 = "Marks Marking";
        System.out.println(nTwice(word2, n));
    }

    static String nTwice(String str, int n){
        return str.substring(0,n) + str.substring(str.length()-n);
    }
}
