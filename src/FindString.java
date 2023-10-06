/* 10.5
Given a sorted array of strings that is interspersed with empty strings, write a
method to find the location of a given string. */

public class FindString {
    public static int search(String[] arr, String target) {
        if (arr == null || target == null || target.isEmpty()) {
            return -1; // Invalid input.
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // Handle empty strings in the middle.
            while (left <= right && arr[right].isEmpty()) {
                right--;
            }
            while (left <= right && arr[left].isEmpty()) {
                left++;
            }

            int mid = left + (right - left) / 2;

            // Move mid to the closest non-empty string.
            while (arr[mid].isEmpty() && left <= mid) {
                mid--;
            }
            if (mid < left) {
                left = mid + 1;
                continue;
            }

            int result = target.compareTo(arr[mid]);

            if (result == 0) {
                return mid; // Found the target string.
            } else if (result < 0) {
                right = mid - 1; // Target is to the left.
            } else {
                left = mid + 1; // Target is to the right.
            }
        }

        return -1; // Target string not found in the array.
    }

    public static void main(String[] args) {
        String[] arr = {"apple", "", "banana", "", "cherry", "date", "", "fig"};
        String target = "banana";
        int index = search(arr, target);

        if (index != -1) {
            System.out.println("String '" + target + "' found at index " + index);
        } else {
            System.out.println("String '" + target + "' not found");
        }
    }

}
