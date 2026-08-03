class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (hoursNeeded(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
    return left;

    }

    private long hoursNeeded(int[] piles, int k) {

        long hours = 0;
        for (int pile : piles) {
            hours = hours + (long)Math.ceil((double)pile / k);
        }

        return hours;
    }
}
