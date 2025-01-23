package DSA.array;

//https://leetcode.com/problems/reverse-words-in-a-string
public class L151ReverseWordsInAString {

    public String reverseWordsSpaceOptimal(String str) {
        // Step 1: Convert the string to a character array
        char[] charArr = str.toCharArray();
        int n = str.length();

        // Step 2: Reverse the entire string
        reverse(charArr, 0, n - 1);

        // Step 3: Reverse each word while skipping spaces
        int wordStart = 0, newLength = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != ' ') {  // Start of a word
                if (newLength > 0) {
                    charArr[newLength++] = ' '; // Add a space before the word
                }
                wordStart = newLength;
                while (i < n && charArr[i] != ' ') { // Copy the word
                    charArr[newLength++] = charArr[i++];
                }

                reverse(charArr, wordStart, newLength - 1); // Reverse the word
            }
        }

        // Return the processed string with the correct length
        return new String(charArr, 0, newLength);
    }

    private void reverse(char[] charArr, int left, int right) {
        while (left <= right) {
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left++;
            right--;
        }
    }
// TC: O(n)
// SC: O(1)

    public String reverseWords(String str) {
        String[] words = str.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (word.isEmpty()) {
                continue;
            }

            sb.append(word).append(" ");
        }

        return sb.toString().trim();
    }
// TC: O(n)
// SC: O(1)
}
