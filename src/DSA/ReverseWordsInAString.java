package DSA;

//https://leetcode.com/problems/reverse-words-in-a-string
public class ReverseWordsInAString {

    public String reverseWords(String str) {

        str = str.trim();
        String[] strArr = str.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (!strArr[i].isEmpty()) {
                sb.append(strArr[i]);

                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    // TC: O(N)
    // SC: O(N)
}
