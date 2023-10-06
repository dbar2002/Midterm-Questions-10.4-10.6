/* 10.4
Sorted Search, No Size: You are given an array like data structure Listy which lacks a size
method. It does, however, have an elementAt ( i) method that returns the element at index i in
0( 1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
structure only supports positive integers.) Given a Li sty which contains sorted, positive integers,
find the index at which an element x occurs. If x occurs multiple times, you may return any index. */

class Listy {
    private int[] arr;

    public Listy(int[] arr) {
        this.arr = arr;
    }

    public int elementAt(int i) {
        if (i >= 0 && i < arr.length) {
            return arr[i];
        }
        return -1;
    }
}

public class SortedSearchNoSize {

    public static int searchListy(Listy listy, int x) {
        int left = 0;
        int right = 1;

        // Expand the search range until we find the bounds.
        while (listy.elementAt(right) != -1 && listy.elementAt(right) < x) {
            left = right;
            right *= 2;
        }

        // Perform binary search within the identified range.
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = listy.elementAt(mid);

            if (midElement == x) {
                return mid; // Found x at index mid.
            } else if (midElement == -1 || midElement > x) {
                right = mid - 1; // Adjust the right boundary.
            } else {
                left = mid + 1; // Adjust the left boundary.
            }
        }

        return -1; // x is not in the Listy.
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        Listy sortedListy = new Listy(arr);
        int x = 9;
        int index = searchListy(sortedListy, x);
        if (index != -1) {
            System.out.println("Element " + x + " found at index " + index + ".");
        } else {
            System.out.println("Element " + x + " not found.");
        }
    }
}
