package DSA.binarysearch;

//Q) https://leetcode.com/problems/koko-eating-bananas
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int maximumHoursAllowed) {

        int left = 1; //⭐
        int right = getMaxPile(piles); //⭐ because if it is greater than the maxPile then he will have some time
        // remaining even after eating all the bananas from any pile which is wastage of surplus time as we want to
        // find MINIMUM eating speed
        int minEatingSpeed = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEatAllBananas(piles, mid, maximumHoursAllowed)) {
                minEatingSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minEatingSpeed; //you can return "left" also here and that also works!
    }

    private boolean canEatAllBananas(int[] piles,
                                     int eatingSpeedPerHour,
                                     int maximumHoursAllowed) {

        long hoursNeeded = 0; //⚠️ its datatype is long
        for (int pile : piles) {
            hoursNeeded += (pile + eatingSpeedPerHour - 1) / eatingSpeedPerHour; //⚠️ will have to memorize
        }

        return hoursNeeded <= maximumHoursAllowed;
    }

    private int getMaxPile(int[] piles) {
        int max = 0;

        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        return max;
    }

    //TC: O(log m) where m is the maximum number of bananas in a pile from the given piles
    //SC: O(1)
}
