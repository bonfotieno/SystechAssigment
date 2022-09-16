
/*
    Given an array of ints of odd length, return a new array length 3 containing the elements from
    the middle of the array.
    The array length will be at least 3
    midThree([1, 2, 3, 4, 5]) → [2, 3, 4]
    midThree([8, 6, 7, 5, 3, 0, 9]) → [7, 5, 3]
    midThree([1, 2, 3]) → [1, 2, 3]

 */

import java.util.ArrayList;
import java.util.Arrays;

public class Assignment5 {

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<Integer>(
                Arrays.asList(8, 3, 2, 4, 5, 8));

        int middle = myList.size()/2;
        System.out.println(myList.subList(middle-1,middle+2));

    }
}
