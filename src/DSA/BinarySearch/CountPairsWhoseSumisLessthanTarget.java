package DSA.BinarySearch;

import java.util.Collections;
import java.util.List;

public class CountPairsWhoseSumisLessthanTarget {

    public int solve1(List<Integer> numsList, int target) {

        int count = 0;
        for (int i = 0; i < numsList.size() - 1; i++) {
            for (int j = i + 1; j < numsList.size(); j++) {
                if (numsList.get(i) + numsList.get(j) < target) {
                    count++;
                }
            }
        }

        return count;
    }

    public int solve2(List<Integer> numsList, int target) {

        Collections.sort(numsList); //(1)
        int left = 0;
        int right = numsList.size() - 1;
        int count = 0;

        while (left < right) {
            if (numsList.get(left) + numsList.get(right) < target) {
                count += (right - left);
                left++; //(2)
            } else {
                right--;
            }
        }

        return count;
    }

/*
    2) left++ is done while keeping the right constant as we have sorted the arrayList so incrementing left will only
    take us closer to failure that is (sum >= target) so we do not need right++ in this case (as it will only increase the
    trouble by making sum greater i.e., sum >= target).

    Complexity Analysis
    SC = O(N) // as (1) has SC = O(N)
    TC = O(NLogN) as (1) has TC = O(nlogn) and is the dominating TC
*/
}
