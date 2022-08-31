import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class CompareString implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

public class Sorting {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Bonnie");
        stringList.add("Random");
        stringList.add("Text");
        stringList.add("EndPoint");
        System.out.println (stringList);
        stringList.sort(new CompareString());
    }
}
