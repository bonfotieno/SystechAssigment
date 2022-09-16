import java.util.Arrays;
import java.util.List;

public class Assignment10 {
    /**
     * We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
     * Loop over and then return the given array of non-empty strings as follows: if a string matches
     * an earlier string in the array, swap the 2 strings in the array. When a position in the array
     * has been swapped, it no longer matches anything. Using a map, this can be solved making just one
     * pass over the array. More difficult than it looks.
     * <p>
     * allSwap(["ab", "ac"]) → ["ac", "ab"]
     * allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
     * allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]
     **/
    public String[] allSwap(String[] str){
        List<String> s = Arrays.asList(str);
        for (int i = 0; i < s.size(); i+=2) {
            s.subList(i,i+1);
        }
    }

    public static void main(String[] args) {
        String[] s = {"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"};
    }
}
