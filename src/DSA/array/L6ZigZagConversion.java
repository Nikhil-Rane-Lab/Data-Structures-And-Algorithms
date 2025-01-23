package DSA.array;

//https://leetcode.com/problems/zigzag-conversion
public class L6ZigZagConversion {

    public String convert(String str, int numRows) {

        if (str.isEmpty() || numRows == 1 || str.length() <= numRows) {
            return str;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        boolean goingDown = false; // 💡 this is false because of statement ⭐
        int currRow = 0;

        for (char c : str.toCharArray()) { // 🚀
            rows[currRow].append(c);

            // Reverse direction if at the top or bottom row
            if (currRow == 0 || currRow == numRows - 1) { // this is statement ⭐
                goingDown = !goingDown;
            }
            currRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb.toString());
        }

        return result.toString();
    }
}

//TC: O(n)
//SC: O(n)
