package DSA.other;

import java.util.ArrayList;
import java.util.List;

public class RansomNote {

    //Approach 1 (optimal)
    public boolean canConstructV1(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] countArr = new int[255];
        for (int i = 0; i < magazine.length(); i++) {
            countArr[magazine.charAt(i)]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (countArr[magazine.charAt(i)] <= 0) {
                return false;
            } else {
                countArr[magazine.charAt(i)]--;
            }
        }
        return true;
    }

    //Approach 2 (less optimal)
    public boolean canConstructV2(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < magazine.length(); i++) {
            charList.add(magazine.charAt(i));
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (charList.remove((Character) ransomNote.charAt(i))) {
                return false;
            }
        }

        return true;
    }

//    Approach 1 is more optimized than approach 2 because approach 1 uses constant TC
//    Approach 1)
//    a) TC: O(m+n) Where m is the length of the magazine string and n is the length of the ransomNote string.
//    b) SC: O(1)
}