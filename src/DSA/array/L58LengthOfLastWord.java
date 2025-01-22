package DSA.array;

//https://leetcode.com/problems/length-of-last-word
public class L58LengthOfLastWord {

    // Approach 1 : With inbuilt functions
    public int lengthOfLastWord(String str) {
        str = str.trim();

        int lastIndexOfSpace = str.lastIndexOf(" ");
        return str.length() - lastIndexOfSpace - 1;
    }
// TC: O(n) Trimming and finding the last space both traverse the string once.
// SC: O(1)

    // Approach 2 : Without inbuilt functions
    public static int lengthOfLastWord2(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count characters in the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

// TC: O(n)
// SC: O(1)
}
