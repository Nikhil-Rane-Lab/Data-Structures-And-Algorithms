package DSA.bitmanipulation;

//https://leetcode.com/problems/add-binary
public class L67AddBinary {

    public String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0'; //⭐ it is character '0' not string "0"
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
// TC: O(max(i, j)), where i is the length of a and j is the length of b.
// This is because we are iterating over the length of the longer string.

// SC: O(max(i, j)), which is the space required for the result string.