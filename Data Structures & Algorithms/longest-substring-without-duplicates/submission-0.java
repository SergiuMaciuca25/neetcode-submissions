class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> seen = new HashMap<>();

        int n = s.length();

        int left = 0;
        int max = 0;

        for (int right = 0; right < n; right++) {

            char currentChar = s.charAt(right);

            if (seen.containsKey(currentChar)) {
                int prevIndex = seen.get(currentChar);

                if (prevIndex >= left) {
                    left = prevIndex + 1;
                }

                

            }

            seen.put(currentChar, right);

            int currentSize = right - left + 1;

            if (currentSize > max) {
                max = currentSize;
            }
        }

        return max;
    }
}
