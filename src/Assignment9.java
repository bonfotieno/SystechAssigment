import java.util.LinkedHashMap;
import java.util.Map;

public class Assignment9 {
    /**
     * Given an array of strings, return a Map<String, Boolean> where each different string is a key
     * and its value is true if that string appears 2 or more times in the array.
     * <p>
     * wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
     * wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
     * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
     * **/
    public static Map<String, Boolean> wordMultiple(String[] str){
        Map<String, Boolean> strMap = new LinkedHashMap<>();
        int counter = 0;
        boolean appearsManyTimes=false;
        for (String currentStr : str) {
            for (String s0 : str) {
                if (currentStr.equals(s0)) {
                    counter+=1;
                }
            }
            if (counter>=2) {
                appearsManyTimes=true;
            }
            strMap.put(currentStr,appearsManyTimes);
            counter=0;
            appearsManyTimes=false;
        }
        return strMap;
    }

    public static void main(String[] args) {
        String[] s={"a", "b", "a", "c", "b"};
        System.out.println(wordMultiple(s));;
    }
}
