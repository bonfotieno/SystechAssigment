
/*
    Given 2 int arrays, a and b, of any length, return a new array with the first element of each array.
    If either array is length 0, ignore that array.
    front11([1, 2, 3], [7, 9, 8]) → [1, 7]
    front11([1], [2]) → [1, 2]
    front11([1, 7], []) → [1]
 */


public class Assignment7 {
    public static void main(String[] args) {
        int[] array1 = {56, 78, 89, 45, 45};
        int[] array2 = {67, 78, 56, 45, 34};
        int[] new_array = new int[2];
        new_array[0] = array1[0];
        new_array[1] = array2[array2.length-1];
        for (int i: new_array){
            System.out.println(i);
        }
    }
}
