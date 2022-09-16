
/*
    Given an array of ints of odd length, look at the first, last,
    and middle values in the array and return the largest.
    The array length will be a least 1.
    maxTriple([1, 2, 3]) → 3
    maxTriple([1, 5, 3]) → 5
    maxTriple([5, 2, 3]) → 5
 */

public class Assignment6 {
    public static void main(String[] args) {
        int[] array_int = {23, 45, 56, 67, 23, 45, 50};
        System.out.println(Math.max(Math.max(array_int[0],array_int[array_int.length/2]),array_int[array_int.length-1]));
        System.out.println(array_int.length/2);
    }
}
