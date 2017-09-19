import java.util.Arrays;

public class InversionCount {

    /**
     * A mergesort implementation to count the number of inversions in the list
     * The array contains the same values as the linked list
     * 
     * @param array the original array
     * @param left the left half of the original array
     * @param right the right half of the original array
     * @return the number of inversions
     */
    static int merge(int[] array, int[] left, int[] right) {

        int i = 0;
        int j = 0;
        int count = 0;

        // as long as i is below left array length or j is below right array length
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                array[i+j] = right[j]; // put the value of right[j] into array[i+j]
                j++; // and increment j
            } else if (j == right.length) {
                array[i+j] = left[i]; // put the value of left[i] into array[i+j]
                i++; // and increment i
            } else if (left[i] <= right[j]) {
                array[i+j] = left[i]; // if value in left <= right put left in array[i+j]
                i++; // and increment i
            } else {
                array[i+j] = right[j]; // put right in array[i+j]
                count += left.length-i; // add left.length-i to count
                j++; // and increment j
            }
        }
        return count;
    }

    static int inversions(int[] array) {
        // if the array is smaller than two elements return 0 as we can't do anything about it
        if (array.length < 2) {
            return 0;
        }

        // prepare values to send to merge()
        int mid = (array.length + 1) / 2; // mid is length of the array split in two -> middle element
        int left[] = Arrays.copyOfRange(array, 0, mid); // left array is left half of the original array
        int right[] = Arrays.copyOfRange(array, mid, array.length); // right array is right half of the original array

        // return the inversion count of the mergesorted array through recursive calls
        return inversions(left) + inversions(right) + merge(array, left, right);
    }

}
