package DSA.other;

import java.util.HashSet;

public class HappyNumber {

    public boolean isHappy(int num) {
        if (num == 1) {
            return true;
        }

        HashSet<Integer> seenNumbersSet = new HashSet<>();
        seenNumbersSet.add(num);

        int sum = num;
        while (sum != 1) {
            sum = getSum(sum);
            if (!seenNumbersSet.add(sum)) {
                return false;
            }
        }

        return true;
    }

    private static int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            int lastDigit = num % 10;
            sum += (lastDigit * lastDigit);
            num = num / 10;
        }
        return sum;
    }

//    TC: O(logn)
//    SC: O(1)
}
