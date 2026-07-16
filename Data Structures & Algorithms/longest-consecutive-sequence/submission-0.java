class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> numSet = new HashSet<>();

        int longest = 0;
        int n = nums.length;

        for (int x : nums) {
            numSet.add(x);
        }

        for (int x : nums) {
            if (!numSet.contains(x - 1)) {
                int current = x;
                int len = 1;

                while (numSet.contains(current + 1)) {
                    current++;
                    len++;
                }

                longest = Math.max(longest, len);
            }
        }

        return  longest;
    }
}
