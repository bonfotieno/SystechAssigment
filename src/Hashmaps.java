import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Hashmaps {
    public static void main(String[] args) {
        HashMap<Integer, String> student = new HashMap<>(){{
            put(2, "bar");
            put(3, "value");
            put(5, "val");
            put(6, "vell");
            //System.out.println("THisnlake");
        }};


        var myValues = Map.of(
                4, "AB",
                5, "BC",
                6, "AB",
                7, "SK"
        );
        String ourDict = "";
        //System.out.println(myValues.containsValue("AB"));
        //System.out.println(student);
        for(Integer value: myValues.keySet()) {
            if (myValues.get(value).equals("AB")){
                ourDict += value+":"+myValues.get(value)+",";
            }
        }
        System.out.println("{"+ourDict+"}");
    }
}
