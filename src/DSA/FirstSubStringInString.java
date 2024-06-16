package DSA;

//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
public class FirstSubStringInString {

    public int getIndex(String str, String subStr) {
        for (int i = 0; i < str.length(); i++) {
            if (exists(str, subStr, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean exists(String str, String subStr, int index) {
        int end = index + subStr.length();
        if (end > str.length()) {
            return false;
        }
        String substring = str.substring(index, end);
        return subStr.equals(substring);
    }

// Other Approaches
// 1) One liner solution : return str.indexOf(subStr); 😂

}
