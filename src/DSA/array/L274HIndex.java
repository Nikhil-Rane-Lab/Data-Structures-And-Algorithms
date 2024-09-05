package DSA.array;

import java.util.Arrays;

//https://leetcode.com/problems/h-index
public class L274HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int length = citations.length;
        for (int i = 0; i < length; i++) {
            int h = length - i;  // The number of papers with citations >= citations[i]

            if (h >= citations[i]) {
                return h;
            }
        }

        return 0;
    }
}

//TC: O(nlogn) as sorting the array takes O(nlogn)
//SC: O(1)
