package DSA.twopointers;

//https://leetcode.com/problems/valid-palindrome/
public class L125ValidPalindrome {

    public boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            char leftChar = str.charAt(left);
            char rightChar = str.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else {
                if (leftChar != rightChar) {
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }
}

// TC: O(n), where 𝑛 n is the length of the input string. Each character is processed once.
// SC: O(1), as we are not using extra space apart from a few variables.
